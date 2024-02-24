package com.yuzarsif.fordevelopers.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record ChangePasswordRequest(
        @NotBlank @Email
        String email,
        @NotBlank @Size(min = 8, max = 16)
        String oldPassword,
        @NotBlank @Size(min = 8, max = 16)
        String newPassword
) {
}
