package com.yuzarsif.fordevelopers.dto.request;

public record CreateCourseRequest(
        Integer universityId,
        String courseName
) {
}
