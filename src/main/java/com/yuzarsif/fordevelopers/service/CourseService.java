package com.yuzarsif.fordevelopers.service;

import com.yuzarsif.fordevelopers.dto.CourseDto;
import com.yuzarsif.fordevelopers.mapper.CourseDtoMapper;
import com.yuzarsif.fordevelopers.model.Course;
import com.yuzarsif.fordevelopers.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public Course findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
    }

    public List<CourseDto> findAll() {
        return repository
                .findAll()
                .stream()
                .map(CourseDtoMapper.MAPPER::mapToCourseDto)
                .toList();
    }
}
