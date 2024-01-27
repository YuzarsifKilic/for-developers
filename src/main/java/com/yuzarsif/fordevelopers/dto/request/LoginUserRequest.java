package com.yuzarsif.fordevelopers.dto.request;

import lombok.Builder;

@Builder
public record LoginUserRequest(
        String email,
        String password
) {
}
