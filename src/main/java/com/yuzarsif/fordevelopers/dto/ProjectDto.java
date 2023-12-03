package com.yuzarsif.fordevelopers.dto;

import lombok.Builder;

@Builder
public record ProjectDto(
        String projectName,
        String projectDescription,
        String startDate,
        String endDate,
        String projectUrl
) {
}
