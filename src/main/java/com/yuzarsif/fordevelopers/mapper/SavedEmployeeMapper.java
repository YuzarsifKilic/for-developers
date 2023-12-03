package com.yuzarsif.fordevelopers.mapper;

import com.yuzarsif.fordevelopers.dto.SavedEmployeeDto;
import com.yuzarsif.fordevelopers.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SavedEmployeeMapper {

    SavedEmployeeMapper MAPPER = Mappers.getMapper(SavedEmployeeMapper.class);

    SavedEmployeeDto mapToSavedEmployeeDto(Employee employee);
}
