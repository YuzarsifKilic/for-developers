package com.yuzarsif.fordevelopers.repository;

import com.yuzarsif.fordevelopers.model.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {
}
