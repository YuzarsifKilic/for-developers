package com.yuzarsif.fordevelopers.mapper;

import com.yuzarsif.fordevelopers.dto.EducationDto;
import com.yuzarsif.fordevelopers.model.Education;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = UniversityDtoMapper.class)
public interface EducationDtoMapper {

    EducationDtoMapper MAPPER = Mappers.getMapper(EducationDtoMapper.class);

    EducationDto mapToEducationDto(Education education);
}
