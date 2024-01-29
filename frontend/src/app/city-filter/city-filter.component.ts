import {Component, EventEmitter, Output} from '@angular/core';
import {LocationService} from "../_services/location.service";
import {City} from "../_models/city";

@Component({
  selector: 'app-city-filter',
  templateUrl: './city-filter.component.html',
  styleUrl: './city-filter.component.css'
})
export class CityFilterComponent {

  @Output() cityId = new EventEmitter<number>();

  cities: City[] = [];

  constructor(private locationService: LocationService) { }

  ngOnInit(): void {
    this.locationService.getCities()
      .then(resp => {
        this.cities = resp;
      })
  }

  selectCity(id: number) {
    console.log(id);
    this.cityId.emit(id);
  }
}
