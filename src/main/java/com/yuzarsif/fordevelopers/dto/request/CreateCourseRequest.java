package com.yuzarsif.fordevelopers.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record CreateCourseRequest(
        @NotBlank @Positive
        Integer universityId,
        @NotBlank @Size(min = 3, max = 64)
        String courseName
) {
}
