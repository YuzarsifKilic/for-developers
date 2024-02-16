import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ToastrService} from "ngx-toastr";
import {CompanyService} from "../../_services/company.service";
import {Router} from "@angular/router";
import {EmployeeService} from "../../_services/employee.service";

@Component({
  selector: 'app-edit-employee-profile',
  templateUrl: './edit-employee-profile.component.html',
  styleUrl: './edit-employee-profile.component.css'
})
export class EditEmployeeProfileComponent {

  constructor(private formBuilder: FormBuilder, private toastr: ToastrService, private employeeService: EmployeeService, private router: Router) { }

  employeeUpdateForm: FormGroup = this.formBuilder.group({
    email: ['', Validators.required],
    firstName: ['', Validators.required],
    lastName: ['', Validators.required],
    phoneNumber: ['', Validators.required],
  })

  updateEmployee() {
    this.employeeService.updateEmployee(
      window.localStorage.getItem("user_id")!,
      this.employeeUpdateForm.value.email,
      this.employeeUpdateForm.value.firstName,
      this.employeeUpdateForm.value.lastName,
      this.employeeUpdateForm.value.phoneNumber)
      .then(resp => {
        this.router.navigate(['/sign-in']);
        this.toastr.success("Profile updated successfully!", "Success");
      })
  }
}
