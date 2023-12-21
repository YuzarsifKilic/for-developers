package com.yuzarsif.fordevelopers.service;

import com.yuzarsif.fordevelopers.dto.CompanyApplyDto;
import com.yuzarsif.fordevelopers.dto.CreateApplyRequest;
import com.yuzarsif.fordevelopers.dto.EmployeeApplyDto;
import com.yuzarsif.fordevelopers.mapper.CompanyApplyDtoMapper;
import com.yuzarsif.fordevelopers.mapper.EmployeeApplyDtoMapper;
import com.yuzarsif.fordevelopers.model.Advertisement;
import com.yuzarsif.fordevelopers.model.Apply;
import com.yuzarsif.fordevelopers.model.Employee;
import com.yuzarsif.fordevelopers.repository.ApplyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplyService {

    private final ApplyRepository repository;
    private final EmployeeService employeeService;
    private final AdvertisementService advertisementService;

    public ApplyService(ApplyRepository repository, EmployeeService employeeService, AdvertisementService advertisementService) {
        this.repository = repository;
        this.employeeService = employeeService;
        this.advertisementService = advertisementService;
    }

    public void saveApply(CreateApplyRequest request) {
        Advertisement advertisement = advertisementService.findById(request.advertisementId());
        Employee employee = employeeService.findById(request.employeeId());
        Apply apply = Apply
                .builder()
                .advertisement(advertisement)
                .employee(employee)
                .build();

        repository.save(apply);
    }

    public List<EmployeeApplyDto> findAllByEmployeeId(String employeeId) {
        employeeService.findById(employeeId);
        return repository.findAllByEmployeeId(employeeId)
                .stream()
                .map(EmployeeApplyDtoMapper.MAPPER::mapToEmployeeApplyDto)
                .collect(Collectors.toList());
    }

    public List<CompanyApplyDto> findAllByCompanyId(String companyId) {
        return repository.findAllByAdvertisement_Company_Id(companyId)
                .stream()
                .map(CompanyApplyDtoMapper.MAPPER::mapToCompanyApplyDto)
                .collect(Collectors.toList());
    }
}
