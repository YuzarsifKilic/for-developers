import { Component } from '@angular/core';

@Component({
  selector: 'app-work-type-filter',
  templateUrl: './work-type-filter.component.html',
  styleUrl: './work-type-filter.component.css'
})
export class WorkTypeFilterComponent {

  cars = [
    {model : "Ford Mustang", color : "red"},
    {model : "Fiat 500", color : "white"},
    {model : "Volvo XC90", color : "black"}
  ]

}
