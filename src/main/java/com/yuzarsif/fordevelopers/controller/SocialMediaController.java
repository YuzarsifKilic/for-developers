package com.yuzarsif.fordevelopers.controller;

import com.yuzarsif.fordevelopers.dto.SaveSocialMediaRequest;
import com.yuzarsif.fordevelopers.service.SocialMediaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/social_media")
public class SocialMediaController {

    private final SocialMediaService socialMediaService;

    public SocialMediaController(SocialMediaService socialMediaService) {
        this.socialMediaService = socialMediaService;
    }

    @PostMapping
    public void saveSocialMedia(@RequestBody SaveSocialMediaRequest request) {
        socialMediaService.saveSocialMedia(request);
    }
}
