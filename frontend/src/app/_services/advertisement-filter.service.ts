import { Injectable } from '@angular/core';
import {BehaviorSubject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AdvertisementFilterService {

  private title = new BehaviorSubject<string>("");
  title$ = this.title.asObservable();
  private jobTitle = new BehaviorSubject<string[]>([]);
  jobTitle$ = this.jobTitle.asObservable();
  private workType = new BehaviorSubject<string[]>([]);
  workType$ = this.workType.asObservable();

  constructor() { }

  setTitle(title: string) {
    this.title.next(title);
  }

  setJobTitle(jobTitle: string[]) {
    this.jobTitle.next(jobTitle);
  }

  setWorkType(workType: string[]) {
    this.workType.next(workType);
  }
}
