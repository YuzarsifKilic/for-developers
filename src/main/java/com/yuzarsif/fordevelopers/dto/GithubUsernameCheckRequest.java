package com.yuzarsif.fordevelopers.dto;

import lombok.Builder;
import lombok.Data;

@Builder
public record GithubUsernameCheckRequest(
        String accessToken,
        String employeeId
) {
}
