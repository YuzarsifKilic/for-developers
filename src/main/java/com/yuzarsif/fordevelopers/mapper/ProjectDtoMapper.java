package com.yuzarsif.fordevelopers.mapper;

import com.yuzarsif.fordevelopers.dto.ProjectDto;
import com.yuzarsif.fordevelopers.model.Project;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjectDtoMapper {

    ProjectDtoMapper MAPPER = Mappers.getMapper(ProjectDtoMapper.class);

    ProjectDto mapToProjectDto(Project project);
}
