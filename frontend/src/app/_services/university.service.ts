import { Injectable } from '@angular/core';
import {AxiosService} from "./axios.service";

@Injectable({
  providedIn: 'root'
})
export class UniversityService {

  constructor(private axiosService: AxiosService) { }

  async getUniversities() {
    const resp = await this.axiosService.request(
      "GET",
      "api/universities",
      {});
    return resp.data;
  }
}
