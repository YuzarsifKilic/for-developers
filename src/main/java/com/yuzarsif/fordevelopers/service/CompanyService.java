package com.yuzarsif.fordevelopers.service;

import com.yuzarsif.fordevelopers.dto.CompanyDto;
import com.yuzarsif.fordevelopers.dto.request.CreateCompanyRequest;
import com.yuzarsif.fordevelopers.exception.CompanyNotFoundException;
import com.yuzarsif.fordevelopers.mapper.CompanyDtoMapper;
import com.yuzarsif.fordevelopers.model.Company;
import com.yuzarsif.fordevelopers.model.Location;
import com.yuzarsif.fordevelopers.model.Roles;
import com.yuzarsif.fordevelopers.repository.CompanyRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    private final CompanyRepository repository;
    private final LocationService locationService;

    public CompanyService(CompanyRepository repository, LocationService locationService) {
        this.repository = repository;
        this.locationService = locationService;
    }

    public void saveCompany(CreateCompanyRequest request) {
        Location location = locationService.findLocationById(request.locationId());
        Company company = Company
                .builder()
                .companyName(request.companyName())
                .email(request.email())
                .phoneNumber(request.phoneNumber())
                .location(location)
                .role(Roles.COMPANY)
                .build();

        repository.save(company);
    }

    public CompanyDto findCompanyById(String id) {
        Company company = getById(id);
        return CompanyDtoMapper.MAPPER.mapToCompanyDto(company);
    }

    public void deleteById(String id) {
        getById(id);
        repository.deleteById(id);
    }

    protected Company getById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new CompanyNotFoundException(id));
    }
}
