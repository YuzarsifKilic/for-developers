import { Component } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {EmployeeService} from "../../_services/employee.service";
import {Employee} from "../../_models/employee";
import {error} from "@angular/compiler-cli/src/transformers/util";
import {ProjectService} from "../../_services/project.service";
import {Project} from "../../_models/project";
import {ExperienceService} from "../../_services/experience.service";
import {Experience} from "../../_models/experience";

@Component({
  selector: 'app-employee-profile',
  templateUrl: './employee-profile.component.html',
  styleUrl: './employee-profile.component.css'
})
export class EmployeeProfileComponent {

  employeeId!: string;
  employee!: Employee;
  projects!: Project[];
  experiences!: Experience[];

  constructor(private route: ActivatedRoute,
              private employeeService: EmployeeService,
              private projectService: ProjectService,
              private experienceService: ExperienceService) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.employeeId = params['id'];
    });
    this.getEmployee();
    this.getProjects();
    this.getExperiences();
  }

  getEmployee() {
    this.employeeService.findEmployeeById(this.employeeId)
      .then(resp => {
        console.log(resp);
        this.employee = resp.data;
      })
      .catch(error => {
        console.log(error);
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
}
