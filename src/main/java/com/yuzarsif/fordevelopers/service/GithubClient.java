package com.yuzarsif.fordevelopers.service;

import com.yuzarsif.fordevelopers.config.GithubProperties;
import com.yuzarsif.fordevelopers.exception.GithubValidateException;
import com.yuzarsif.fordevelopers.exception.GlobalExceptionHandler;
import com.yuzarsif.fordevelopers.service.models.GithubAccessTokenRequest;
import com.yuzarsif.fordevelopers.service.models.GithubAccessTokenResponse;
import com.yuzarsif.fordevelopers.service.models.GithubProjectResponse;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class GithubClient {

    private final RestTemplate restTemplate;
    private final GithubProperties githubProperties;

    public GithubClient(RestTemplate restTemplate, GithubProperties githubProperties) {
        this.restTemplate = restTemplate;
        this.githubProperties = githubProperties;
    }

    public String getAuthorizeUrl() {
        return String.format("%s/?client_id=%s", githubProperties.getAuthorizeUrl(), githubProperties.getClientId());
    }

    public String getAccessToken(String code) {
        GithubAccessTokenRequest accessTokenRequest = GithubAccessTokenRequest
                .builder()
                .clientId(githubProperties.getClientId())
                .clientSecret(githubProperties.getClientSecret())
                .code(code)
                .build();
        HttpEntity<GithubAccessTokenRequest> request = new HttpEntity<>(accessTokenRequest);
        ResponseEntity<GithubAccessTokenResponse> exchange = restTemplate.exchange(githubProperties.getAccessTokenUrl(), HttpMethod.POST, request, GithubAccessTokenResponse.class);
        return Objects.requireNonNull(exchange.getBody()).getAccessToken();
    }

    public void validateUser(String githubUsername) {
        String userUrl = String.format("%s/users/%s", githubProperties.getApiUrl(), githubUsername);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "token " + githubProperties.getToken());
        HttpEntity request = new HttpEntity(httpHeaders);

        try {
            ResponseEntity<String> response = restTemplate.exchange(userUrl, HttpMethod.GET, request, String.class);
        } catch (HttpClientErrorException e) {
            throw new GithubValidateException(String.format("User %s not found", githubUsername));
        }
    }

    public void validateProjectUrl(String githubUsername, String project) {
        String projectUrl = getProjectUrl(githubUsername, project);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "token " + githubProperties.getToken());
        HttpEntity request = new HttpEntity(httpHeaders);

        try {
            ResponseEntity<String> response = restTemplate.exchange(projectUrl, HttpMethod.GET, request, String.class);
        } catch (HttpClientErrorException e) {
            throw new GithubValidateException(String.format("Project %s not found", project));
        }
    }

    public String getProjectUrl(String githubUsername, String project) {
        return String.format("%s/%s/%s", githubProperties.getHtmlUrl(), githubUsername, project);
    }
}
