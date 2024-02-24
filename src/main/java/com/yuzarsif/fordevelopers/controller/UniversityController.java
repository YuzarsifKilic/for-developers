package com.yuzarsif.fordevelopers.controller;

import com.yuzarsif.fordevelopers.dto.UniversityDto;
import com.yuzarsif.fordevelopers.dto.request.CreateUniversityRequest;
import com.yuzarsif.fordevelopers.service.UniversityService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/universities")
public class UniversityController {

    private final UniversityService universityService;

    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping
    public ResponseEntity<List<UniversityDto>> findAll() {
        return ResponseEntity.ok(universityService.findAll());
    }

    @PostMapping
    public ResponseEntity<Void> saveUniversity(@Validated @RequestBody CreateUniversityRequest request) {
        universityService.saveUniversity(request);
        return ResponseEntity.ok().build();
    }
}
