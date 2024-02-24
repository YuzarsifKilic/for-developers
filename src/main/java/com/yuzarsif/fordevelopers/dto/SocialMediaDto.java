package com.yuzarsif.fordevelopers.dto;

import com.yuzarsif.fordevelopers.model.SocialMedia;
import com.yuzarsif.fordevelopers.model.SocialMedias;
import lombok.Builder;

@Builder
public record SocialMediaDto(
        Long id,
        SocialMedias socialMedia,
        String url
) {
}
