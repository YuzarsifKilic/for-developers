package com.yuzarsif.fordevelopers.controller;

import com.yuzarsif.fordevelopers.dto.AdvertisementDto;
import com.yuzarsif.fordevelopers.dto.request.CreateAdvertisementRequest;
import com.yuzarsif.fordevelopers.dto.request.UpdateAdvertisementRequest;
import com.yuzarsif.fordevelopers.service.AdvertisementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/advertisements")
public class AdvertisementController {

    private final AdvertisementService advertisementService;

    public AdvertisementController(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    @PostMapping
    public ResponseEntity<String> saveAdvertisement(@RequestBody CreateAdvertisementRequest request) {
        advertisementService.saveAdvertisement(request);
        return ResponseEntity.ok("Advertisement created");
    }

    @PostMapping("/increment-view-count/{id}")
    public ResponseEntity<Void> incrementViewCount(@PathVariable Long id) {
        advertisementService.incrementViewCount(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateAdvertisement(@RequestBody UpdateAdvertisementRequest request) {
        advertisementService.updateAdvertisement(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdvertisementDto> findAdvertisementById(@PathVariable Long id) {
        return ResponseEntity.ok(advertisementService.findByAdvertisementId(id));
    }

    @GetMapping("/company/{id}")
    public ResponseEntity<List<AdvertisementDto>> findAllByCompanyId(@PathVariable String id) {
        return ResponseEntity.ok(advertisementService.findAllByCompanyId(id));
    }

    @GetMapping("/most-popular")
    public ResponseEntity<List<AdvertisementDto>> findMostPopularAdvertisements() {
        return ResponseEntity.ok(advertisementService.findMostPopularAdvertisements());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        advertisementService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
