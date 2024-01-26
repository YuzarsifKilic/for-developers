package com.yuzarsif.fordevelopers.dto;

public record CompanyDto(
        String id,
        String email,
        String companyName,
        String phoneNumber,
        LocationDto location
) {
}
