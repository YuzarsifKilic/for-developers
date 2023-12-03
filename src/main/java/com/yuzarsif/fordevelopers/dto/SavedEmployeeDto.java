package com.yuzarsif.fordevelopers.dto;

import lombok.Builder;

@Builder
public record SavedEmployeeDto(
        String id,
        String githubUsername
) {
}
