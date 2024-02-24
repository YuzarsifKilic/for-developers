package com.yuzarsif.fordevelopers.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record RepositoriesRequest(
        @NotBlank
        String accessToken,
        @NotBlank @Size(min = 32, max = 32)
        String employeeId
) {
}
