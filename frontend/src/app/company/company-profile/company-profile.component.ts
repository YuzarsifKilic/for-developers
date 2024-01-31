import { Component } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Company} from "../../_models/company";
import {CompanyService} from "../../_services/company.service";
import {AdvertisementService} from "../../_services/advertisement.service";
import {Advertisement} from "../../_models/advertisement";

@Component({
  selector: 'app-company-profile',
  templateUrl: './company-profile.component.html',
  styleUrl: './company-profile.component.css'
})
export class CompanyProfileComponent {

  companyId!: string;
  company!: Company;
  advertisements!: Advertisement[];

  constructor(private route: ActivatedRoute, private companyService: CompanyService, private advertisementService: AdvertisementService) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.companyId = params['id'];
    });
    this.getCompany();
    this.getAdvertisements();
  }

  getCompany() {
    this.companyService.findCompanyById(this.companyId)
      .then(resp => {
        console.log(resp);
        this.company = resp.data;
      })
      .catch(error => {
        console.log(error);
      })
  }

  getAdvertisements(){
    this.advertisementService.getAdvertisementByCompanyId(this.companyId).then(resp => {
      this.advertisements = resp.data;
    })
  }

}
