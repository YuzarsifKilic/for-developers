import { Injectable } from '@angular/core';
import {AxiosService} from "./axios.service";
import {Apply} from "../_models/apply";
import {CompanyApply} from "../_models/company-apply";

@Injectable({
  providedIn: 'root'
})
export class ApplyService {

  constructor(private axiosService: AxiosService) { }

  async findAppliesByEmployeeId(): Promise<Apply[]> {
    const resp = await this.axiosService.requestWithToken(
      "GET",
      "api/applies/employee/" + window.localStorage.getItem("user_id"),
      {});
    return resp.data;
  }

  async findAppliesByCompanyId(advertisementId: number): Promise<CompanyApply[]> {
    const resp = await this.axiosService.requestWithToken(
      "GET",
      "api/applies/company/" + advertisementId,
      {});
    return resp.data;
  }

  saveApply(advertisementId: number, employeeId: string) {
    return this.axiosService.requestWithToken(
      "POST",
      "api/applies",
      {
        advertisementId: advertisementId,
        employeeId: employeeId
      }
    )
  }
}
