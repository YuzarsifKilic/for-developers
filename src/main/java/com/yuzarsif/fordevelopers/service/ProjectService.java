package com.yuzarsif.fordevelopers.service;

import com.yuzarsif.fordevelopers.dto.CreateProjectRequest;
import com.yuzarsif.fordevelopers.exception.ProjectNotExistsException;
import com.yuzarsif.fordevelopers.model.Employee;
import com.yuzarsif.fordevelopers.model.Project;
import com.yuzarsif.fordevelopers.repository.ProjectRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    private final ProjectRepository repository;
    private final GithubClient githubClient;
    private final EmployeeService employeeService;

    public ProjectService(ProjectRepository repository, GithubClient githubClient, EmployeeService employeeService) {
        this.repository = repository;
        this.githubClient = githubClient;
        this.employeeService = employeeService;
    }

    public void saveProject(CreateProjectRequest request) {
        Employee employee = employeeService.findById(request.getEmployeeId());
        if (!githubClient.validateProjectUrl(employee.getGithubUsername(), request.getProjectUrl())) {
            throw new ProjectNotExistsException(String.format("%s is not exists in your repo", request.getProjectUrl()));
        }

        Project project = Project
                .builder()
                .projectName(request.getProjectName())
                .projectDescription(request.getProjectDescription())
                .startYear(request.getStartYear())
                .endYear(request.getEndYear())
                .employee(employee)
                .build();

        repository.save(project);
    }
}
