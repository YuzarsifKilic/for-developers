package com.yuzarsif.fordevelopers.controller;

import com.yuzarsif.fordevelopers.service.GithubClient;
import com.yuzarsif.fordevelopers.service.models.GithubAccessTokenRequest;
import com.yuzarsif.fordevelopers.service.models.GithubAccessTokenResponse;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/github")
public class GithubAuthController {

    private final GithubClient githubClient;

    public GithubAuthController(GithubClient githubClient) {
        this.githubClient = githubClient;
    }

    @GetMapping("/authorize")
    public void authorize(HttpServletResponse response) {
        response.setHeader("Location", githubClient.getAuthorizeUrl());
        response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
    }

    @GetMapping("/{code}")
    public ResponseEntity<String> extractGithubUsername(@PathVariable String code) {
        return ResponseEntity.ok(githubClient.extractGithubUsername(code));
    }
}
