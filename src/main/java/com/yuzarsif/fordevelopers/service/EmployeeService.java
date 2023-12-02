package com.yuzarsif.fordevelopers.service;

import com.yuzarsif.fordevelopers.dto.CreateEmployeeRequest;
import com.yuzarsif.fordevelopers.exception.EmployeeNotFoundException;
import com.yuzarsif.fordevelopers.model.Employee;
import com.yuzarsif.fordevelopers.model.Roles;
import com.yuzarsif.fordevelopers.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public void saveEmployee(CreateEmployeeRequest request) {
        Employee employee = Employee
                .builder()
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .phoneNumber(request.getPhoneNumber())
                .githubUsername(request.getGithubUsername())
                .role(Roles.EMPLOYEE)
                .build();

        repository.save(employee);
    }

    protected Employee findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }
}
