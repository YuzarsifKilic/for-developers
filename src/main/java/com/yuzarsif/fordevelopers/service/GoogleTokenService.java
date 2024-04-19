package com.yuzarsif.fordevelopers.service;

import com.yuzarsif.fordevelopers.dto.request.Oauth2TokenSaveRequest;
import com.yuzarsif.fordevelopers.model.GoogleToken;
import com.yuzarsif.fordevelopers.repository.GoogleTokenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Service
public class GoogleTokenService {

    private final GoogleTokenRepository repository;
    private final GoogleClient googleClient;

    public GoogleTokenService(GoogleTokenRepository repository, GoogleClient googleClient) {
        this.repository = repository;
        this.googleClient = googleClient;
    }

    public List<GoogleToken> findTokens() {
        return repository.findTokensByCreatedDateBefore(Date.from(Instant.now().minus(1, ChronoUnit.HOURS)));
    }

    public void saveToken(Oauth2TokenSaveRequest request) {
        String token = googleClient.getAccessToken(request.code());
        GoogleToken googleToken = GoogleToken
                .builder()
                .token(token)
                .userId(request.userId())
                .createdDate(Date.from(Instant.now()))
                .build();
        repository.save(googleToken);
    }

    @Transactional
    public void deleteTokens(List<GoogleToken> googleTokens) {
        repository.deleteAll(googleTokens);
    }
}
