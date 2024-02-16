package com.yuzarsif.fordevelopers.dto.request;

public record UpdateCompanyRequest(
        String email,
        String companyName,
        String phoneNumber
) {
}
