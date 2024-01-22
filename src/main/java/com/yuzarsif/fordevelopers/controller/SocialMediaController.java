package com.yuzarsif.fordevelopers.controller;

import com.yuzarsif.fordevelopers.dto.SocialMediaDto;
import com.yuzarsif.fordevelopers.dto.request.SaveSocialMediaRequest;
import com.yuzarsif.fordevelopers.service.SocialMediaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<SocialMediaDto>> findAllByEmployeeId(@PathVariable String employeeId) {
        return ResponseEntity.ok(socialMediaService.findAllByEmployeeId(employeeId));
    }
}
