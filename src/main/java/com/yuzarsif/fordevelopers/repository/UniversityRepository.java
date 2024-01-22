package com.yuzarsif.fordevelopers.repository;

import com.yuzarsif.fordevelopers.model.University;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UniversityRepository extends JpaRepository<University, Integer> {

}
