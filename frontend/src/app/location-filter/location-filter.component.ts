import {Component, Input} from '@angular/core';
import {LocationService} from "../_services/location.service";
import {Location} from "../_models/location";

@Component({
  selector: 'app-location-filter',
  templateUrl: './location-filter.component.html',
  styleUrl: './location-filter.component.css'
})
export class LocationFilterComponent {

  locations: Location[] = [];
  @Input() cityId!: number;

  constructor(private locationService: LocationService) { }

  ngOnInit(): void {
    this.locationService.getLocations(this.cityId)
      .then(resp => {
        this.locations = resp;
      })
  }

  getLocations(id: number) {
    console.log("asdf")
    this.locationService.getLocations(id)
      .then(resp => {
        this.locations = resp;
      })
  }
}
