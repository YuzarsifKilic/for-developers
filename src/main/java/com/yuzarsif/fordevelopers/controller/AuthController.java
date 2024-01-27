package com.yuzarsif.fordevelopers.controller;

import com.yuzarsif.fordevelopers.dto.AuthResponseDto;
import com.yuzarsif.fordevelopers.dto.request.LoginUserRequest;
import com.yuzarsif.fordevelopers.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginUserRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}
