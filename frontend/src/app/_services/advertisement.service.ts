import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Advertisement} from "../_models/advertisement";
import {AxiosService} from "./axios.service";
import {ToastrService} from "ngx-toastr";

@Injectable({
  providedIn: 'root'
})
export class AdvertisementService {

  constructor(private http: HttpClient, private axiosService: AxiosService, private toastr: ToastrService) { }


  getAdvertisements(): Observable<Advertisement[]> {
    return this.http.get<Advertisement[]>('http://localhost:8080/api/advertisements/most-popular');
  }

  getAdvertisementByCompanyId(id: string) {
    return this.axiosService.request(
      "GET",
      `/api/advertisements/company/${id}`,
      {});
  }

  getAdvertisementByAdvertisementId(id: number) {
    return this.axiosService.request(
      "GET",
      `/api/advertisements/${id}`,
      {});
  }

  saveAdvertisement(advertisementTitle: string, advertisementContent: string, workType: string, jobTitle: string) {
    return this.axiosService.requestWithToken(
      "POST",
      "/api/advertisements",
      {
        companyId: window.localStorage.getItem("user_id"),
        advertisementTitle: advertisementTitle,
        advertisementContent: advertisementContent,
        workType: workType,
        jobTitle: jobTitle,
      });
  }

  updateAdvertisement(advertisementTitle: string, advertisementContent: string, workType: string, jobTitle: string, advertisementId: number) {
    return this.axiosService.requestWithToken(
      "PUT",
      `/api/advertisements`,
      {
        id: +advertisementId,
        advertisementTitle: advertisementTitle,
        advertisementContent: advertisementContent,
        workType: workType,
        jobTitle: jobTitle,
      });
  }

  deleteAdvertisement(id: number) {
    return this.axiosService.requestWithToken(
      "DELETE",
      `/api/advertisements/${id}`,
      {});
  }

  searchAdvertisementsByTitle(title: string) {
    return this.axiosService.request(
      "GET",
      `/api/advertisements/search/${title}`,
      {});
  }

  filterAdvertisement(advertisementTitle: string, workType: string[], jobTitle: string[]) {
    if (workType.length == 0 && jobTitle.length == 0) {
      return this.axiosService.request(
        "POST",
        "api/advertisements/filter",
        {
          advertisementTitle: advertisementTitle
        }
      )
    } else if (workType.length == 0) {
      return this.axiosService.request(
        "POST",
        "api/advertisements/filter",
        {
          advertisementTitle: advertisementTitle,
          jobTitles: jobTitle
        }
      )
    } else {
      return this.axiosService.request(
        "POST",
        "api/advertisements/filter",
        {
          advertisementTitle: advertisementTitle,
          workTypes: workType
        }
      )
    }
  }
}
