package com.yuzarsif.fordevelopers.dto;

public record EducationDto(

        UniversityDto university,
        CourseDto course,
        Integer startYear,
        Integer endYear,
        float gnp
) {
}
