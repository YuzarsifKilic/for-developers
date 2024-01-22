package com.yuzarsif.fordevelopers;

import com.yuzarsif.fordevelopers.dto.SavedEmployeeDto;
import com.yuzarsif.fordevelopers.dto.SocialMediaDto;
import com.yuzarsif.fordevelopers.dto.request.CreateEmployeeRequest;
import com.yuzarsif.fordevelopers.dto.request.CreateProjectRequest;
import com.yuzarsif.fordevelopers.dto.request.SaveSocialMediaRequest;
import com.yuzarsif.fordevelopers.model.SocialMedia;
import com.yuzarsif.fordevelopers.model.SocialMedias;
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
	public CommandLineRunner demo(EmployeeService employeeService, SocialMediaService socialMediaService, ProjectService projectService) {
		return (args) -> {
			projectService.saveProject(new CreateProjectRequest("youcontribute", "This project provide to you improve your contribute to open source projects",
					"08/2023", "10/2023", "b3b34d1a-3a52-42a0-96f9-bb0e3bec9715"));
		};

	}


}
