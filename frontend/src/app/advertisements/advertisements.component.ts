import { Component } from '@angular/core';
import {AdvertisementService} from "../_services/advertisement.service";
import {Advertisement} from "../_models/advertisement";

@Component({
  selector: 'app-advertisements',
  templateUrl: './advertisements.component.html',
  styleUrl: './advertisements.component.css'
})
export class AdvertisementsComponent {

  advertisements: Advertisement[] = [];

  constructor(private advertisementService: AdvertisementService) {
  }

  ngOnInit(): void {
    this.advertisementService.getAdvertisements()
      .subscribe(resp => {
        console.log(resp)
        this.advertisements = resp;
      }, error => {
        console.log(error)
      })
  }

}
