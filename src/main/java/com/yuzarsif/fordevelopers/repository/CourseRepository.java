package com.yuzarsif.fordevelopers.repository;

import com.yuzarsif.fordevelopers.model.Course;
import com.yuzarsif.fordevelopers.model.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Query("select c from Course c join c.universities u where u.id = :universityId")
    List<Course> findCoursesByUniversityId(Integer universityId);

}
