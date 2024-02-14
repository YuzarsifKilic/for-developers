import {Component, Input} from '@angular/core';
import {Advertisement} from "../_models/advertisement";
import {ApplyService} from "../_services/apply.service";
import {Router} from "@angular/router";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-advertisement',
  templateUrl: './advertisement.component.html',
  styleUrl: './advertisement.component.css'
})
export class AdvertisementComponent {

  @Input() advertisement!: Advertisement;

  constructor(private applyService: ApplyService, private router: Router, private toastr: ToastrService) { }

  saveApply() {
    if (window.localStorage.getItem("user_id") != null && window.localStorage.getItem("auth_role") == "ROLE_EMPLOYEE") {
      this.applyService.saveApply(this.advertisement.id, window.localStorage.getItem("user_id")!)
        .then(resp => {
          if (resp.status == 200) {
            this.toastr.success("Successfully applied", "Success");
            this.router.navigate(["/"])
          }
        }).catch(error => {
          this.toastr.error(error.response.data.message, "Error");
          console.log(error.response.data.message);
      })
    }
  }
}
