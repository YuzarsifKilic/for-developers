package com.yuzarsif.fordevelopers.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@NotBlank
public record UpdateCompanyRequest(
        @Email
        String email,
        @Size(min = 3, max = 64)
        String companyName,
        @Size(min = 12, max = 14)
        String phoneNumber
) {
}
