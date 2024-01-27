package com.yuzarsif.fordevelopers.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public record CreateCompanyRequest(
        String email,
        String password,
        String companyName,
        String phoneNumber,
        String city,
        Integer locationId
) {
}
