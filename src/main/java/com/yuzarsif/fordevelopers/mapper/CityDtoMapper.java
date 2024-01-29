package com.yuzarsif.fordevelopers.mapper;

import com.yuzarsif.fordevelopers.dto.CityDto;
import com.yuzarsif.fordevelopers.dto.LocationDto;
import com.yuzarsif.fordevelopers.model.City;
import com.yuzarsif.fordevelopers.model.Location;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CityDtoMapper {

    CityDtoMapper MAPPER = Mappers.getMapper(CityDtoMapper.class);

    CityDto mapToCityDto(City city);
}
