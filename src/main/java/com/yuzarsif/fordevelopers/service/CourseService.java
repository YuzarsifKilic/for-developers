package com.yuzarsif.fordevelopers.service;

import com.yuzarsif.fordevelopers.dto.CourseDto;
import com.yuzarsif.fordevelopers.dto.request.CreateCourseRequest;
import com.yuzarsif.fordevelopers.mapper.CourseDtoMapper;
import com.yuzarsif.fordevelopers.model.Course;
import com.yuzarsif.fordevelopers.model.University;
import com.yuzarsif.fordevelopers.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class CourseService {

    private final CourseRepository repository;
    private final UniversityService universityService;

    public CourseService(CourseRepository repository, UniversityService universityService) {
        this.repository = repository;
        this.universityService = universityService;
    }

    public void save(CreateCourseRequest request) {
        University university = universityService.findById(request.universityId());

        Course course = Course.builder()
                .courseName(request.courseName())
                .build();

        university.setCourses(Collections.singleton(course));

        universityService.updateUniversity(university);

        repository.save(course);
    }


    public List<CourseDto> findByUniversities(Integer universityId) {
        University university = universityService.findById(universityId);

        return repository
                .findCoursesByUniversityId(universityId)
                .stream()
                .map(CourseDtoMapper.MAPPER::mapToCourseDto)
                .toList();
    }

    public Course findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
    }
}
