package com.yuzarsif.fordevelopers.service;

import com.yuzarsif.fordevelopers.dto.UniversityDto;
import com.yuzarsif.fordevelopers.dto.request.CreateUniversityRequest;
import com.yuzarsif.fordevelopers.exception.UniversityNotFoundException;
import com.yuzarsif.fordevelopers.mapper.UniversityDtoMapper;
import com.yuzarsif.fordevelopers.model.University;
import com.yuzarsif.fordevelopers.repository.UniversityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityService {

    private final UniversityRepository repository;

    public UniversityService(UniversityRepository repository) {
        this.repository = repository;
    }

    public University findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new UniversityNotFoundException("University not found with id: " + id));
    }

    public List<UniversityDto> findAll() {
        return repository
                .findAll()
                .stream()
                .map(UniversityDtoMapper.MAPPER::mapToUniversityDto)
                .toList();
    }

    public void saveUniversity(CreateUniversityRequest request) {
        University university = University.builder()
                .universityName(request.universityName())
                .build();

        repository.save(university);
    }

    public void updateUniversity(University university) {
        repository.save(university);
    }
}
