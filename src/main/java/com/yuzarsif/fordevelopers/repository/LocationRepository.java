package com.yuzarsif.fordevelopers.repository;

import com.yuzarsif.fordevelopers.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Integer> {

    List<Location> findByCityName(String cityName);
}
