package com.yuzarsif.fordevelopers.dto;

public record LocationDto(
    Integer id,
    CityDto city,
    String districtName
) {
}
