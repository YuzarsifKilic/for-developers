import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AuthService} from "../_services/auth.service";
import {ToastrService} from "ngx-toastr";
import {Router} from "@angular/router";

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrl: './change-password.component.css'
})
export class ChangePasswordComponent {

  changePasswordForm: FormGroup = this.formBuilder.group({
    email: ['', Validators.required],
    oldPassword: ['', Validators.required],
    newPassword: ['', Validators.required]
  })

  constructor(private formBuilder: FormBuilder, private authService: AuthService, private toastr: ToastrService, private router: Router) { }

  changePassword() {
    this.authService.changePassword(this.changePasswordForm.value.email, this.changePasswordForm.value.oldPassword, this.changePasswordForm.value.newPassword)
      .then(resp => {
        if (resp.status === 200) {
          console.log(resp);
          this.toastr.success("Password changed successfully", "Success")
          this.router.navigate(["/sign-in"]);
        } else {
          console.log(resp.message);
          this.toastr.error("Credentials are not valid", "Error")
        }
      })
  }
}
