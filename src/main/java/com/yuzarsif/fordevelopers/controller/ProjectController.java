package com.yuzarsif.fordevelopers.controller;

import com.yuzarsif.fordevelopers.dto.request.CreateProjectRequest;
import com.yuzarsif.fordevelopers.dto.ProjectDto;
import com.yuzarsif.fordevelopers.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<Void> saveProject(@RequestBody CreateProjectRequest request) {
        projectService.saveProject(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ProjectDto>> findProjectByEmployeeId(@PathVariable String id) {
        return ResponseEntity.ok(projectService.findAllByEmployeeId(id));
    }
}
