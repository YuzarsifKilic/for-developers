import { Component } from '@angular/core';
import {AdvertisementFilterService} from "../_services/advertisement-filter.service";
import {WORK_TYPE} from "../_consts/work-type";
import {JOB_TITLE} from "../_consts/job-title";

@Component({
  selector: 'app-work-type-filter',
  templateUrl: './work-type-filter.component.html',
  styleUrl: './work-type-filter.component.css'
})
export class WorkTypeFilterComponent {

  protected readonly WORK_TYPE = WORK_TYPE;
  workType: string[] = []

  constructor(private advertisementFilter: AdvertisementFilterService) { }


  selectWorkType(workType: string) {
    for (let i = 0; i < this.workType.length; i++) {
      if (this.workType[i] == workType) {
        this.workType.splice(i, 1);
        this.advertisementFilter.setWorkType(this.workType);
        return;
      }
    }
    this.workType.push(workType);
    console.log(this.workType);
    this.advertisementFilter.setWorkType(this.workType);
  }


  protected readonly JOB_TITLE = JOB_TITLE;
}
