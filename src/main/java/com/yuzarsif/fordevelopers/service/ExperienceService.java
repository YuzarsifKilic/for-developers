package com.yuzarsif.fordevelopers.service;

import com.yuzarsif.fordevelopers.dto.CreateExperienceRequest;
import com.yuzarsif.fordevelopers.dto.ExperienceDto;
import com.yuzarsif.fordevelopers.mapper.ExperienceDtoMapper;
import com.yuzarsif.fordevelopers.model.Employee;
import com.yuzarsif.fordevelopers.model.Experience;
import com.yuzarsif.fordevelopers.repository.ExperienceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    private void saveExperience(CreateExperienceRequest request) {
        Employee employee = employeeService.findById(request.employeeId());

        Experience experience = Experience
                .builder()
                .companyName(request.companyName())
                .startYear(LocalDate.parse(request.startYear()))
                .endYear(LocalDate.parse(request.endYear()))
                .jobTitle(request.jobTitle())
                .employee(employee)
                .build();

        repository.save(experience);
    }

    public List<ExperienceDto> findExperiencesByEmployeeId(String employeeId) {
        return repository.findAllByEmployeeId(employeeId)
                .stream()
                .map(ExperienceDtoMapper.MAPPER::mapToExperienceDto)
                .collect(Collectors.toList());

    }
}
