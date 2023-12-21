package com.yuzarsif.fordevelopers.mapper;

import com.yuzarsif.fordevelopers.dto.AdvertisementDto;
import com.yuzarsif.fordevelopers.dto.CompanyDto;
import com.yuzarsif.fordevelopers.model.Advertisement;
import com.yuzarsif.fordevelopers.model.Company;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {CompanyDtoMapper.class})
public interface AdvertisementDtoMapper {

    AdvertisementDtoMapper MAPPER = Mappers.getMapper(AdvertisementDtoMapper.class);

    AdvertisementDto mapToAdvertisementDto(Advertisement advertisement);
}
