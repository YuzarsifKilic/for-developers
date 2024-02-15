import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AdvertisementService} from "../_services/advertisement.service";
import {AdvertisementsComponent} from "../advertisements/advertisements.component";
import {BehaviorSubject} from "rxjs";
import {AdvertisementFilterService} from "../_services/advertisement-filter.service";

@Component({
  selector: 'app-search-bar',
  templateUrl: './search-bar.component.html',
  styleUrl: './search-bar.component.css'
})
export class SearchBarComponent {

  constructor(private formBuilder: FormBuilder,
              private advertisementService: AdvertisementService,
              private advertisement: AdvertisementsComponent,
              private advertisementFilter: AdvertisementFilterService) { }

  advertisementSearchForm: FormGroup = this.formBuilder.group({
    advertisementTitle: ['', Validators.required],
  })

  advertisementSearch() {
    this.advertisementFilter.setTitle(this.advertisementSearchForm.value.advertisementTitle)
    this.advertisementService.searchAdvertisementsByTitle(this.advertisementSearchForm.value.advertisementTitle)
      .then(resp => {
        this.advertisement.setAdvertisements(resp.data);
      })
  }
}
