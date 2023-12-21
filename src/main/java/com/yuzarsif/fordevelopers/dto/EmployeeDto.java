package com.yuzarsif.fordevelopers.dto;

import lombok.Builder;

import java.util.Set;

@Builder
public record EmployeeDto(
        String id,
        String email,
        String firstName,
        String lastName,
        String phoneNumber,
        String githubUsername,
        Set<ProjectDto> projects,
        Set<SocialMediaDto> socialMedias,
        Set<EducationDto> educations,
        Set<ExperienceDto> experiences


) {
}
