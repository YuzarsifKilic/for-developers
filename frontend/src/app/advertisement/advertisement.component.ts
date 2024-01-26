import {Component, Input} from '@angular/core';
import {Advertisement} from "../_models/advertisement";

@Component({
  selector: 'app-advertisement',
  templateUrl: './advertisement.component.html',
  styleUrl: './advertisement.component.css'
})
export class AdvertisementComponent {

  @Input() advertisement!: Advertisement;

}
