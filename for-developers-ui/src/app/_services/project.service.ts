import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Project} from "../_models/project";

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  constructor(private httpClient: HttpClient) { }

  saveProject(projectName: string, projectDescription: string, startDate: string, endDate: string, employeeId: string): Observable<Project> {
    return this.httpClient.post<Project>("http://localhost:8080/api/projects", {
      projectName: projectName,
      projectDescription: projectDescription,
      startDate: startDate,
      endDate: endDate,
      employeeId: employeeId
    })
  }
}
