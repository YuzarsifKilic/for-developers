package com.yuzarsif.fordevelopers.repository;

import com.yuzarsif.fordevelopers.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findByEmployee_Id(String employeeId);
}
