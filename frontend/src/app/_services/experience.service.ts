import { Injectable } from '@angular/core';
import {AxiosService} from "./axios.service";
import {Experience} from "../_models/experience";

@Injectable({
  providedIn: 'root'
})
export class ExperienceService {

  constructor(private axiosService: AxiosService) { }


  async getExperiences(id: string): Promise<Experience[]> {
    const resp = await this.axiosService.request(
      "GET",
      `/api/experiences/${id}`,
      {});
    return resp.data;
  }
}
