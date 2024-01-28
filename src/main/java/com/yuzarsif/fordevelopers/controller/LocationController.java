package com.yuzarsif.fordevelopers.controller;

import com.yuzarsif.fordevelopers.dto.LocationDto;
import com.yuzarsif.fordevelopers.service.LocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public ResponseEntity<List<LocationDto>> findLocations() {
        return ResponseEntity.ok(locationService.findLocations());
    }

    @GetMapping("/{cityName}")
    public ResponseEntity<List<LocationDto>> findLocationDetails(@PathVariable String cityName) {
        return ResponseEntity.ok(locationService.findLocationDetails(cityName));
    }
}
