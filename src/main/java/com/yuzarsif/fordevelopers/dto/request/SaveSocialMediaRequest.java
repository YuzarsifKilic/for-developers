package com.yuzarsif.fordevelopers.dto.request;

import com.yuzarsif.fordevelopers.model.SocialMedias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
public record SaveSocialMediaRequest (
        @NotBlank @Size(min = 32, max = 32)
        String employeeId,
        @NotBlank
        SocialMedias socialMedia,
        @NotBlank
        String url
){
}
