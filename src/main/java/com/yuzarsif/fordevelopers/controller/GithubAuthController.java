package com.yuzarsif.fordevelopers.controller;

import com.yuzarsif.fordevelopers.service.GithubClient;
import com.yuzarsif.fordevelopers.service.models.GithubAccessTokenRequest;
import com.yuzarsif.fordevelopers.service.models.GithubAccessTokenResponse;
import jakarta.servlet.http.HttpServletResponse;
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

    @PostMapping("/access_token")
    public GithubAccessTokenResponse getAccessToken(@RequestBody GithubAccessTokenRequest request) {
        return GithubAccessTokenResponse.builder().accessToken(githubClient.getAccessToken(request.getCode())).build();
    }
}
