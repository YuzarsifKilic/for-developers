package com.yuzarsif.fordevelopers.dto.request;

import lombok.Builder;

@Builder
public record Oauth2TokenSaveRequest(
        String code,
        String userId
) {
}
