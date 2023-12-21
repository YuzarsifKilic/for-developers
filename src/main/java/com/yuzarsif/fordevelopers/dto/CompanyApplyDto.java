package com.yuzarsif.fordevelopers.dto;

import java.time.LocalDate;

public record CompanyApplyDto(
        Long id,
        EmployeeDto employee,
        LocalDate appliedDate
) {
}
