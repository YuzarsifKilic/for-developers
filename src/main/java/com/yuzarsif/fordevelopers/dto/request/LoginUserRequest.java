package com.yuzarsif.fordevelopers.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record LoginUserRequest(
        @NotBlank @Email
        String email,
        @NotBlank
        String password
) {
}
