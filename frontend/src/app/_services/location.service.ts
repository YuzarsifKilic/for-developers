import { Injectable } from '@angular/core';
import {AxiosService} from "./axios.service";
import {Observable} from "rxjs";
import {Location} from "../_models/location";
import {City} from "../_models/city";

@Injectable({
  providedIn: 'root'
})
export class LocationService {

  constructor(private axios: AxiosService) { }

  async getCities(): Promise<City[]> {
    return await this.axios.request(
      "GET",
      "/api/cities",
      {}
    ).then(resp => {
      return resp.data;
    })
  }

  async getLocations(id: number): Promise<Location[]> {
    return await this.axios.request(
      "GET",
      `/api/locations/${id}`,
      {}
    ).then(resp => {
      return resp.data;
    })
  }

}
