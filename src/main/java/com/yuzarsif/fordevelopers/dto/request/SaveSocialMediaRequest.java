package com.yuzarsif.fordevelopers.dto.request;

import com.yuzarsif.fordevelopers.model.SocialMedias;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaveSocialMediaRequest {

    private String employeeId;
    private SocialMedias socialMedia;
    private String url;
}
