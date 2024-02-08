package com.yuzarsif.fordevelopers.service;

import com.yuzarsif.fordevelopers.config.GithubProperties;
import com.yuzarsif.fordevelopers.exception.GithubValidateException;
import com.yuzarsif.fordevelopers.service.models.*;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
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
        return String.format("%s/?client_id=%s&redirect_uri=http://localhost:4200/auth/github/callback", githubProperties.getAuthorizeUrl(), githubProperties.getClientId());
    }

    public void validateUser(String githubUsername) {
        String userUrl = String.format("%s/users/%s", githubProperties.getApiUrl(), githubUsername);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "token " + githubProperties.getToken());
        HttpEntity request = new HttpEntity(httpHeaders);

        try {
            ResponseEntity<String> response = restTemplate.exchange(userUrl, HttpMethod.GET, request, String.class);
        } catch (HttpClientErrorException e) {
            throw new GithubValidateException(String.format("Github user %s not found", githubUsername));
        }
    }

    protected boolean validateGithubUsername(String code, String githubUsername) {
        String githubUser = extractGithubUsername(code);

        return Objects.equals(githubUser, githubUsername);
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

    public List<GithubRepositoryResponse> findRepositories(String code) {
        String accessToken = getAccessToken(code);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer " + accessToken);

        HttpEntity request = new HttpEntity(httpHeaders);

        try {
            ResponseEntity<GithubUserResponse> repositoryUrl = restTemplate.exchange(githubProperties.getApiUrl() + "/user", HttpMethod.GET, request, GithubUserResponse.class);
            ResponseEntity<GithubRepositoryResponse[]> response = restTemplate.exchange(repositoryUrl.getBody().getReposUrl(), HttpMethod.GET, request, GithubRepositoryResponse[].class);
            return List.of(response.getBody());
        } catch (HttpClientErrorException e) {
            throw new GithubValidateException("Access token is expired");
        }
    }

    public String extractGithubUsername(String code) {
        String accessToken = getAccessToken(code);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer " + accessToken);

        HttpEntity request = new HttpEntity(httpHeaders);

        try {
            ResponseEntity<GithubUserResponse> repositoryUrl = restTemplate.exchange(githubProperties.getApiUrl() + "/user", HttpMethod.GET, request, GithubUserResponse.class);
            return repositoryUrl.getBody().getLogin();
        } catch (HttpClientErrorException e) {
            throw new GithubValidateException("Access token is expired");
        }
    }

    private HttpEntity getHttpEntity(String code) {
        String accessToken = getAccessToken(code);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer " + accessToken);
        httpHeaders.add("X-GitHub-Api-Version", "2022-11-28");

        HttpEntity request = new HttpEntity(httpHeaders);
        return request;
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
}
