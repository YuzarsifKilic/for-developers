package com.yuzarsif.fordevelopers.mapper;

import com.yuzarsif.fordevelopers.dto.LocationDto;
import com.yuzarsif.fordevelopers.model.Location;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LocationDtoMapper {

    LocationDtoMapper MAPPER = Mappers.getMapper(LocationDtoMapper.class);

    LocationDto mapToLocationDto(Location location);
}
