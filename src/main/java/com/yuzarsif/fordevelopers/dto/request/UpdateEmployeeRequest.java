package com.yuzarsif.fordevelopers.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record UpdateEmployeeRequest(
        @Email
        String email,
        @Size(min = 3, max = 32)
        String firstName,
        @Size(min = 3, max = 32)
        String lastName,
        @Size(min = 12, max = 14)
        String phoneNumber
) {
}
