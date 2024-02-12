import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AxiosService} from "./axios.service";
import {ToastrService} from "ngx-toastr";
import {Router} from "@angular/router";
import {Employee} from "../_models/employee";
import {Company} from "../_models/company";
import {BehaviorSubject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  employee!: Employee;
  private company!: Company;
  private username = new BehaviorSubject<string>("");
  username$ = this.username.asObservable();
  private loggedIn = new BehaviorSubject<boolean>(false);
  loggedIn$ = this.loggedIn.asObservable();

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
        this.loggedIn.next(true);
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

  logOut() {
    window.localStorage.removeItem("auth_token");
    window.localStorage.removeItem("auth_role");
    window.localStorage.removeItem("user_id");
    this.loggedIn.next(false);
  }

  setUsername(username: string) {
    this.username.next(username);
  }

  changePassword(email: string, oldPassword: string, newPassword: string) {
    return this.axios.request(
      "PUT",
      "/api/auth/change-password",
      {
        email: email,
        oldPassword: oldPassword,
        newPassword: newPassword
      });
  }
}
