package com.yuzarsif.fordevelopers.dto.request;

import com.yuzarsif.fordevelopers.model.Degree;

public record SaveEducationRequest(

        Integer universityId,
        Integer courseId,
        Integer startYear,
        Integer endYear,
        float gnp,
        Degree degree,
        String employeeId
) {
}
