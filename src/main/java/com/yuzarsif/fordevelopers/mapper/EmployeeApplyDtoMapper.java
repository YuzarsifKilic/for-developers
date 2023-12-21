package com.yuzarsif.fordevelopers.mapper;

import com.yuzarsif.fordevelopers.dto.EmployeeApplyDto;
import com.yuzarsif.fordevelopers.model.Apply;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {AdvertisementDtoMapper.class})
public interface EmployeeApplyDtoMapper {

    EmployeeApplyDtoMapper MAPPER = Mappers.getMapper(EmployeeApplyDtoMapper.class);

    EmployeeApplyDto mapToEmployeeApplyDto(Apply apply);
}
