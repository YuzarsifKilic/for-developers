import {Component, EventEmitter, Output} from '@angular/core';
import {AxiosService} from "../_services/axios.service";
import {Location} from "../_models/location";

@Component({
  selector: 'app-city-filter',
  templateUrl: './city-filter.component.html',
  styleUrl: './city-filter.component.css'
})
export class CityFilterComponent {

  locations: Location[] = [];
  @Output() location: EventEmitter<string> = new EventEmitter<string>();
  selectedLocation!: Location;

  constructor(private axios: AxiosService) { }

  ngOnInit() {
    this.getCities();
  }

  send(location: Location) {
    this.location.emit(location.cityName);
  }


  public getCities() {
    this.axios.request(
      "GET",
      "/api/locations", {})
      .then(resp => {
        this.locations = resp.data;
      })
      .catch(error => {
        console.log(error);
      });
  }

}
