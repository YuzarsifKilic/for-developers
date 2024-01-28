import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {EmployeeService} from "../../_services/employee.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  constructor(private formBuilder: FormBuilder, private employeeService: EmployeeService) { }

  employeeRegisterForm: FormGroup = this.formBuilder.group({
    email: ['', Validators.required],
    password: ['', Validators.required],
    firstName: ['', Validators.required],
    lastName: ['', Validators.required],
    githubUsername: ['', Validators.required],
    phoneNumber: ['', Validators.required]
  })

  saveEmployee(): void {
    console.log(this.employeeRegisterForm.value.email);
    this.employeeService.saveEmployee(this.employeeRegisterForm.value.email,
      this.employeeRegisterForm.value.password,
      this.employeeRegisterForm.value.firstName,
      this.employeeRegisterForm.value.lastName,
      this.employeeRegisterForm.value.phoneNumber,
      this.employeeRegisterForm.value.githubUsername)
  }

}
