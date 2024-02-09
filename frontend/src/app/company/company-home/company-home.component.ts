import { Component } from '@angular/core';
import {Company} from "../../_models/company";
import {Router} from "@angular/router";
import {CompanyService} from "../../_services/company.service";
import {Advertisement} from "../../_models/advertisement";
import {AdvertisementService} from "../../_services/advertisement.service";

@Component({
  selector: 'app-company-home',
  templateUrl: './company-home.component.html',
  styleUrl: './company-home.component.css'
})
export class CompanyHomeComponent {

  companyId!: string;
  company!: Company;
  advertisements: Advertisement[] = [];

  constructor(private router: Router, private companyService: CompanyService, private advertisementService: AdvertisementService) { }

  ngOnInit(): void {
    this.companyService.findCompanyById(window.localStorage.getItem("user_id")!)
      .then(resp => {
        console.log(resp.data);
        this.company = resp.data;
      })
    this.getAdvertisements();
  }

  getAdvertisements() {
    this.advertisementService.getAdvertisementByCompanyId(window.localStorage.getItem("user_id")!)
      .then(resp => {
        this.advertisements = resp.data;
      })
  }

  addAdvertisement() {
    this.router.navigate(["/company/" + this.companyId + "/advertisement-save"]);
  }
}
