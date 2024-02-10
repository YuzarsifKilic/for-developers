package com.yuzarsif.fordevelopers.dto.request;

import com.yuzarsif.fordevelopers.model.JobTitle;
import com.yuzarsif.fordevelopers.model.WorkType;

public record UpdateAdvertisementRequest(
        Long id,
        String advertisementTitle,
        String advertisementContent,
        WorkType workType,
        JobTitle jobTitle
) {
}
