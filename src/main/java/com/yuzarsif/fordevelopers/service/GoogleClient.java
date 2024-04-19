package com.yuzarsif.fordevelopers.service;

import com.yuzarsif.fordevelopers.config.GoogleProperties;
import com.yuzarsif.fordevelopers.model.GoogleToken;
import com.yuzarsif.fordevelopers.service.models.GoogleAccessTokenRequest;
import com.yuzarsif.fordevelopers.service.models.GoogleAccessTokenResponse;
import com.yuzarsif.fordevelopers.service.models.GoogleIdTokenResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Service
public class GoogleClient {

    private final GoogleProperties googleProperties;
    private final RestTemplate restTemplate;

    public GoogleClient(GoogleProperties googleProperties, RestTemplate restTemplate) {
        this.googleProperties = googleProperties;
        this.restTemplate = restTemplate;
    }

    public String getAuthorizeUrl() {
        return String.format("%s?client_id=%s?redirect_uri=%s?response_type=code?scope=%s",
                googleProperties.getAuthorizeUrl(),
                googleProperties.getClientId(),
                googleProperties.getRedirectUri(),
                "profile+email+openid");
    }

    public String getAccessToken(String code) {
        GoogleAccessTokenRequest request = GoogleAccessTokenRequest
                .builder()
                .clientId(googleProperties.getClientId())
                .clientSecret(googleProperties.getClientSecret())
                .redirectUri(googleProperties.getRedirectUri())
                .code(code)
                .grantType("authorization_code")
                .build();

        HttpEntity<GoogleAccessTokenRequest> httpEntity = new HttpEntity<>(request);

        try {
            ResponseEntity<GoogleAccessTokenResponse> response = restTemplate.exchange(googleProperties.getAccessTokenUrl(), HttpMethod.POST, httpEntity, GoogleAccessTokenResponse.class);
            return response.getBody().getAccessToken();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getEmailFromIdToken(String idToken) {
        String url = String.format("%s?id_token=%s", googleProperties.getTokenUrl(), idToken);
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(httpHeaders);
        ResponseEntity<GoogleIdTokenResponse> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, GoogleIdTokenResponse.class);
        return response.getBody().getEmail();
    }
}
