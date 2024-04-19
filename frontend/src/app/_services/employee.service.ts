import { Injectable } from '@angular/core';
import {AxiosService} from "./axios.service";
import {ToastrService} from "ngx-toastr";
import {Employee} from "../_models/employee";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  employee!: Employee;

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
        })
  }

  async findEmployeeById(id: string): Promise<Employee> {
    const resp = await this.axios.request(
      "GET",
      "/api/employees/" + id,
      {}
    );
    this.employee = resp.data;
    return resp.data;
  }

  updateEmployee(id: string, email: string, firstName: string, lastName: string, phoneNumber: string) {
    return this.axios.request(
      "PUT",
      "/api/employees/" + id,
      {
        email: email,
        firstName: firstName,
        lastName: lastName,
        phoneNumber: phoneNumber
      }
    );
  }
}
