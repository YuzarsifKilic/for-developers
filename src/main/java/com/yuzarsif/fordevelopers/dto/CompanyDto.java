package com.yuzarsif.fordevelopers.dto;

import lombok.Builder;

@Builder
public record CompanyDto(
        String id,
        String email,
        String companyName,
        String phoneNumber,
        LocationDto location
) {
}
