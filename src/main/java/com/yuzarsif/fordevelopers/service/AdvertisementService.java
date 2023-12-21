package com.yuzarsif.fordevelopers.service;

import com.yuzarsif.fordevelopers.dto.CreateAdvertisementRequest;
import com.yuzarsif.fordevelopers.exception.AdvertisementNotFoundException;
import com.yuzarsif.fordevelopers.model.Advertisement;
import com.yuzarsif.fordevelopers.model.Company;
import com.yuzarsif.fordevelopers.repository.AdvertisementRepository;
import org.springframework.stereotype.Service;

@Service
public class AdvertisementService {

    private final AdvertisementRepository repository;
    private final CompanyService companyService;

    public AdvertisementService(AdvertisementRepository repository, CompanyService companyService) {
        this.repository = repository;
        this.companyService = companyService;
    }

    public void saveAdvertisement(CreateAdvertisementRequest request) {
        Company company = companyService.findById(request.companyId());

        Advertisement advertisement = Advertisement
                .builder()
                .company(company)
                .advertisementTitle(request.advertisementTitle())
                .advertisementContent(request.advertisementContent())
                .workType(request.workType())
                .jobTitle(request.jobTitle())
                .build();

        repository.save(advertisement);
    }

    protected Advertisement findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new AdvertisementNotFoundException(id));
    }
}
