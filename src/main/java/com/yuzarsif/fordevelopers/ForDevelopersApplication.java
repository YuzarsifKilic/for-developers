package com.yuzarsif.fordevelopers;

import com.yuzarsif.fordevelopers.dto.SavedEmployeeDto;
import com.yuzarsif.fordevelopers.dto.SocialMediaDto;
import com.yuzarsif.fordevelopers.dto.request.CreateCompanyRequest;
import com.yuzarsif.fordevelopers.dto.request.CreateEmployeeRequest;
import com.yuzarsif.fordevelopers.dto.request.CreateProjectRequest;
import com.yuzarsif.fordevelopers.dto.request.SaveSocialMediaRequest;
import com.yuzarsif.fordevelopers.model.SocialMedia;
import com.yuzarsif.fordevelopers.model.SocialMedias;
import com.yuzarsif.fordevelopers.service.CompanyService;
import com.yuzarsif.fordevelopers.service.EmployeeService;
import com.yuzarsif.fordevelopers.service.ProjectService;
import com.yuzarsif.fordevelopers.service.SocialMediaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ForDevelopersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForDevelopersApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(EmployeeService employeeService, SocialMediaService socialMediaService, ProjectService projectService, CompanyService companyService) {
		return (args) -> {
			companyService.saveCompany(new CreateCompanyRequest("yuzarsif", "Yuzasif", "5555555", "Istanbul"));
		};

	}


}
