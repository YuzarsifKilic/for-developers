package com.yuzarsif.fordevelopers.repository;

import com.yuzarsif.fordevelopers.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {
}
