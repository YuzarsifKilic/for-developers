import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AxiosService} from "./axios.service";
import {ToastrService} from "ngx-toastr";
import {Router} from "@angular/router";
import {Employee} from "../_models/employee";
import {Company} from "../_models/company";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  employee!: Employee;
  company!: Company;

  constructor(private axios: AxiosService, private toastr: ToastrService, private router: Router) { }

  login(email: string, password: string) {
    this.axios.request(
      "POST",
      "/api/auth/login",
      {
        email: email,
        password: password
      }).then(resp => {
        this.axios.setAuthTokenAndRole(resp.data.token, resp.data.roles[0], resp.data.id)
        this.toastr.success("Successfully logged in, redirecting to home page", "Success")
        if (resp.data.roles[0] === "ROLE_EMPLOYEE") {
          this.router.navigate(["employee/home/" + resp.data.id])
        } else if (resp.data.roles[0] === "ROLE_COMPANY") {
          this.router.navigate(["company/home/" + resp.data.id])
        }
    }).catch(error => {
      this.toastr.error("Bad Credentials", "Error")
    })
  }
}
