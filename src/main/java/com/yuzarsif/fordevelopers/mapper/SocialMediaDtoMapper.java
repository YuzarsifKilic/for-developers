package com.yuzarsif.fordevelopers.mapper;

import com.yuzarsif.fordevelopers.dto.SocialMediaDto;
import com.yuzarsif.fordevelopers.model.SocialMedia;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SocialMediaDtoMapper {

    SocialMediaDtoMapper MAPPER = Mappers.getMapper(SocialMediaDtoMapper.class);

    SocialMediaDto mapToSocialMediaDto(SocialMedia socialMedia);
}
