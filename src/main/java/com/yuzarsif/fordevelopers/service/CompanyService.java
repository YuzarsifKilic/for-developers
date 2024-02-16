package com.yuzarsif.fordevelopers.service;

import com.yuzarsif.fordevelopers.config.PasswordConfig;
import com.yuzarsif.fordevelopers.dto.CompanyDto;
import com.yuzarsif.fordevelopers.dto.request.CreateCompanyRequest;
import com.yuzarsif.fordevelopers.dto.request.UpdateCompanyRequest;
import com.yuzarsif.fordevelopers.exception.CompanyNameInUseException;
import com.yuzarsif.fordevelopers.exception.CompanyNotFoundException;
import com.yuzarsif.fordevelopers.exception.PhoneNumberInUseException;
import com.yuzarsif.fordevelopers.mapper.CompanyDtoMapper;
import com.yuzarsif.fordevelopers.model.Company;
import com.yuzarsif.fordevelopers.model.Roles;
import com.yuzarsif.fordevelopers.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CompanyService {

    private final CompanyRepository repository;
    private final LocationService locationService;
    private final PasswordConfig passwordConfig;
    private final BaseUserService baseUserService;

    public CompanyService(CompanyRepository repository,
                          LocationService locationService,
                          PasswordConfig passwordConfig,
                          BaseUserService baseUserService) {
        this.repository = repository;
        this.locationService = locationService;
        this.passwordConfig = passwordConfig;
        this.baseUserService = baseUserService;
    }

    public void saveCompany(CreateCompanyRequest request) {
        baseUserService.emailInUse(request.email());

        companyNameInUse(request.companyName());
        phoneNumberInUse(request.phoneNumber());

        Company company = Company
                .builder()
                .companyName(request.companyName())
                .email(request.email())
                .password(passwordConfig.passwordEncoder().encode(request.password()))
                .phoneNumber(request.phoneNumber())
                .authorities(Set.of(Roles.ROLE_COMPANY))
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

    public void updateCompany(String id, UpdateCompanyRequest request) {
        Company company = getById(id);

        if (request.companyName() != null) {
            companyNameInUse(request.companyName());
            company.setCompanyName(request.companyName());
        }
        if (request.phoneNumber() != null) {
            phoneNumberInUse(request.phoneNumber());
            company.setPhoneNumber(request.phoneNumber());
        }
        if (request.email() != null) {
            baseUserService.emailInUse(request.email());
            company.setEmail(request.email());
        }

        repository.save(company);
    }

    protected Company getById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new CompanyNotFoundException(id));
    }

    private void phoneNumberInUse(String phoneNumber) {
        repository
                .findByPhoneNumber(phoneNumber)
                .ifPresent(company -> {
                    throw new PhoneNumberInUseException("phone number already in use");
                });
    }

    private void companyNameInUse(String companyName) {
        repository
                .findByCompanyName(companyName)
                .ifPresent(company -> {
                    throw new CompanyNameInUseException("company name already in use");
                });
    }

}
