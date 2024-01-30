import { Injectable } from '@angular/core';
import {AxiosService} from "./axios.service";
import {ToastrService} from "ngx-toastr";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private axios: AxiosService, private toastr: ToastrService) { }

  saveEmployee(email: string, password: string, firstName: string, lastName: string, phoneNumber: string, githubUsername: string) {
      return this.axios.request(
        "POST",
        "/api/employees",
        {
          email: email,
          password: password,
          firstName: firstName,
          lastName: lastName,
          phoneNumber: phoneNumber,
          githubUsername: githubUsername
        }).then(resp => {
          this.toastr.success("Successfully created account, redirecting to profile page...", "Success")
      }).catch(error => {
          this.toastr.error(error.response.data.message, "Error")
      })
  }

  findEmployeeById(id: string) {
    return this.axios.request(
      "GET",
      "/api/employees/" + id,
      {}
    );
  }
}
