package com.yuzarsif.fordevelopers.mapper;

import com.yuzarsif.fordevelopers.dto.EmployeeDto;
import com.yuzarsif.fordevelopers.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ProjectDtoMapper.class, SocialMediaDtoMapper.class, EducationDtoMapper.class, ExperienceDtoMapper.class})
public interface EmployeeDtoMapper {

    EmployeeDtoMapper MAPPER = Mappers.getMapper(EmployeeDtoMapper.class);

    EmployeeDto mapToEmployeeDto(Employee employee);
}
