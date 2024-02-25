import { Component } from '@angular/core';
import {AdvertisementService} from "../../_services/advertisement.service";
import {Advertisement} from "../../_models/advertisement";
import {Router} from "@angular/router";

@Component({
  selector: 'app-company-advertisement-list',
  templateUrl: './company-advertisement-list.component.html',
  styleUrl: './company-advertisement-list.component.css'
})
export class CompanyAdvertisementListComponent {

  advertisements$!: Promise<Advertisement[]>;

  constructor(private advertisementService: AdvertisementService, private router: Router) { }

  ngOnInit(): void {
    this.advertisements$ = this.getAdvertisements();
  }

  getAdvertisements(): Promise<Advertisement[]> {
    return this.advertisementService.getAdvertisementByCompanyId(window.localStorage.getItem("user_id")!);
  }

  showApply(id: number) {
    this.router.navigate(["/company/" + window.localStorage.getItem("user_id") + "/apply/" + id]);
  }
}
