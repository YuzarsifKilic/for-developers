package com.yuzarsif.fordevelopers.repository;

import com.yuzarsif.fordevelopers.model.SocialMedia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SocialMediaRepository extends JpaRepository<SocialMedia, Long> {

    List<SocialMedia> findAllByEmployeeId(String employeeId);
}
