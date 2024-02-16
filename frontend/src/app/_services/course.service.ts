import { Injectable } from '@angular/core';
import {AxiosService} from "./axios.service";

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  constructor(private axiosService: AxiosService) { }

  getCourses(universityId: number) {
    return this.axiosService.request(
      "GET",
          "api/courses/university/" + universityId,
         {}
    );
  }
}
