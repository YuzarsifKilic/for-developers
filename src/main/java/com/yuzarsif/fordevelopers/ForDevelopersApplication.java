package com.yuzarsif.fordevelopers;

import com.yuzarsif.fordevelopers.dto.CourseDto;
import com.yuzarsif.fordevelopers.dto.UniversityDto;
import com.yuzarsif.fordevelopers.model.Course;
import com.yuzarsif.fordevelopers.model.Employee;
import com.yuzarsif.fordevelopers.model.University;
import com.yuzarsif.fordevelopers.repository.CourseRepository;
import com.yuzarsif.fordevelopers.repository.UniversityRepository;
import com.yuzarsif.fordevelopers.service.CourseService;
import com.yuzarsif.fordevelopers.service.UniversityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class ForDevelopersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForDevelopersApplication.class, args);
	}


}
