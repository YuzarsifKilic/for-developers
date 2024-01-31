package com.yuzarsif.fordevelopers.service;

import com.yuzarsif.fordevelopers.dto.AdvertisementDto;
import com.yuzarsif.fordevelopers.dto.request.CreateAdvertisementRequest;
import com.yuzarsif.fordevelopers.exception.AdvertisementNotFoundException;
import com.yuzarsif.fordevelopers.mapper.AdvertisementDtoMapper;
import com.yuzarsif.fordevelopers.model.Advertisement;
import com.yuzarsif.fordevelopers.model.Company;
import com.yuzarsif.fordevelopers.repository.AdvertisementRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdvertisementService {

    private final AdvertisementRepository repository;
    private final CompanyService companyService;

    public AdvertisementService(AdvertisementRepository repository, CompanyService companyService) {
        this.repository = repository;
        this.companyService = companyService;
    }

    public void saveAdvertisement(CreateAdvertisementRequest request) {
        Company company = companyService.getById(request.companyId());

        Advertisement advertisement = Advertisement
                .builder()
                .company(company)
                .advertisementTitle(request.advertisementTitle())
                .advertisementContent(request.advertisementContent())
                .viewCount(0)
                .open(true)
                .workType(request.workType())
                .jobTitle(request.jobTitle())
                .build();

        repository.save(advertisement);
    }

    public List<AdvertisementDto> findAllByCompanyId(String companyId) {
        return repository.findAllByCompany_Id(companyId)
                .stream()
                .map(AdvertisementDtoMapper.MAPPER::mapToAdvertisementDto)
                .collect(Collectors.toList());
    }

    public AdvertisementDto findByAdvertisementId(Long advertisementId) {
        return AdvertisementDtoMapper.MAPPER.mapToAdvertisementDto(findById(advertisementId));
    }

    public void incrementViewCount(Long advertisementId) {
        Advertisement advertisement = findById(advertisementId);
        advertisement.setViewCount(advertisement.getViewCount() + 1);
        repository.save(advertisement);
    }

    public List<AdvertisementDto> findMostPopularAdvertisements() {
        return repository.findTop20ByOrderByViewCountDesc()
                .stream()
                .map(AdvertisementDtoMapper.MAPPER::mapToAdvertisementDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteById(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    protected Advertisement findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new AdvertisementNotFoundException(String.format("Advertisement not found with id: %s", id)));
    }
}
