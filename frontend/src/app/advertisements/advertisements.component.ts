import { Component } from '@angular/core';
import {AdvertisementService} from "../_services/advertisement.service";
import {Advertisement} from "../_models/advertisement";
import {BehaviorSubject} from "rxjs";

@Component({
  selector: 'app-advertisements',
  templateUrl: './advertisements.component.html',
  styleUrl: './advertisements.component.css'
})
export class AdvertisementsComponent {

  protected advertisements = new BehaviorSubject<Advertisement[]>([]);
  advertisements$ = this.advertisements.asObservable();


  constructor(private advertisementService: AdvertisementService) {
  }

  ngOnInit(): void {
    this.advertisementService.getAdvertisements()
      .subscribe(resp => {
        console.log(resp)
        this.advertisements.next(resp);
      }, error => {
        console.log(error)
      })
  }

  setAdvertisements(advertisements: Advertisement[]) {
    this.advertisements.next(advertisements);
  }

}
