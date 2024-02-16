import { Component } from '@angular/core';
import {Company} from "../../_models/company";
import {Router} from "@angular/router";
import {CompanyService} from "../../_services/company.service";
import {Advertisement} from "../../_models/advertisement";
import {AdvertisementService} from "../../_services/advertisement.service";
import {AuthService} from "../../_services/auth.service";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-company-home',
  templateUrl: './company-home.component.html',
  styleUrl: './company-home.component.css'
})
export class CompanyHomeComponent {

  companyId!: string;
  company!: Company;
  advertisements: Advertisement[] = [];

  constructor(private router: Router,
              private companyService: CompanyService,
              private advertisementService: AdvertisementService,
              private authService: AuthService,
              private toastr: ToastrService) { }

  ngOnInit(): void {
    this.companyService.findCompanyById(window.localStorage.getItem("user_id")!)
      .then(resp => {
        console.log(resp.data);
        this.company = resp.data;
        this.authService.setUsername(this.company.companyName);
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
    this.router.navigate(["/company/" + window.localStorage.getItem("user_id") + "/advertisement-save"]);
  }

  editAdvertisement() {
    this.router.navigate(["/company/" + window.localStorage.getItem("user_id") + "/edit-advertisement"]);
  }

  signOut() {
    this.authService.logOut();
    this.toastr.success("Successfully logged out, redirecting to home page...", "Success");
    this.router.navigate(["/advertisements"]);
  }

  changePassword() {
    this.router.navigate(["/auth/change-password"]);
  }

  editProfile() {
    this.router.navigate(["/company/" + window.localStorage.getItem("user_id") + "/edit-profile"]);
  }
}
