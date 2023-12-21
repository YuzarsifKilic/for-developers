package com.yuzarsif.fordevelopers.mapper;

import com.yuzarsif.fordevelopers.dto.CompanyApplyDto;
import com.yuzarsif.fordevelopers.model.Apply;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {EmployeeDtoMapper.class})
public interface CompanyApplyDtoMapper {

    CompanyApplyDtoMapper MAPPER = Mappers.getMapper(CompanyApplyDtoMapper.class);

    CompanyApplyDto mapToCompanyApplyDto(Apply apply);
}
