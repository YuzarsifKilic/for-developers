package com.yuzarsif.fordevelopers.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record CreateApplyRequest(
        @NotBlank @Positive
        Long advertisementId,
        @NotBlank @Size(min = 32, max = 32)
        String employeeId
) {
}
