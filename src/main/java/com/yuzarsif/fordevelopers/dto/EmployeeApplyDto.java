package com.yuzarsif.fordevelopers.dto;

import com.yuzarsif.fordevelopers.mapper.AdvertisementDtoMapper;
import com.yuzarsif.fordevelopers.model.Apply;

import java.time.LocalDate;

public record EmployeeApplyDto(
        Long id,
        AdvertisementDto advertisement,
        String appliedDate
) {

    public static EmployeeApplyDto mapToEmployeeApplyDto(Apply apply) {
        return new EmployeeApplyDto(
                apply.getId(),
                AdvertisementDtoMapper.MAPPER.mapToAdvertisementDto(apply.getAdvertisement()),
                apply.getAppliedDate().toString().replace(",", "-"));
    }
}
