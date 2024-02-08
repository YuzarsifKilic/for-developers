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
    return this.axiosService.requestWithToken(
      "GET",
      `/api/projects/${access_token}`,
      {}).then(resp => {
        return resp.data;
    });
  }

  validateGithubUser(code: string) {
    return this.axiosService.requestWithToken(
      "POST",
      "/api/projects/github-callback",
      {
        "code": code,
        "employeeId": window.localStorage.getItem("user_id")
      }).then(resp => {
        return resp.data;
    })
  }

  saveProject(projectTitle: string, projectDescription: string, startDate: string, endDate: string, repositoryUrl: string) {
    return this.axiosService.requestWithToken(
      "POST",
      "api/projects",
      {
        "projectTitle": projectTitle,
        "projectDescription": projectDescription,
        "startDate": startDate,
        "endDate": endDate,
        "repositoryUrl": repositoryUrl,
        "employeeId": window.localStorage.getItem("user_id")
      });
  }
}
