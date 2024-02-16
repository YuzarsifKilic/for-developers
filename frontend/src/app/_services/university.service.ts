import { Injectable } from '@angular/core';
import {AxiosService} from "./axios.service";

@Injectable({
  providedIn: 'root'
})
export class UniversityService {

  constructor(private axiosService: AxiosService) { }

  getUniversities() {
    return this.axiosService.request(
      "GET",
      "api/universities",
      {}
    )
  }
}
