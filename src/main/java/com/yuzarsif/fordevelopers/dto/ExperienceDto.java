package com.yuzarsif.fordevelopers.dto;

import com.yuzarsif.fordevelopers.model.Experience;
import com.yuzarsif.fordevelopers.model.JobTitle;
import lombok.Builder;

import java.time.LocalDate;
import java.util.Date;

@Builder
public record ExperienceDto(
        Long id,
        String companyName,
        JobTitle jobTitle,
        String startYear,
        String endYear
) {

    public static ExperienceDto mapToExperienceDto(Experience experience) {
        return ExperienceDto
                .builder()
                .id(experience.getId())
                .companyName(experience.getCompanyName())
                .jobTitle(experience.getJobTitle())
                .startYear(experience.getStartDate().toString())
                .endYear(experience.getEndDate().toString())
                .build();
    }
}
