package com.yuzarsif.fordevelopers;

import com.yuzarsif.fordevelopers.dto.*;
import com.yuzarsif.fordevelopers.dto.request.*;
import com.yuzarsif.fordevelopers.model.*;
import com.yuzarsif.fordevelopers.repository.AdvertisementRepository;
import com.yuzarsif.fordevelopers.repository.CompanyRepository;
import com.yuzarsif.fordevelopers.repository.LocationRepository;
import com.yuzarsif.fordevelopers.service.*;
import com.yuzarsif.fordevelopers.service.models.GithubRepositoryResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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
								  UniversityService universityService,
								  AdvertisementRepository advertisementRepository,
								  LocationRepository locationRepository,
								  CompanyRepository companyRepository,
								  GithubClient githubClient) {
		return (args) -> {



		};

	}

}
