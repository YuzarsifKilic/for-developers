import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {EmployeeService} from "../../_services/employee.service";

@Component({
  selector: 'app-company-register',
  templateUrl: './company-register.component.html',
  styleUrl: './company-register.component.css'
})
export class CompanyRegisterComponent {

  constructor(private formBuilder: FormBuilder) { }

  companyRegisterForm: FormGroup = this.formBuilder.group({
    email: ['', Validators.required],
    password: ['', Validators.required],
    companyName: ['', Validators.required],
    phoneNumber: ['', Validators.required]
  })

  saveCompany(): void {
  }

}
