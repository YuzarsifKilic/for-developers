package com.yuzarsif.fordevelopers.mapper;

import com.yuzarsif.fordevelopers.dto.SavedEmployeeDto;
import com.yuzarsif.fordevelopers.dto.UniversityDto;
import com.yuzarsif.fordevelopers.model.Employee;
import com.yuzarsif.fordevelopers.model.University;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = CourseDtoMapper.class)
public interface UniversityDtoMapper {

    UniversityDtoMapper MAPPER = Mappers.getMapper(UniversityDtoMapper.class);

    UniversityDto mapToUniversityDto(University university);
}
