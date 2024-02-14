package com.yuzarsif.fordevelopers.repository;

import com.yuzarsif.fordevelopers.model.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {

    List<Advertisement> findAllByCompany_Id(String companyId);

    List<Advertisement> findTop20ByOrderByViewCountDesc();

    List<Advertisement> findByAdvertisementTitleContainingIgnoreCase(String title);
}
