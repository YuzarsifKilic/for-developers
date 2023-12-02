package com.yuzarsif.fordevelopers.service;

import com.yuzarsif.fordevelopers.dto.SaveSocialMediaRequest;
import com.yuzarsif.fordevelopers.model.Employee;
import com.yuzarsif.fordevelopers.model.SocialMedia;
import com.yuzarsif.fordevelopers.repository.SocialMediaRepository;
import org.springframework.stereotype.Service;

@Service
public class SocialMediaService {

    private final SocialMediaRepository repository;
    private final EmployeeService employeeService;

    public SocialMediaService(SocialMediaRepository repository, EmployeeService employeeService) {
        this.repository = repository;
        this.employeeService = employeeService;
    }

    public void saveSocialMedia(SaveSocialMediaRequest request) {
        Employee employee = employeeService.findById(request.getEmployeeId());

        SocialMedia socialMedia = SocialMedia
                .builder()
                .url(request.getUrl())
                .socialMedia(request.getSocialMedia())
                .employee(employee)
                .build();

        repository.save(socialMedia);
    }
}
