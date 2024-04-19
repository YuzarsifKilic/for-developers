package com.yuzarsif.fordevelopers.controller;

import com.yuzarsif.fordevelopers.dto.request.Oauth2TokenSaveRequest;
import com.yuzarsif.fordevelopers.service.GithubClient;
import com.yuzarsif.fordevelopers.service.GithubTokenService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/github")
public class GithubAuthController {

    private final GithubClient githubClient;
    private final GithubTokenService githubTokenService;

    public GithubAuthController(GithubClient githubClient, GithubTokenService githubTokenService) {
        this.githubClient = githubClient;
        this.githubTokenService = githubTokenService;
    }

    @GetMapping("/authorize")
    public ResponseEntity<String> authorize() {
        return ResponseEntity.ok(githubClient.getAuthorizeUrl());
    }

    @PostMapping("/code")
    public ResponseEntity<Void> createAccessToken(@RequestBody Oauth2TokenSaveRequest request) {
        githubTokenService.saveToken(request);
        return ResponseEntity.ok().build();
    }
}
