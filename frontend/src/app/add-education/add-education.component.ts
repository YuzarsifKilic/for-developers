import { Component } from '@angular/core';
import {PROJECT_DAY, PROJECT_MONTH, PROJECT_YEAR} from "../_consts/project-day";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-add-education',
  templateUrl: './add-education.component.html',
  styleUrl: './add-education.component.css'
})
export class AddEducationComponent {

  constructor(private formBuilder: FormBuilder) { }

  protected readonly PROJECT_MONTH = PROJECT_MONTH;
  protected readonly PROJECT_YEAR = PROJECT_YEAR;
  protected readonly PROJECT_DAY = PROJECT_DAY;

  educationSaveForm: FormGroup = this.formBuilder.group({
    projectTitle: ['', Validators.required],
    projectDescription: ['', Validators.required]
  })

  onSelectedDay($event: Event) {

  }

  onSelectedMonth($event: Event) {

  }

  onSelectedYear($event: Event) {

  }
}
