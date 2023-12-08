package com.yuzarsif.fordevelopers.repository;

import com.yuzarsif.fordevelopers.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
