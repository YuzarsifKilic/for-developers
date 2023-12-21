import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class SessionServiceService {

  constructor(private http: HttpClient) { }

  getSessionId() {
    return this.http.get<string>("http://localhost:8080/demo", {withCredentials: true})
  }

  demo(): Observable<string> {
    return this.http.get<string>("http://localhost:8080/demo", {withCredentials: true})
  }
}
