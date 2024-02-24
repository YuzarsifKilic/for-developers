package com.yuzarsif.fordevelopers.controller;

import com.yuzarsif.fordevelopers.dto.EducationDto;
import com.yuzarsif.fordevelopers.dto.request.SaveEducationRequest;
import com.yuzarsif.fordevelopers.service.EducationService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/educations")
public class EducationController {

    private final EducationService educationService;

    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @PostMapping
    public ResponseEntity<Void> saveEducation(@Validated @RequestBody SaveEducationRequest request) {
        educationService.saveEducation(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<EducationDto>> findEducationsByEmployeeId(@PathVariable String employeeId) {
        return ResponseEntity.ok(educationService.findEducationsByEmployeeId(employeeId));
    }
}
