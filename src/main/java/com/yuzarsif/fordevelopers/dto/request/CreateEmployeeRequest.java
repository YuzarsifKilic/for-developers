package com.yuzarsif.fordevelopers.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
public record CreateEmployeeRequest(
        String email,
        String password,
        String firstName,
        String lastName,
        String phoneNumber,
        String githubUsername
) {


}
