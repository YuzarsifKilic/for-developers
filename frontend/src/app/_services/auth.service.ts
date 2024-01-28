import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AxiosService} from "./axios.service";
import {ToastrService} from "ngx-toastr";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private axios: AxiosService, private toastr: ToastrService) { }

  login(email: string, password: string) {
    this.axios.request(
      "POST",
      "/api/auth/login",
      {
        email: email,
        password: password
      }).then(resp => {
        this.axios.setAuthToken(resp.data.token)
        this.toastr.success("Successfully logged in, redirecting to home page", "Success")
    }).catch(error => {
      this.toastr.error("Bad Credentials", "Error")
    })
  }
}
