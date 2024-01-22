package com.yuzarsif.fordevelopers.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCompanyRequest {

    private String email;
    private String companyName;
    private String phoneNumber;
    private String city;
}
