package com.yuzarsif.fordevelopers.service;

import com.yuzarsif.fordevelopers.dto.request.CreateProjectRequest;
import com.yuzarsif.fordevelopers.dto.ProjectDto;
import com.yuzarsif.fordevelopers.exception.ProjectNotExistsException;
import com.yuzarsif.fordevelopers.mapper.ProjectDtoMapper;
import com.yuzarsif.fordevelopers.model.Employee;
import com.yuzarsif.fordevelopers.model.Project;
import com.yuzarsif.fordevelopers.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public ProjectDto saveProject(CreateProjectRequest request) {
        Employee employee = employeeService.getById(request.getEmployeeId());
        githubClient.validateProjectUrl(employee.getGithubUsername(), request.getProjectName());

        Project project = Project
                .builder()
                .projectName(request.getProjectName())
                .projectDescription(request.getProjectDescription())
                .startYear(convertToDate(request.getStartDate()))
                .endYear(convertToDate(request.getEndDate()))
                .employee(employee)
                .build();

        Project savedProject = repository.save(project);

        return ProjectDto
                .builder()
                .projectName(savedProject.getProjectName())
                .projectDescription(savedProject.getProjectDescription())
                .startDate(savedProject.getStartYear().toString())
                .endDate(savedProject.getEndYear().toString())
                .projectUrl(githubClient.getProjectUrl(savedProject.getEmployee().getGithubUsername(), savedProject.getProjectName()))
                .build();
    }

    public List<ProjectDto> findAllByEmployeeId(String employeeId) {
        return repository.findByEmployee_Id(employeeId)
                .stream()
                .map(ProjectDtoMapper.MAPPER::mapToProjectDto)
                .collect(Collectors.toList());
    }

    public ProjectDto findProjectById(Long id) {
        return ProjectDtoMapper.MAPPER.mapToProjectDto(getById(id));
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

    private Date convertToDate(String date) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("MM/yyyy");
            return format.parse(date);
        } catch (ParseException e) {
            throw new ProjectNotExistsException("Project not found");
        }

    }
}
