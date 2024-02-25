package com.yuzarsif.fordevelopers.service;

import com.yuzarsif.fordevelopers.dto.CompanyApplyDto;
import com.yuzarsif.fordevelopers.dto.request.CreateApplyRequest;
import com.yuzarsif.fordevelopers.dto.EmployeeApplyDto;
import com.yuzarsif.fordevelopers.exception.AlreadyAppliedException;
import com.yuzarsif.fordevelopers.mapper.CompanyApplyDtoMapper;
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
        Employee employee = employeeService.getById(request.employeeId());

        checkAlreadyApply(employee.getId(), advertisement.getId());

        Apply apply = Apply
                .builder()
                .advertisement(advertisement)
                .employee(employee)
                .build();

        repository.save(apply);
    }

    private void checkAlreadyApply(String employeeId, Long advertisementId) {
        if (repository.findByEmployee_IdAndAdvertisement_Id(employeeId, advertisementId).isPresent()) {
            throw new AlreadyAppliedException("Already applied");
        }

    }

    public List<EmployeeApplyDto> findAllByEmployeeId(String employeeId) {
        employeeService.getById(employeeId);
        return repository.findAllByEmployeeId(employeeId)
                .stream()
                .map(EmployeeApplyDto::mapToEmployeeApplyDto)
                .collect(Collectors.toList());
    }

    public List<CompanyApplyDto> findAllByCompany(Long advertisementId) {
        return repository.findAllByAdvertisement_Id(advertisementId)
                .stream()
                .map(CompanyApplyDtoMapper.MAPPER::mapToCompanyApplyDto)
                .collect(Collectors.toList());
    }
}
