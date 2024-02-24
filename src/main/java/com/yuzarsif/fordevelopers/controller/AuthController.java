package com.yuzarsif.fordevelopers.controller;

import com.yuzarsif.fordevelopers.dto.AuthResponseDto;
import com.yuzarsif.fordevelopers.dto.request.ChangePasswordRequest;
import com.yuzarsif.fordevelopers.dto.request.LoginUserRequest;
import com.yuzarsif.fordevelopers.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@Validated @RequestBody LoginUserRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PutMapping("/change-password")
    public ResponseEntity<Void> changePassword(@Validated @RequestBody ChangePasswordRequest request) {
        authService.changePassword(request);
        return ResponseEntity.ok().build();
    }
}
