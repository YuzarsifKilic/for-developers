package com.yuzarsif.fordevelopers.dto.request;

public record UpdateEmployeeRequest(
        String email,
        String firstName,
        String lastName,
        String phoneNumber
) {
}
