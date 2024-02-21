import { Component } from '@angular/core';
import {AdvertisementService} from "../_services/advertisement.service";
import {Advertisement} from "../_models/advertisement";
import {BehaviorSubject, filter} from "rxjs";
import {SearchBarComponent} from "../search-bar/search-bar.component";
import {AdvertisementFilterService} from "../_services/advertisement-filter.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-advertisements',
  templateUrl: './advertisements.component.html',
  styleUrl: './advertisements.component.css'
})
export class AdvertisementsComponent {

  advertisements$!: Promise<Advertisement[]>;
  advertisementTitle!: string;
  jobTitle!: string[];
  workType!: string[];

  advertisementSearchForm: FormGroup = this.formBuilder.group({
    advertisementTitle: ['', Validators.required],
  })


  constructor(private advertisementService: AdvertisementService,
              private advertisementFilter: AdvertisementFilterService,
              private formBuilder: FormBuilder) { }

  async ngOnInit() {
    this.advertisementFilter.title$.subscribe((value) => {
      this.advertisementTitle = value;
      console.log(value);
    })
    this.advertisementFilter.jobTitle$.subscribe((value) => {
      this.jobTitle = value;
    })
    this.advertisementFilter.workType$.subscribe((value) => {
      this.workType = value;
    })
    this.advertisements$ = this.advertisementService.getAdvertisements();
  }

  getAdvertisements(): Promise<Advertisement[]> {
    if (this.advertisementTitle === null || this.advertisementTitle === undefined || this.advertisementTitle === "") {
      return this.advertisementService.getAdvertisements();
    }
    return this.advertisementService.searchAdvertisementsByTitle(this.advertisementTitle);
  }


  filter() {
    this.advertisements$ = this.advertisementService.filterAdvertisement(this.advertisementTitle, this.workType, this.jobTitle);
  }

  advertisementSearch() {
    this.advertisements$ = this.advertisementService.searchAdvertisementsByTitle(this.advertisementSearchForm.value.advertisementTitle);
  }
}
