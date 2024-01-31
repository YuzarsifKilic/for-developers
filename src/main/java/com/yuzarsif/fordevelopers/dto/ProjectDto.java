package com.yuzarsif.fordevelopers.dto;

import com.yuzarsif.fordevelopers.model.Project;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Builder
public record ProjectDto(
        Long id,
        String projectName,
        String projectDescription,
        String startDate,
        String endDate,
        String projectUrl
) {

    public static ProjectDto mapToProjectDto(Project project) {
        return ProjectDto.builder()
                .id(project.getId())
                .projectName(project.getProjectName())
                .projectDescription(project.getProjectDescription())
                .projectUrl(project.getProjectUrl())
                .startDate(project.getStartDate().toString())
                .endDate(project.getEndDate().toString())
                .build();
    }
}
