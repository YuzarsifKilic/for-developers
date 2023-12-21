package com.yuzarsif.fordevelopers.mapper;

import com.yuzarsif.fordevelopers.dto.ExperienceDto;
import com.yuzarsif.fordevelopers.model.Experience;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExperienceDtoMapper {

    ExperienceDtoMapper MAPPER = Mappers.getMapper(ExperienceDtoMapper.class);

    ExperienceDto mapToExperienceDto(Experience experience);
}
