package com.yuzarsif.fordevelopers.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record CreateUniversityRequest(
        @NotBlank @Size(min = 3, max = 64)
        String universityName
) {
}
