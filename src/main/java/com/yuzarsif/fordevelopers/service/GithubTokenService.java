package com.yuzarsif.fordevelopers.service;

import com.yuzarsif.fordevelopers.dto.request.Oauth2TokenSaveRequest;
import com.yuzarsif.fordevelopers.model.GithubToken;
import com.yuzarsif.fordevelopers.repository.GithubTokenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Service
public class GithubTokenService {

    private final GithubTokenRepository repository;
    private final GithubClient githubClient;

    public GithubTokenService(GithubTokenRepository repository, GithubClient githubClient) {
        this.repository = repository;
        this.githubClient = githubClient;
    }

    public List<GithubToken> findTokens() {
        return repository.findTokensByCreatedDateBefore(Date.from(Instant.now().minus(1, ChronoUnit.HOURS)));
    }

    public void saveToken(Oauth2TokenSaveRequest request) {
        String token = githubClient.getAccessToken(request.code());
        GithubToken githubToken = GithubToken
                .builder()
                .token(token)
                .userId(request.userId())
                .createdDate(Date.from(Instant.now()))
                .build();
        repository.save(githubToken);
    }

    @Transactional
    public void deleteTokens(List<GithubToken> githubTokens) {
        repository.deleteAll(githubTokens);
    }
}
