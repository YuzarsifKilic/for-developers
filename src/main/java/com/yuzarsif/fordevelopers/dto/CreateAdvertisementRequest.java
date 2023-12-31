package com.yuzarsif.fordevelopers.dto;

import com.yuzarsif.fordevelopers.model.JobTitle;
import com.yuzarsif.fordevelopers.model.WorkType;

public record CreateAdvertisementRequest(
        String companyId,
        String advertisementTitle,
        String advertisementContent,
        WorkType workType,
        JobTitle jobTitle
) {
}
