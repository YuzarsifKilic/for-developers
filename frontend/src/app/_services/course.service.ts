import { Injectable } from '@angular/core';
import {AxiosService} from "./axios.service";
import {Course} from "../_models/course";

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  constructor(private axiosService: AxiosService) { }

  async getCourses(universityId: number): Promise<Course[]> {
    const resp = await this.axiosService.request(
      "GET",
      "api/courses/university/" + universityId,
      {});
    return resp.data;
  }
}
