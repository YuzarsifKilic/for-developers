package com.yuzarsif.fordevelopers.dto.request;

import com.yuzarsif.fordevelopers.model.JobTitle;
import com.yuzarsif.fordevelopers.model.WorkType;

import java.util.List;

public record AdvertisementSearchFilter(
        String advertisementTitle,
        List<WorkType> workTypes,
        List<JobTitle> jobTitles
) {
}
