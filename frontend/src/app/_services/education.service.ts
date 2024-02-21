import { Injectable } from '@angular/core';
import {AxiosService} from "./axios.service";
import {Education} from "../_models/education";

@Injectable({
  providedIn: 'root'
})
export class EducationService {

  constructor(private axiosService: AxiosService) { }

  saveEducation(universityId: number, courseId: number, startYear: number, endYear: number, gnp: number, degree: string, employeeId: string) {
    return this.axiosService.requestWithToken(
      "POST",
      "/api/educations",
      {
        universityId: universityId,
        courseId: courseId,
        startYear: startYear,
        endYear: endYear,
        gnp: gnp,
        degree: degree,
        employeeId: employeeId
      }
    );
  }

  async findEducationsByEmployeeId(employeeId: string): Promise<Education[]> {
    const resp = await this.axiosService.request(
      "GET",
      "api/educations/employee/" + employeeId,
      {}
    );
    return resp.data;
  }
}
