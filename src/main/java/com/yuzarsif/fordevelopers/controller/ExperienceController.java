package com.yuzarsif.fordevelopers.controller;

import com.yuzarsif.fordevelopers.dto.ExperienceDto;
import com.yuzarsif.fordevelopers.dto.request.CreateExperienceRequest;
import com.yuzarsif.fordevelopers.service.ExperienceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/experiences")
public class ExperienceController {

    private final ExperienceService experienceService;

    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @PostMapping
    public ResponseEntity<Void> createExperience(@RequestBody CreateExperienceRequest request) {
        experienceService.saveExperience(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ExperienceDto>> findExperiencesByEmployeeId(@PathVariable String id) {
        return ResponseEntity.ok(experienceService.findExperiencesByEmployeeId(id));
    }
}
