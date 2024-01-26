import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Advertisement} from "../_models/advertisement";

@Injectable({
  providedIn: 'root'
})
export class AdvertisementService {

  constructor(private http: HttpClient) { }

  getAdvertisements(): Observable<Advertisement[]> {
    return this.http.get<Advertisement[]>('http://localhost:8080/api/advertisements/most-popular');
  }
}
