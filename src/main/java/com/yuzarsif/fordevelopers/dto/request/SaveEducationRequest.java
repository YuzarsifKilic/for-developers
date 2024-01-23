package com.yuzarsif.fordevelopers.dto.request;

public record SaveEducationRequest(

        Integer universityId,
        Integer courseId,
        Integer startYear,
        Integer endYear,
        float gnp,
        String employeeId
) {
}
