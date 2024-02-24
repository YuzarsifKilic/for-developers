package com.yuzarsif.fordevelopers.dto.request;

import com.yuzarsif.fordevelopers.model.JobTitle;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record CreateExperienceRequest(
        @NotBlank @Size(min = 3, max = 64)
        String companyName,
        @NotBlank @Size(min = 10, max = 10)
        String startYear,
        @NotBlank @Size(min = 10, max = 10)
        String endYear,
        @NotBlank
        JobTitle jobTitle,
        @NotBlank @Size(min = 32, max = 32)
        String employeeId
) {
}
