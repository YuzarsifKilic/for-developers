import { Injectable } from '@angular/core';
import {AxiosService} from "./axios.service";
import {Apply} from "../_models/apply";

@Injectable({
  providedIn: 'root'
})
export class ApplyService {

  constructor(private axiosService: AxiosService) { }

  findAppliesByEmployeeId() {
    return this.axiosService.requestWithToken(
      "GET",
      "api/apply/employee/" + window.localStorage.getItem("user_id"),
      {}
    )
  }

  saveApply(advertisementId: number, employeeId: string) {
    return this.axiosService.requestWithToken(
      "POST",
      "api/apply",
      {
        advertisementId: advertisementId,
        employeeId: employeeId
      }
    )
  }
}
