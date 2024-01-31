import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Advertisement} from "../_models/advertisement";
import {AxiosService} from "./axios.service";

@Injectable({
  providedIn: 'root'
})
export class AdvertisementService {

  constructor(private http: HttpClient, private axiosService: AxiosService) { }

  getAdvertisements(): Observable<Advertisement[]> {
    return this.http.get<Advertisement[]>('http://localhost:8080/api/advertisements/most-popular');
  }

  getAdvertisementByCompanyId(id: string) {
    return this.axiosService.request(
      "GET",
      `/api/advertisements/company/${id}`,
      {});
  }
}
