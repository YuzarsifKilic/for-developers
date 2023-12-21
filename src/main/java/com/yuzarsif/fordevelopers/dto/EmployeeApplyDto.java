package com.yuzarsif.fordevelopers.dto;

import java.time.LocalDate;

public record EmployeeApplyDto(
        Long id,
        AdvertisementDto advertisement,
        LocalDate appliedDate
) {
}
