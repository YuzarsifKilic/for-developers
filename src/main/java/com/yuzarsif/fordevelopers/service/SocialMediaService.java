package com.yuzarsif.fordevelopers.service;

import com.yuzarsif.fordevelopers.dto.SocialMediaDto;
import com.yuzarsif.fordevelopers.dto.request.SaveSocialMediaRequest;
import com.yuzarsif.fordevelopers.exception.GithubValidateException;
import com.yuzarsif.fordevelopers.mapper.SocialMediaDtoMapper;
import com.yuzarsif.fordevelopers.model.Employee;
import com.yuzarsif.fordevelopers.model.SocialMedia;
import com.yuzarsif.fordevelopers.repository.SocialMediaRepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class SocialMediaService {

    private final SocialMediaRepository repository;
    private final EmployeeService employeeService;

    public SocialMediaService(SocialMediaRepository repository, EmployeeService employeeService) {
        this.repository = repository;
        this.employeeService = employeeService;
    }

    public void saveSocialMedia(SaveSocialMediaRequest request) {
        Employee employee = employeeService.getById(request.getEmployeeId());

        SocialMedia socialMedia = SocialMedia
                .builder()
                .url(request.getUrl())
                .socialMedia(request.getSocialMedia())
                .employee(employee)
                .build();

        repository.save(socialMedia);
    }

    public void deleteById(Long id) {
        getById(id);
        repository.deleteById(id);
    }

    private void getById(Long id) {
        repository.findById(id).orElseThrow(() -> new GithubValidateException("Social media not found by id : " + id));
    }

    public List<SocialMediaDto> findAllByEmployeeId(String employeeId) {
        return repository.findAllByEmployeeId(employeeId)
                .stream()
                .map(SocialMediaDtoMapper.MAPPER::mapToSocialMediaDto)
                .toList();
    }
}
