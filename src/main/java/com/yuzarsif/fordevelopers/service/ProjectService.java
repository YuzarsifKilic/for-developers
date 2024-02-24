package com.yuzarsif.fordevelopers.service;

import com.yuzarsif.fordevelopers.dto.EmployeeDto;
import com.yuzarsif.fordevelopers.dto.GithubUsernameCheckRequest;
import com.yuzarsif.fordevelopers.dto.request.CreateProjectRequest;
import com.yuzarsif.fordevelopers.dto.ProjectDto;
import com.yuzarsif.fordevelopers.exception.ProjectNotExistsException;
import com.yuzarsif.fordevelopers.model.Employee;
import com.yuzarsif.fordevelopers.model.Project;
import com.yuzarsif.fordevelopers.repository.ProjectRepository;
import com.yuzarsif.fordevelopers.service.models.GithubRepositoryResponse;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
        Employee employee = employeeService.getById(request.employeeId());

        Project project = Project
                .builder()
                .projectName(request.projectDescription())
                .projectDescription(request.projectDescription())
                .startDate(convertToDate(request.startDate()))
                .endDate(convertToDate(request.endDate()))
                .employee(employee)
                .repositoryUrl(request.repositoryUrl())
                .build();
        repository.save(project);
    }

    public List<GithubRepositoryResponse> findRepositories(String accessToken, String employeeId) {
        Employee employee = employeeService.getById(employeeId);
        List<GithubRepositoryResponse> repositories = githubClient.findRepositories(accessToken);

        List<ProjectDto> allByEmployeeId = findAllByEmployeeId(employeeId);

        for (GithubRepositoryResponse repository : repositories) {
            for (ProjectDto project : allByEmployeeId) {
                if (repository.getHtmlUrl().equals(project.projectUrl())) {
                    repositories.remove(repository);
                }
            }
        }

        return repositories;
    }

    public List<ProjectDto> findAllByEmployeeId(String employeeId) {
        return repository.findByEmployee_Id(employeeId)
                .stream()
                .map(ProjectDto::mapToProjectDto)
                .collect(Collectors.toList());
    }

    public ProjectDto findProjectById(Long id) {
        return ProjectDto.mapToProjectDto(getById(id));
    }

    public void deleteById(Long id) {
        getById(id);
        repository.deleteById(id);
    }

    private Project getById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ProjectNotExistsException("Project not found by id : " + id)
        );
    }

    private LocalDate convertToDate(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(date, formatter);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean validateUser(GithubUsernameCheckRequest request) {
        EmployeeDto employee = employeeService.findEmployeeById(request.employeeId());

        return githubClient.validateGithubUsername(request.accessToken(), employee.githubUsername());
    }
}
