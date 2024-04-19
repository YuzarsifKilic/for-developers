package com.yuzarsif.fordevelopers.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
public record CreateEmployeeRequest(
        @NotBlank @Email
        String email,
        @NotBlank @Size(min = 8, max = 16)
        String password,
        @NotBlank @Size(min = 3, max = 32)
        String firstName,
        @NotBlank @Size(min = 3, max = 32)
        String lastName,
        @NotBlank @Size(min = 10, max = 14)
        String phoneNumber,
        @NotBlank @Size(min = 3, max = 64)
        String githubUsername
) {


}
