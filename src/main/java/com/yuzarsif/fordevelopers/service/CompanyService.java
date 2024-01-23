package com.yuzarsif.fordevelopers.service;

import com.yuzarsif.fordevelopers.dto.CompanyDto;
import com.yuzarsif.fordevelopers.dto.request.CreateCompanyRequest;
import com.yuzarsif.fordevelopers.exception.CompanyNotFoundException;
import com.yuzarsif.fordevelopers.mapper.CompanyDtoMapper;
import com.yuzarsif.fordevelopers.model.Company;
import com.yuzarsif.fordevelopers.repository.CompanyRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    private final CompanyRepository repository;

    public CompanyService(CompanyRepository repository) {
        this.repository = repository;
    }

    public void saveCompany(CreateCompanyRequest request) {
        Company company = Company
                .builder()
                .companyName(request.getCompanyName())
                .city(request.getCity())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
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
