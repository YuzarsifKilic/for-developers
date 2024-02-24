package com.yuzarsif.fordevelopers.controller;

import com.yuzarsif.fordevelopers.dto.CourseDto;
import com.yuzarsif.fordevelopers.dto.request.CreateCourseRequest;
import com.yuzarsif.fordevelopers.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/university/{universityId}")
    public ResponseEntity<List<CourseDto>> findCoursesByUniversityId(@PathVariable Integer universityId) {
        return ResponseEntity.ok(courseService.findByUniversities(universityId));
    }

    @PostMapping
    public ResponseEntity<Void> saveCourse(@Validated @RequestBody CreateCourseRequest request) {
        courseService.save(request);
        return ResponseEntity.ok().build();
    }
}
