import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {SavedEmployee} from "../_models/saved-employee";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http: HttpClient) { }

  createEmployee(firstName: string, lastName: string, email: string, githubUsername: string, phoneNumber: string): Observable<SavedEmployee> {
    return this.http.post<SavedEmployee>("http://localhost:8080/api/employees", {
      firstName: firstName,
      lastName: lastName,
      email: email,
      githubUsername: githubUsername,
      phoneNumber: phoneNumber
    })
  }
}
