import { Injectable } from '@angular/core';
import {AxiosService} from "./axios.service";

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
}
