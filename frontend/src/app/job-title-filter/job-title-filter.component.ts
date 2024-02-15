import { Component } from '@angular/core';
import {AdvertisementFilterService} from "../_services/advertisement-filter.service";
import {JOB_TITLE} from "../_consts/job-title";

@Component({
  selector: 'app-job-title-filter',
  templateUrl: './job-title-filter.component.html',
  styleUrl: './job-title-filter.component.css'
})
export class JobTitleFilterComponent {

  protected readonly JOB_TITLE = JOB_TITLE;
  jobTitle: string[] = []

  constructor(private advertisementFilter: AdvertisementFilterService) { }


  selectJobTitle(jobTitle: string) {
    for (let i = 0; i < this.jobTitle.length; i++) {
      if (this.jobTitle[i] == jobTitle) {
        this.jobTitle.splice(i, 1);
        this.advertisementFilter.setJobTitle(this.jobTitle);
        return;
      }
    }
    this.jobTitle.push(jobTitle);
    console.log(this.jobTitle);
    this.advertisementFilter.setJobTitle(this.jobTitle);
  }
}
