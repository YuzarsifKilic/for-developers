package com.yuzarsif.fordevelopers.dto;

import java.util.List;
import java.util.Set;

public record UniversityDto(
        Integer id,
        String universityName,
        List<CourseDto> courses
) {
}
