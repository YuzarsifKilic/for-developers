package com.yuzarsif.fordevelopers.controller;

import com.yuzarsif.fordevelopers.dto.CityDto;
import com.yuzarsif.fordevelopers.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public ResponseEntity<List<CityDto>> findAllCities() {
        return ResponseEntity.ok(cityService.findAllCities());
    }
}
