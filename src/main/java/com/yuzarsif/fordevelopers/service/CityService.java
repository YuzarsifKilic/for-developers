package com.yuzarsif.fordevelopers.service;

import com.yuzarsif.fordevelopers.dto.CityDto;
import com.yuzarsif.fordevelopers.exception.CityNotFoundException;
import com.yuzarsif.fordevelopers.mapper.CityDtoMapper;
import com.yuzarsif.fordevelopers.model.City;
import com.yuzarsif.fordevelopers.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<CityDto> findAllCities() {
        return cityRepository.findAll()
                .stream()
                .map(CityDtoMapper.MAPPER::mapToCityDto)
                .collect(Collectors.toList());
    }
}
