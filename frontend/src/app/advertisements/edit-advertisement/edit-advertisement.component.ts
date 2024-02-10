import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {AdvertisementService} from "../../_services/advertisement.service";
import {Advertisement} from "../../_models/advertisement";
import {MatIconModule} from "@angular/material/icon";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-edit-advertisement',
  templateUrl: './edit-advertisement.component.html',
  styleUrl: './edit-advertisement.component.css',
})
export class EditAdvertisementComponent {

  userId = window.localStorage.getItem("user_id");
  advertisements: Advertisement[] = [];

  constructor(private router: Router, private advertisementService: AdvertisementService, private toastr: ToastrService) { }

  ngOnInit(): void {
    if (window.localStorage.getItem("user_id") == null ||
        window.localStorage.getItem("auth_token") == null ||
        window.localStorage.getItem("auth_role") == null ||
        window.localStorage.getItem("auth_role") != "ROLE_COMPANY") {
      this.router.navigate(["/sign-in"]);
    }

    this.getAdvertisements();
  }

  getAdvertisements() {
    this.advertisementService.getAdvertisementByCompanyId(this.userId!)
      .then(resp => {
        this.advertisements = resp.data;
      })
  }

  editAdvertisement(id: number) {
    this.router.navigate(["/company/" + this.userId + "/edit-advertisement/" + id]);
  }

  deleteAdvertisement(id: number) {
    this.advertisementService.deleteAdvertisement(id)
      .then(resp => {
        if (resp.status === 200) {
          this.toastr.success("Advertisement deleted successfully", "Success");
        } else {
          this.toastr.error("Something went wrong", "Error");
        }
      })
  }
}
