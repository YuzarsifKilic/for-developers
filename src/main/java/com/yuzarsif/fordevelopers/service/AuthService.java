package com.yuzarsif.fordevelopers.service;

import com.yuzarsif.fordevelopers.config.PasswordConfig;
import com.yuzarsif.fordevelopers.dto.AuthResponseDto;
import com.yuzarsif.fordevelopers.dto.request.ChangePasswordRequest;
import com.yuzarsif.fordevelopers.dto.request.LoginUserRequest;
import com.yuzarsif.fordevelopers.exception.AuthenticationCredentialsException;
import com.yuzarsif.fordevelopers.model.BaseUser;
import com.yuzarsif.fordevelopers.repository.BaseUserRepository;
import com.yuzarsif.fordevelopers.security.JwtService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final BaseUserRepository baseUserRepository;
    private final JwtService jwtService;
    private final PasswordConfig passwordConfig;

    public AuthService(AuthenticationManager authenticationManager, BaseUserRepository baseUserRepository, JwtService jwtService, PasswordConfig passwordConfig) {
        this.authenticationManager = authenticationManager;
        this.baseUserRepository = baseUserRepository;
        this.jwtService = jwtService;
        this.passwordConfig = passwordConfig;
    }

    public AuthResponseDto login(LoginUserRequest request) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.email(), request.password()));
        if (authentication.isAuthenticated()) {
            String token = jwtService.generateToken(request.email());
            BaseUser user = baseUserRepository.findByEmail(request.email()).get();
            AuthResponseDto authResponseDto = new AuthResponseDto(user.getId(), token, user.getAuthorities());
            return authResponseDto;
        }

        throw new AuthenticationCredentialsException("User credentials are not valid");
    }

    public void changePassword(ChangePasswordRequest request) {
        login(new LoginUserRequest(request.email(), request.oldPassword()));

        BaseUser baseUser = baseUserRepository.findByEmail(request.email()).get();
        baseUser.setPassword(passwordConfig.passwordEncoder().encode(request.newPassword()));

        baseUserRepository.save(baseUser);
    }
}
