package com.yuzarsif.fordevelopers.dto.request;

import lombok.Builder;

@Builder
public record ChangePasswordRequest(
        String email,
        String oldPassword,
        String newPassword
) {
}
