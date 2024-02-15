import { Component } from '@angular/core';
import {AdvertisementService} from "../_services/advertisement.service";
import {Advertisement} from "../_models/advertisement";
import {BehaviorSubject, filter} from "rxjs";
import {SearchBarComponent} from "../search-bar/search-bar.component";
import {AdvertisementFilterService} from "../_services/advertisement-filter.service";

@Component({
  selector: 'app-advertisements',
  templateUrl: './advertisements.component.html',
  styleUrl: './advertisements.component.css'
})
export class AdvertisementsComponent {

  protected advertisements = new BehaviorSubject<Advertisement[]>([]);
  advertisements$ = this.advertisements.asObservable();
  advertisementTitle!: string;
  jobTitle!: string[];
  workType!: string[];


  constructor(private advertisementService: AdvertisementService, private advertisementFilter: AdvertisementFilterService) { }

  ngOnInit(): void {
    this.advertisementFilter.title$.subscribe((value) => {
      this.advertisementTitle = value;
    })
    this.advertisementFilter.jobTitle$.subscribe((value) => {
      this.jobTitle = value;
    })
    this.advertisementFilter.workType$.subscribe((value) => {
      this.workType = value;
    })
    console.log(this.advertisementTitle);
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

  filter() {
    console.log(this.advertisementTitle);
    console.log(this.jobTitle);
    console.log(this.workType);
    this.advertisementService.filterAdvertisement(this.advertisementTitle, this.workType, this.jobTitle)
      .then(resp => {
        this.advertisements.next(resp.data);
      })
  }
}
