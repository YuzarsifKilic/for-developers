package com.yuzarsif.fordevelopers.dto;

import com.yuzarsif.fordevelopers.model.JobTitle;
import com.yuzarsif.fordevelopers.model.WorkType;

public record AdvertisementDto(
        Long id,
        CompanyDto company,
        String advertisementTitle,
        String advertisementContent,
        WorkType workType,
        JobTitle jobTitle
) {
}
