package com.yuzarsif.fordevelopers.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public record CreateCompanyRequest(
        @NotBlank @Email
        String email,
        @NotBlank @Size(min = 8, max = 16)
        String password,
        @NotBlank @Size(min = 3, max = 64)
        String companyName,
        @NotBlank @Size(min = 12, max = 14)
        String phoneNumber
) {
}
