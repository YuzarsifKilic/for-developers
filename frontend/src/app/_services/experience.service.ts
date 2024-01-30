import { Injectable } from '@angular/core';
import {AxiosService} from "./axios.service";

@Injectable({
  providedIn: 'root'
})
export class ExperienceService {

  constructor(private axiosService: AxiosService) { }


  getExperiences(id: string): Promise<any> {
    return this.axiosService.request(
      "GET",
      `/api/experiences/${id}`,
      {}).then(resp => {
        return resp.data;
    });
  }
}
