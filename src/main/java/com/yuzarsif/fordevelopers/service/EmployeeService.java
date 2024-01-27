package com.yuzarsif.fordevelopers.service;

import com.yuzarsif.fordevelopers.config.PasswordConfig;
import com.yuzarsif.fordevelopers.dto.request.CreateEmployeeRequest;
import com.yuzarsif.fordevelopers.dto.EmployeeDto;
import com.yuzarsif.fordevelopers.dto.SavedEmployeeDto;
import com.yuzarsif.fordevelopers.exception.EmployeeNotFoundException;
import com.yuzarsif.fordevelopers.mapper.EmployeeDtoMapper;
import com.yuzarsif.fordevelopers.mapper.SavedEmployeeMapper;
import com.yuzarsif.fordevelopers.model.Employee;
import com.yuzarsif.fordevelopers.model.Roles;
import com.yuzarsif.fordevelopers.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;
    private final GithubClient githubClient;
    private final PasswordConfig passwordConfig;

    public EmployeeService(EmployeeRepository repository, GithubClient githubClient, PasswordConfig passwordConfig) {
        this.repository = repository;
        this.githubClient = githubClient;
        this.passwordConfig = passwordConfig;
    }

    public SavedEmployeeDto createEmployee(CreateEmployeeRequest request) {

        githubClient.validateUser(request.githubUsername());

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

    protected Employee getById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }
}
