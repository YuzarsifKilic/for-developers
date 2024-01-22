package com.yuzarsif.fordevelopers.service;

import com.yuzarsif.fordevelopers.dto.EducationDto;
import com.yuzarsif.fordevelopers.dto.request.SaveEducationRequest;
import com.yuzarsif.fordevelopers.mapper.EducationDtoMapper;
import com.yuzarsif.fordevelopers.model.Education;
import com.yuzarsif.fordevelopers.model.Employee;
import com.yuzarsif.fordevelopers.model.University;
import com.yuzarsif.fordevelopers.repository.EducationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService {

    private final EducationRepository repository;
    private final UniversityService universityService;
    private final EmployeeService employeeService;

    public EducationService(EducationRepository repository,
                            UniversityService universityService,
                            EmployeeService employeeService) {
        this.repository = repository;
        this.universityService = universityService;
        this.employeeService = employeeService;
    }

    public void saveEducation(SaveEducationRequest request) {
        University university = universityService.findById(request.universityId());
        Employee employee = employeeService.getById(request.employeeId());

        Education education = Education
                .builder()
                .university(university)
                .startYear(request.startYear())
                .endYear(request.endYear())
                .gnp(request.gnp())
                .employee(employee)
                .build();

        repository.save(education);
    }

    public List<EducationDto> findEducationsByEmployeeId(String employeeId) {
        return repository
                .findAllByEmployeeId(employeeId)
                .stream()
                .map(EducationDtoMapper.MAPPER::mapToEducationDto)
                .toList();
    }
}
