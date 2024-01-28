package com.yuzarsif.fordevelopers.service;

import com.yuzarsif.fordevelopers.dto.LocationDto;
import com.yuzarsif.fordevelopers.exception.LocationNotFoundException;
import com.yuzarsif.fordevelopers.mapper.LocationDtoMapper;
import com.yuzarsif.fordevelopers.model.Location;
import com.yuzarsif.fordevelopers.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService {

    private final LocationRepository repository;

    public LocationService(LocationRepository repository) {
        this.repository = repository;
    }

    public List<LocationDto> findLocations() {
        return repository.findAll()
                .stream()
                .map(LocationDtoMapper.MAPPER::mapToLocationDto)
                .collect(Collectors.toList());
    }

    public List<LocationDto> findLocationDetails(String cityName) {
        return repository.findByCityName(cityName)
                .stream()
                .map(LocationDtoMapper.MAPPER::mapToLocationDto)
                .collect(Collectors.toList());
    }

    public Location findLocationById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new LocationNotFoundException("Location didnt find by id : " + id));
    }
}
