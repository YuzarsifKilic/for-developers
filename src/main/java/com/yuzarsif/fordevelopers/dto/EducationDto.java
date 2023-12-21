package com.yuzarsif.fordevelopers.dto;

public record EducationDto(

        UniversityDto university,
        Integer startYear,
        Integer endYear,
        float gnp
) {
}
