package com.yuzarsif.fordevelopers.controller;

import com.yuzarsif.fordevelopers.dto.request.Oauth2TokenSaveRequest;
import com.yuzarsif.fordevelopers.service.GoogleClient;
import com.yuzarsif.fordevelopers.service.GoogleTokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/google")
public class GoogleAuthController {

    private final GoogleClient googleClient;
    private final GoogleTokenService googleTokenService;

    public GoogleAuthController(GoogleClient googleClient, GoogleTokenService googleTokenService) {
        this.googleClient = googleClient;
        this.googleTokenService = googleTokenService;
    }

    @GetMapping("/authorize")
    public ResponseEntity<String> authorize() {
        return ResponseEntity.ok(googleClient.getAuthorizeUrl());
    }

    @PostMapping("/code")
    public ResponseEntity<Void> createAccessToken(@RequestBody Oauth2TokenSaveRequest request) {
        googleTokenService.saveToken(request);
        return ResponseEntity.ok().build();
    }
}
