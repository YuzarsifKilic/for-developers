import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ProjectService} from "../_services/project.service";
import {ActivatedRoute} from "@angular/router";
import {first} from "rxjs";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrl: './employee-details.component.css'
})
export class EmployeeDetailsComponent {

  saveProjectForm: FormGroup = this.formBuilder.group({
    projectName: ['', Validators.required],
    projectDescription: ['', Validators.required],
    startMonth: ['', Validators.required],
    startYear: ['', Validators.required],
    endMonth: ['', Validators.required],
    endYear: ['', Validators.required]
  });

  employeeId!: string;

  constructor(private formBuilder: FormBuilder,
              private projectService: ProjectService,
              private route: ActivatedRoute,
              private toastr: ToastrService) {
    this.route.params.subscribe(params => {
      this.employeeId = params["id"]
    })
  }

  saveProject() {
      let startDate = `${this.saveProjectForm.get("startMonth")?.value}/${this.saveProjectForm.get("startYear")?.value}`
      let endDate = `${this.saveProjectForm.get("endMonth")?.value}/${this.saveProjectForm.get("endYear")?.value}`
      this.projectService.saveProject(this.saveProjectForm.get("projectName")?.value,
        this.saveProjectForm.get("projectDescription")?.value,
        startDate,
        endDate,
        this.employeeId)
        .pipe(first())
        .subscribe((resp) =>{
          this.toastr.success("Sucessfully saved the project", "Success");
        }, error => {
          console.log(error)
          this.toastr.error(error.error.message, "Error")
        })
  }
}
