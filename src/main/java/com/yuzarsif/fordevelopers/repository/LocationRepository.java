package com.yuzarsif.fordevelopers.repository;

import com.yuzarsif.fordevelopers.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
