package com.yuzarsif.fordevelopers.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateEmployeeRequest {

    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String githubUsername;
}
