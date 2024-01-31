package com.yuzarsif.fordevelopers.service;

import com.yuzarsif.fordevelopers.dto.request.CreateExperienceRequest;
import com.yuzarsif.fordevelopers.dto.ExperienceDto;
import com.yuzarsif.fordevelopers.exception.ExperienceNotFoundException;
import com.yuzarsif.fordevelopers.exception.ProjectNotExistsException;
import com.yuzarsif.fordevelopers.mapper.ExperienceDtoMapper;
import com.yuzarsif.fordevelopers.model.Employee;
import com.yuzarsif.fordevelopers.model.Experience;
import com.yuzarsif.fordevelopers.repository.ExperienceRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExperienceService {

    private final ExperienceRepository repository;
    private final EmployeeService employeeService;

    public ExperienceService(ExperienceRepository repository, EmployeeService employeeService) {
        this.repository = repository;
        this.employeeService = employeeService;
    }

    public void saveExperience(CreateExperienceRequest request) {
        Employee employee = employeeService.getById(request.employeeId());

        Experience experience = Experience
                .builder()
                .companyName(request.companyName())
                .startDate(convertToDate(request.startYear()))
                .endDate(convertToDate(request.endYear()))
                .jobTitle(request.jobTitle())
                .employee(employee)
                .build();

        repository.save(experience);
    }

    public List<ExperienceDto> findExperiencesByEmployeeId(String employeeId) {
        return repository.findAllByEmployeeId(employeeId)
                .stream()
                .map(ExperienceDto::mapToExperienceDto)
                .collect(Collectors.toList());
    }

    public ExperienceDto findExperienceById(Long id) {
        return ExperienceDtoMapper.MAPPER.mapToExperienceDto(getById(id));
    }

    public void deleteById(Long id) {
        getById(id);
        repository.deleteById(id);
    }

    private Experience getById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ExperienceNotFoundException("Experience not found by id : " + id)
        );
    }

    private Date convertToDate(String date) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
            return format.parse(date);
        } catch (ParseException e) {
            throw new ProjectNotExistsException("Project not found");
        }
    }
}
