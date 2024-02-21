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


  async getAdvertisements(): Promise<Advertisement[]> {
    const resp = await this.axiosService.request(
      "GET",
      "/api/advertisements/most-popular",
      {});
    return resp.data;
  }

  async getAdvertisementByCompanyId(id: string): Promise<Advertisement[]> {
    const resp = await this.axiosService.request(
      "GET",
      `/api/advertisements/company/${id}`,
      {});
    return resp.data;
  }

  async getAdvertisementByAdvertisementId(id: number): Promise<Advertisement> {
    const resp = await this.axiosService.request(
      "GET",
      `/api/advertisements/${id}`,
      {});
    return resp.data;
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

  async searchAdvertisementsByTitle(title: string): Promise<Advertisement[]> {
    const resp = await this.axiosService.request(
      "GET",
      `/api/advertisements/search/${title}`,
      {});
    return resp.data;
  }

  async filterAdvertisement(advertisementTitle: string, workType: string[], jobTitle: string[]) {
    if (workType.length == 0 && jobTitle.length == 0) {
      const resp = await this.axiosService.request(
        "POST",
        "api/advertisements/filter",
        {
          advertisementTitle: advertisementTitle
        });
      return resp.data;
    } else if (workType.length == 0) {
      const resp = await this.axiosService.request(
        "POST",
        "api/advertisements/filter",
        {
          advertisementTitle: advertisementTitle,
          jobTitles: jobTitle
        });
      return resp.data;
    } else {
      const resp = await this.axiosService.request(
        "POST",
        "api/advertisements/filter",
        {
          advertisementTitle: advertisementTitle,
          workTypes: workType
        });
      return resp.data;
    }
  }
}
