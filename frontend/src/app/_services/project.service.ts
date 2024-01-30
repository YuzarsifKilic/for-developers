import { Injectable } from '@angular/core';
import {AxiosService} from "./axios.service";
import {Project} from "../_models/project";

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  constructor(private axiosService: AxiosService) { }

  getProjects(id: string): Promise<Project[]> {
    return this.axiosService.request(
      "GET",
      `/api/projects/${id}`,
      {}).then(resp => {
        return resp.data;
    });
  }
}
