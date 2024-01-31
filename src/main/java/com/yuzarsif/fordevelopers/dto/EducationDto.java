package com.yuzarsif.fordevelopers.dto;

import com.yuzarsif.fordevelopers.model.Degree;

public record EducationDto(

        Integer startYear,
        Integer endYear,
        float gnp,
        UniversityDto university,
        CourseDto course,
        Degree degree
) {
}
