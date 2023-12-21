package com.yuzarsif.fordevelopers.dto;

import com.yuzarsif.fordevelopers.model.JobTitle;

import java.time.LocalDate;

public record ExperienceDto(
        Long id,
        String companyName,
        JobTitle jobTitle,
        LocalDate startYear,
        LocalDate endYear
) {
}
