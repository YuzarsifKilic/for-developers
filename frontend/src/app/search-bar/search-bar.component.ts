import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AdvertisementService} from "../_services/advertisement.service";
import {AdvertisementsComponent} from "../advertisements/advertisements.component";

@Component({
  selector: 'app-search-bar',
  templateUrl: './search-bar.component.html',
  styleUrl: './search-bar.component.css'
})
export class SearchBarComponent {

  constructor(private formBuilder: FormBuilder, private advertisementService: AdvertisementService, private advertisement:AdvertisementsComponent) { }

  advertisementSearchForm: FormGroup = this.formBuilder.group({
    advertisementTitle: ['', Validators.required],
  })

  advertisementSearch() {
    this.advertisementService.searchAdvertisementsByTitle(this.advertisementSearchForm.value.advertisementTitle)
      .then(resp => {
        this.advertisement.setAdvertisements(resp.data);
      })
  }
}
