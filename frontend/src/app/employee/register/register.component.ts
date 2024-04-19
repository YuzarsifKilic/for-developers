import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {EmployeeService} from "../../_services/employee.service";
import {ToastrService} from "ngx-toastr";
import {Router} from "@angular/router";
import {AuthService} from "../../_services/auth.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  constructor(private formBuilder: FormBuilder,
              private employeeService: EmployeeService,
              private toastr: ToastrService,
              private router: Router,
              private authService: AuthService) { }

  employeeRegisterForm: FormGroup = this.formBuilder.group({
    email: ['', Validators.required],
    password: ['', Validators.required],
    firstName: ['', Validators.required],
    lastName: ['', Validators.required],
    githubUsername: ['', Validators.required],
    phoneNumber: ['', Validators.required]
  })

  saveEmployee(): void {
    this.employeeService.saveEmployee(this.employeeRegisterForm.value.email,
      this.employeeRegisterForm.value.password,
      this.employeeRegisterForm.value.firstName,
      this.employeeRegisterForm.value.lastName,
      this.employeeRegisterForm.value.phoneNumber,
      this.employeeRegisterForm.value.githubUsername)
      .then(resp => {
        this.toastr.success("Successfully created account, redirecting to profile page...", "Success")
        if (resp.status === 200) {
          this.authService.login(this.employeeRegisterForm.value.email,
            this.employeeRegisterForm.value.password)
          this.router.navigate(['/employee/home/' + resp.data.id]);
        }
      }).catch(error => {
      this.toastr.error(error.response.data.message, "Error")
    })
  }

}
