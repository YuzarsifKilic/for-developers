package com.yuzarsif.fordevelopers.service;

import com.yuzarsif.fordevelopers.exception.LocationNotFoundException;
import com.yuzarsif.fordevelopers.model.Location;
import com.yuzarsif.fordevelopers.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private final LocationRepository repository;

    public LocationService(LocationRepository repository) {
        this.repository = repository;
    }

    public Location findLocationById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new LocationNotFoundException("Location didnt find by id : " + id));
    }
}
