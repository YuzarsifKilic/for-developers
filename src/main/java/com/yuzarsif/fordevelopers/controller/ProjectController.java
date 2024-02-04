package com.yuzarsif.fordevelopers.controller;

import com.yuzarsif.fordevelopers.dto.request.CreateProjectRequest;
import com.yuzarsif.fordevelopers.dto.ProjectDto;
import com.yuzarsif.fordevelopers.service.GithubClient;
import com.yuzarsif.fordevelopers.service.ProjectService;
import com.yuzarsif.fordevelopers.service.models.GithubRepositoryResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;
    private final GithubClient githubClient;

    public ProjectController(ProjectService projectService, GithubClient githubClient) {
        this.projectService = projectService;
        this.githubClient = githubClient;
    }

    @PostMapping
    public ResponseEntity<Void> saveProject(@RequestBody CreateProjectRequest request) {
        projectService.saveProject(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<List<ProjectDto>> findProjectByEmployeeId(@PathVariable String id) {
        return ResponseEntity.ok(projectService.findAllByEmployeeId(id));
    }

    @GetMapping("/{access_token}")
    public ResponseEntity<List<GithubRepositoryResponse>> findRepositories(@PathVariable String access_token) {
        return ResponseEntity.ok(githubClient.findRepositories(access_token));
    }
}
