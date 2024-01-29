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
    private final CityService cityService;

    public LocationService(LocationRepository repository, CityService cityService) {
        this.repository = repository;
        this.cityService = cityService;
    }

    public List<LocationDto> findLocationDetails(Integer cityId) {
        return repository.findByCity_Id(cityId)
                .stream()
                .map(LocationDtoMapper.MAPPER::mapToLocationDto)
                .collect(Collectors.toList());
    }

    public Location findLocationById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new LocationNotFoundException("Location didnt find by id : " + id));
    }
}
