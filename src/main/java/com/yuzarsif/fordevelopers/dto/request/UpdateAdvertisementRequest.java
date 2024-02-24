package com.yuzarsif.fordevelopers.dto.request;

import com.yuzarsif.fordevelopers.model.JobTitle;
import com.yuzarsif.fordevelopers.model.WorkType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record UpdateAdvertisementRequest(
        @NotBlank @Positive
        Long id,
        @NotBlank @Size(min = 3, max = 64)
        String advertisementTitle,
        @NotBlank @Size(min = 3, max = 128)
        String advertisementContent,
        @NotBlank
        WorkType workType,
        @NotBlank
        JobTitle jobTitle
) {
}
