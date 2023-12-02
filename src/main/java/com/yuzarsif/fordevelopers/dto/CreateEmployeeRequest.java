package com.yuzarsif.fordevelopers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeRequest {

    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String githubUsername;
}
