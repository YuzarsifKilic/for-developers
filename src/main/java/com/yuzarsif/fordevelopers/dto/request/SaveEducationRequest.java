package com.yuzarsif.fordevelopers.dto.request;

import com.yuzarsif.fordevelopers.model.Degree;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record SaveEducationRequest(
        @NotBlank @Positive
        Integer universityId,
        @NotBlank @Positive
        Integer courseId,
        @NotBlank @Positive
        Integer startYear,
        @NotBlank @Positive
        Integer endYear,
        @NotBlank @Positive
        float gnp,
        @NotBlank
        Degree degree,
        @NotBlank @Size(min = 32, max = 32)
        String employeeId
) {
}
