package com.yuzarsif.fordevelopers.mapper;

import com.yuzarsif.fordevelopers.dto.CompanyDto;
import com.yuzarsif.fordevelopers.model.Company;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {LocationDtoMapper.class})
public interface CompanyDtoMapper {

    CompanyDtoMapper MAPPER = Mappers.getMapper(CompanyDtoMapper.class);

    CompanyDto mapToCompanyDto(Company company);
}
