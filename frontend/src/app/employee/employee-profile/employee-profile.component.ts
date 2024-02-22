import { Component } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {EmployeeService} from "../../_services/employee.service";
import {Employee} from "../../_models/employee";
import {error} from "@angular/compiler-cli/src/transformers/util";
import {ProjectService} from "../../_services/project.service";
import {Project} from "../../_models/project";
import {ExperienceService} from "../../_services/experience.service";
import {Experience} from "../../_models/experience";
import {SocialMediaService} from "../../_services/social-media.service";
import {SocialMedia} from "../../_models/social-media";
import {EducationService} from "../../_services/education.service";
import {Education} from "../../_models/education";

@Component({
  selector: 'app-employee-profile',
  templateUrl: './employee-profile.component.html',
  styleUrl: './employee-profile.component.css'
})
export class EmployeeProfileComponent {

  employeeId!: string;
  employee$!: Promise<Employee>;
  projects$!: Promise<Project[]>;
  educations$!: Promise<Education[]>;
  experiences$!: Promise<Experience[]>;
  socialMedia$!: Promise<SocialMedia[]>;

  constructor(private route: ActivatedRoute,
              private employeeService: EmployeeService,
              private projectService: ProjectService,
              private experienceService: ExperienceService,
              private educationService: EducationService,
              private socialMediaService: SocialMediaService) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.employeeId = params['id'];
    });
    this.employee$ = this.getEmployee();
    this.educations$ = this.getEducations();
    this.projects$ = this.getProjects();
    this.experiences$ = this.getExperiences();
    this.socialMedia$ = this.getSocialMedias();
  }

  getEmployee(): Promise<Employee> {
    return this.employeeService.findEmployeeById(this.employeeId);
  }

  getProjects(){
    return this.projectService.getProjects(this.employeeId);
  }

  getExperiences(){
    return this.experienceService.getExperiences(this.employeeId);
  }

  getEducations(){
    return this.educationService.findEducationsByEmployeeId(this.employeeId);
  }

  getSocialMedias(): Promise<SocialMedia[]> {
    return this.socialMediaService.findSocialMediaById(this.employeeId);
  }
}
