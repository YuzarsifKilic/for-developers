package com.yuzarsif.fordevelopers.repository;

import com.yuzarsif.fordevelopers.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationRepository extends JpaRepository<Education, Long> {

    List<Education> findAllByEmployeeId(String employeeId);
}
