package com.yuzarsif.fordevelopers.service;

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

@Service
public class EmployeeService {

    private final EmployeeRepository repository;
    private final GithubClient githubClient;
    private SavedEmployeeMapper savedEmployeeMapper;

    public EmployeeService(EmployeeRepository repository, GithubClient githubClient) {
        this.repository = repository;
        this.githubClient = githubClient;
    }

    public SavedEmployeeDto createEmployee(CreateEmployeeRequest request) {

        githubClient.validateUser(request.getGithubUsername());

        Employee employee = Employee
                .builder()
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .phoneNumber(request.getPhoneNumber())
                .githubUsername(request.getGithubUsername())
                .role(Roles.EMPLOYEE)
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
