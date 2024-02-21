import { Injectable } from '@angular/core';
import {AxiosService} from "./axios.service";
import {ToastrService} from "ngx-toastr";
import {Company} from "../_models/company";

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  constructor(private axios: AxiosService, private toastr: ToastrService) { }

  saveCompany(email: string, password: string, companyName: string, phoneNumber: string) {
    return this.axios.request(
      "POST",
      "/api/companies",
      {
        email: email,
        password: password,
        companyName: companyName,
        phoneNumber: phoneNumber
      }).then(resp => {
        this.toastr.success("Successfully created account, redirecting to profile page...", "Success");
      }).catch(error => {
        console.log(error);
        this.toastr.error(error.response.data.message, "Error");
      })
  }

  async findCompanyById(id: string): Promise<Company> {
    const resp = await this.axios.request(
      "GET",
      "/api/companies/" + id,
      {}
    );
    return resp.data;
  }

  updateCompany(id: string, email: string, companyName: string, phoneNumber: string) {
    return this.axios.request(
      "PUT",
      "/api/companies/" + id,
      {
        email: email,
        companyName: companyName,
        phoneNumber: phoneNumber
      }
    );
  }
}
