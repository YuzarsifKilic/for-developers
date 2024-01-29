import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {EmployeeService} from "../../_services/employee.service";
import {CompanyService} from "../../_services/company.service";

@Component({
  selector: 'app-company-register',
  templateUrl: './company-register.component.html',
  styleUrl: './company-register.component.css'
})
export class CompanyRegisterComponent {

  constructor(private formBuilder: FormBuilder, private companyService: CompanyService) { }

  companyRegisterForm: FormGroup = this.formBuilder.group({
    email: ['', Validators.required],
    password: ['', Validators.required],
    companyName: ['', Validators.required],
    phoneNumber: ['', Validators.required]
  })

  saveCompany(): void {
    this.companyService.saveCompany(this.companyRegisterForm.value.email,
      this.companyRegisterForm.value.password,
      this.companyRegisterForm.value.companyName,
      this.companyRegisterForm.value.phoneNumber)
  }

}
