package com.yuzarsif.fordevelopers.service;

import com.yuzarsif.fordevelopers.config.PasswordConfig;
import com.yuzarsif.fordevelopers.dto.request.CreateEmployeeRequest;
import com.yuzarsif.fordevelopers.dto.EmployeeDto;
import com.yuzarsif.fordevelopers.dto.SavedEmployeeDto;
import com.yuzarsif.fordevelopers.dto.request.UpdateEmployeeRequest;
import com.yuzarsif.fordevelopers.exception.EmailInUseException;
import com.yuzarsif.fordevelopers.exception.EmployeeNotFoundException;
import com.yuzarsif.fordevelopers.exception.PhoneNumberInUseException;
import com.yuzarsif.fordevelopers.mapper.EmployeeDtoMapper;
import com.yuzarsif.fordevelopers.mapper.SavedEmployeeMapper;
import com.yuzarsif.fordevelopers.model.BaseUser;
import com.yuzarsif.fordevelopers.model.Education;
import com.yuzarsif.fordevelopers.model.Employee;
import com.yuzarsif.fordevelopers.model.Roles;
import com.yuzarsif.fordevelopers.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;
    private final GithubClient githubClient;
    private final PasswordConfig passwordConfig;
    private final BaseUserService baseUserService;

    public EmployeeService(EmployeeRepository repository,
                           GithubClient githubClient,
                           PasswordConfig passwordConfig,
                           BaseUserService baseUserService) {
        this.repository = repository;
        this.githubClient = githubClient;
        this.passwordConfig = passwordConfig;
        this.baseUserService = baseUserService;
    }

    public SavedEmployeeDto createEmployee(CreateEmployeeRequest request) {

        baseUserService.emailInUse(request.email());
        phoneNumberInUse(request.phoneNumber());
        githubUsernameInUse(request.githubUsername());

        Employee employee = Employee
                .builder()
                .email(request.email())
                .password(passwordConfig.passwordEncoder().encode(request.password()))
                .firstName(request.firstName())
                .lastName(request.lastName())
                .phoneNumber(request.phoneNumber())
                .githubUsername(request.githubUsername())
                .authorities(Set.of(Roles.ROLE_EMPLOYEE))
                .build();

        return SavedEmployeeMapper.MAPPER.mapToSavedEmployeeDto(repository.save(employee));
    }

    public EmployeeDto findEmployeeById(String id) {
        Employee employee = getById(id);
        return EmployeeDtoMapper.MAPPER.mapToEmployeeDto(employee);
    }

    public void deleteById(String id) {
        getById(id);
        repository.deleteById(id);
    }

    public void updateEmployee(String id, UpdateEmployeeRequest request) {
        Employee employee = getById(id);
        if (request.email() != null && !request.email().equals(employee.getEmail())) {
            baseUserService.emailInUse(request.email());
            employee.setEmail(request.email());
        }
        if (request.firstName() != null && !request.firstName().equals(employee.getFirstName())) {
            employee.setFirstName(request.firstName());
        }
        if (request.lastName() != null && !request.lastName().equals(employee.getLastName())) {
            employee.setLastName(request.lastName());
        }
        if (request.phoneNumber() != null && !request.phoneNumber().equals(employee.getPhoneNumber())) {
            phoneNumberInUse(request.phoneNumber());
            employee.setPhoneNumber(request.phoneNumber());
        }

        repository.save(employee);
    }

    protected Employee getById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    private void phoneNumberInUse(String phoneNumber) {
        repository.findByPhoneNumber(phoneNumber)
                .ifPresent(user -> {
                    throw new PhoneNumberInUseException("phone number already in use");
                });
    }

    private void githubUsernameInUse(String githubUsername) {
        repository.findByGithubUsername(githubUsername)
                .ifPresent(user -> {
                    throw new EmailInUseException("github username already in use");
                });
    }
}
