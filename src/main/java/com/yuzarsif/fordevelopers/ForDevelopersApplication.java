package com.yuzarsif.fordevelopers;

import com.yuzarsif.fordevelopers.dto.*;
import com.yuzarsif.fordevelopers.dto.request.*;
import com.yuzarsif.fordevelopers.model.Course;
import com.yuzarsif.fordevelopers.model.SocialMedia;
import com.yuzarsif.fordevelopers.model.SocialMedias;
import com.yuzarsif.fordevelopers.model.University;
import com.yuzarsif.fordevelopers.service.*;
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

	@Bean
	public CommandLineRunner demo(EmployeeService employeeService,
								  SocialMediaService socialMediaService,
								  ProjectService projectService,
								  CompanyService companyService,
								  CourseService courseService,
								  EducationService educationService,
								  UniversityService universityService) {
		return (args) -> {



		};

	}


}
