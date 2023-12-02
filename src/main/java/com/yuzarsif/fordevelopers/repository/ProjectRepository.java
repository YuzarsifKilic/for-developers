package com.yuzarsif.fordevelopers.repository;

import com.yuzarsif.fordevelopers.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
