package com.yuzarsif.fordevelopers.dto.request;

import com.yuzarsif.fordevelopers.model.JobTitle;
import com.yuzarsif.fordevelopers.model.WorkType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateAdvertisementRequest(
        @NotBlank @Size(min = 32, max = 32)
        String companyId,
        @NotBlank
        String advertisementTitle,
        @NotBlank
        String advertisementContent,
        @NotBlank
        WorkType workType,
        @NotBlank
        JobTitle jobTitle
) {
}
