import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ToastrService} from "ngx-toastr";
import {CompanyService} from "../../_services/company.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-edit-company-profile',
  templateUrl: './edit-company-profile.component.html',
  styleUrl: './edit-company-profile.component.css'
})
export class EditCompanyProfileComponent {

  constructor(private formBuilder: FormBuilder, private toastr: ToastrService, private companyService: CompanyService, private router: Router) { }

  companyUpdateForm: FormGroup = this.formBuilder.group({
    email: ['', Validators.required],
    companyName: ['', Validators.required],
    phoneNumber: ['', Validators.required],
  })

  updateCompany() {
    this.companyService.updateCompany(
      window.localStorage.getItem("user_id")!,
      this.companyUpdateForm.value.email,
      this.companyUpdateForm.value.companyName,
      this.companyUpdateForm.value.phoneNumber)
      .then(resp => {
        this.toastr.success("Successfully updated company profile", "Success");
        this.router.navigate(["/sign-in"]);
      })
  }
}
