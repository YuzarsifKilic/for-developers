import { Injectable } from '@angular/core';
import {AxiosService} from "./axios.service";
import {ToastrService} from "ngx-toastr";

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  constructor(private axios: AxiosService, private toastr: ToastrService) { }

  saveCompany(email: string, password: string, companyName: string, phoneNumber: string, locationId: number) {
    return this.axios.request(
      "POST",
      "/api/companies",
      {
        email: email,
        password: password,
        companyName: companyName,
        phoneNumber: phoneNumber,
        locationId: locationId
      }).then(resp => {
        this.toastr.success("Successfully created account, redirecting to profile page...", "Success");
      }).catch(error => {
        this.toastr.error(error.response.data.message, "Error");
      })
  }
}
