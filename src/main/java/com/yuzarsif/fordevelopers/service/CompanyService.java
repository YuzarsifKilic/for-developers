package com.yuzarsif.fordevelopers.service;

import com.yuzarsif.fordevelopers.dto.CreateCompanyRequest;
import com.yuzarsif.fordevelopers.exception.CompanyNotFoundException;
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

    protected Company findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new CompanyNotFoundException(id));
    }
}
