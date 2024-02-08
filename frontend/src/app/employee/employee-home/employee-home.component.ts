import { Component } from '@angular/core';
import {ToastrService} from "ngx-toastr";
import {EmployeeService} from "../../_services/employee.service";
import {Employee} from "../../_models/employee";
import {ProjectService} from "../../_services/project.service";
import {ExperienceService} from "../../_services/experience.service";
import {Project} from "../../_models/project";
import {Experience} from "../../_models/experience";
import {Router} from "@angular/router";

@Component({
  selector: 'app-employee-home',
  templateUrl: './employee-home.component.html',
  styleUrl: './employee-home.component.css'
})
export class EmployeeHomeComponent {

  employeeId!: string;
  employee!: Employee;
  projects!: Project[];
  experiences!: Experience[];

  constructor(private toastr: ToastrService,
              private employeeService: EmployeeService,
              private projectService: ProjectService,
              private experienceService: ExperienceService,
              private router: Router) { }

  ngOnInit(): void {
    var userId = window.localStorage.getItem("user_id");
    var authToken = window.localStorage.getItem("auth_token");
    var authRole = window.localStorage.getItem("auth_role");

    if (userId === null || authToken === null || authRole === null) {
      this.toastr.error("Please login first", "Error");
      this.router.navigate(["/sign-in"]);
    } else {
      this.employeeId = userId;
      this.getEmployee();
      this.getProjects();
      this.getExperiences();
    }
  }

  getEmployee() {
    this.employeeService.findEmployeeById(this.employeeId)
      .then(resp => {
        console.log(resp);
        this.employee = resp;
      })
  }

  getProjects(){
    this.projectService.getProjects(this.employeeId).then(resp => {
      this.projects = resp;
    })
  }

  getExperiences(){
    this.experienceService.getExperiences(this.employeeId).then(resp => {
      this.experiences = resp;
    })
  }

  connectToGithub() {
    window.location.href = "http://localhost:8080/auth/github/authorize"
  }

  showApplies() {
    this.router.navigate(["/employee/" + this.employeeId + "/apply"]);
  }
}
