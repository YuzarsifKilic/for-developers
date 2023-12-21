package com.yuzarsif.fordevelopers.dto;

import com.yuzarsif.fordevelopers.model.JobTitle;
import lombok.Builder;

@Builder
public record CreateExperienceRequest(

        String companyName,
        String startYear,
        String endYear,
        JobTitle jobTitle,
        String employeeId
) {
}
