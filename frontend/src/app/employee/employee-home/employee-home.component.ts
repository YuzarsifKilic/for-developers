import { Component } from '@angular/core';
import {ToastrService} from "ngx-toastr";
import {EmployeeService} from "../../_services/employee.service";
import {Employee} from "../../_models/employee";
import {ProjectService} from "../../_services/project.service";
import {ExperienceService} from "../../_services/experience.service";
import {Project} from "../../_models/project";
import {Experience} from "../../_models/experience";
import {Router} from "@angular/router";
import {AuthService} from "../../_services/auth.service";
import {EducationService} from "../../_services/education.service";
import {Education} from "../../_models/education";
import {SocialMediaService} from "../../_services/social-media.service";
import {SocialMedia} from "../../_models/social-media";

@Component({
  selector: 'app-employee-home',
  templateUrl: './employee-home.component.html',
  styleUrl: './employee-home.component.css'
})
export class EmployeeHomeComponent {

  employeeId!: string;
  employee$!: Promise<Employee>;
  educations$!: Promise<Education[]>;
  projects$!: Promise<Project[]>;
  experiences$!: Promise<Experience[]>;
  socialMedias$!: Promise<SocialMedia[]>;

  constructor(private toastr: ToastrService,
              private employeeService: EmployeeService,
              private educationService: EducationService,
              private projectService: ProjectService,
              private experienceService: ExperienceService,
              private socialMediaService: SocialMediaService,
              private authService: AuthService,
              private router: Router) {
  }

  async ngOnInit(): Promise<void> {
    var userId = window.localStorage.getItem("user_id");
    var authToken = window.localStorage.getItem("auth_token");
    var authRole = window.localStorage.getItem("auth_role");

    if (userId === null || authToken === null || authRole === null) {
      this.toastr.error("Please login first", "Error");
      this.router.navigate(["/sign-in"]);
    } else {
      this.employeeId = userId;
      this.employee$ = this.getEmployee();
      this.educations$ = this.getEducations();
      this.experiences$ = this.getExperiences();
      this.projects$ = this.getProjects();
      this.socialMedias$ = this.getSocialMedias();
    }
  }


  getEmployee(): Promise<Employee> {
    return this.employeeService.findEmployeeById(window.localStorage.getItem("user_id")!);
  }

  getEducations(): Promise<Education[]>{
    return this.educationService.findEducationsByEmployeeId(window.localStorage.getItem("user_id")!);
  }

  getProjects(): Promise<Project[]> {
    return this.projectService.getProjects(window.localStorage.getItem("user_id")!);
  }

  getExperiences(): Promise<Experience[]> {
    return this.experienceService.getExperiences(window.localStorage.getItem("user_id")!);
  }

  getSocialMedias(): Promise<SocialMedia[]> {
    return this.socialMediaService.findSocialMediaById(window.localStorage.getItem("user_id")!);
  }

  connectToGithub() {
    window.location.href = "http://localhost:8080/auth/github/authorize"
  }

  showApplies() {
    this.router.navigate(["/employee/" + this.employeeId + "/apply"]);
  }

  changePassword() {
    this.router.navigate(["/auth/change-password"]);
  }

  editProfile() {
    this.router.navigate(["/employee/" + this.employeeId + "/edit-profile"]);
  }

  signOut() {
    this.authService.logOut();
    this.toastr.success("Successfully logged out, redirecting to home page...", "Success");
    this.router.navigate(["/"]);
  }

  addEducation() {
    this.router.navigate(["/employee/" + this.employeeId + "/add-education"]);
  }
}
