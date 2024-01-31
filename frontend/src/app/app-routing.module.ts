import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {SignInComponent} from "./sign-in/sign-in.component";
import {AdvertisementsComponent} from "./advertisements/advertisements.component";
import {RegisterComponent} from "./employee/register/register.component";
import {CompanyRegisterComponent} from "./company/company-register/company-register.component";
import {EmployeeProfileComponent} from "./employee/employee-profile/employee-profile.component";
import {CompanyProfileComponent} from "./company/company-profile/company-profile.component";

const routes: Routes = [
  {path: "sign-in", component: SignInComponent},
  {path: "advertisements", component: AdvertisementsComponent},
  {path: "employee/register", component: RegisterComponent},
  {path: "employee/:id", component: EmployeeProfileComponent},
  {path: "company/register", component: CompanyRegisterComponent},
  {path: "company/:id", component: CompanyProfileComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
