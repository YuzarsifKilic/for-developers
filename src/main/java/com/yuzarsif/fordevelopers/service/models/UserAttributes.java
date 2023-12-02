package com.yuzarsif.fordevelopers.service.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAttributes {

    private String email;
    private String firstName;
    private String lastName;
}
