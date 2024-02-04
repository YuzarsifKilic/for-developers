import { Injectable } from '@angular/core';
import {AxiosService} from "./axios.service";
import {Project} from "../_models/project";
import {GithubRepositoryResponse} from "../_models/github-repository-response";

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  code!: string;

  constructor(private axiosService: AxiosService) { }

  getProjects(id: string): Promise<Project[]> {
    return this.axiosService.request(
      "GET",
      `/api/projects/employee/${id}`,
      {}).then(resp => {
        return resp.data;
    });
  }

  findRepositories(access_token: string): Promise<GithubRepositoryResponse[]> {
    return this.axiosService.request(
      "GET",
      `/api/projects/${access_token}`,
      {}).then(resp => {
        return resp.data;
    });
  }
}
