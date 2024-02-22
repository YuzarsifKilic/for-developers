import { Injectable } from '@angular/core';
import {AxiosService} from "./axios.service";
import {SocialMedia} from "../_models/social-media";

@Injectable({
  providedIn: 'root'
})
export class SocialMediaService {

  constructor(private axiosService: AxiosService) { }


  async findSocialMediaById(id: string): Promise<SocialMedia[]> {
    const resp = await this.axiosService.request(
      "GET",
      "api/social_medias/employee/" + id,
      {}
    );
    return resp.data;
  }
}
