import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {SignInComponent} from "./sign-in/sign-in.component";
import {AdvertisementsComponent} from "./advertisements/advertisements.component";
import {RegisterComponent} from "./employee/register/register.component";
import {CompanyRegisterComponent} from "./company/company-register/company-register.component";
import {EmployeeProfileComponent} from "./employee/employee-profile/employee-profile.component";
import {CompanyProfileComponent} from "./company/company-profile/company-profile.component";
import {AdvertisementSaveComponent} from "./advertisements/advertisement-save/advertisement-save.component";
import {EmployeeHomeComponent} from "./employee/employee-home/employee-home.component";
import {AddProjectComponent} from "./project/add-project/add-project.component";
import {GithubCallbackComponent} from "./employee/github-callback/github-callback.component";
import {ShowApplyComponent} from "./apply/show-apply/show-apply.component";
import {CompanyHomeComponent} from "./company/company-home/company-home.component";
import {EditAdvertisementComponent} from "./advertisements/edit-advertisement/edit-advertisement.component";
import {
  EditSingleAdvertisementComponent
} from "./advertisements/edit-single-advertisement/edit-single-advertisement.component";
import {ChangePasswordComponent} from "./change-password/change-password.component";

const routes: Routes = [
  {path: "sign-in", component: SignInComponent},
  {path: "advertisements", component: AdvertisementsComponent},
  {path: "employee/register", component: RegisterComponent},
  {path: "auth/github/callback", component: GithubCallbackComponent},
  {path: "auth/change-password", component: ChangePasswordComponent},
  {path: "employee/:id", component: EmployeeProfileComponent},
  {path: "employee/home/:id", component: EmployeeHomeComponent},
  {path: "employee/:id/project", component: AddProjectComponent},
  {path: "employee/:id/apply", component: ShowApplyComponent},
  {path: "company/register", component: CompanyRegisterComponent},
  {path: "company/:id", component: CompanyProfileComponent},
  {path: "company/home/:id", component: CompanyHomeComponent},
  {path: "company/:id/advertisement-save", component: AdvertisementSaveComponent},
  {path: "company/:id/edit-advertisement", component: EditAdvertisementComponent},
  {path: "company/:id/edit-advertisement/:advertisementId", component: EditSingleAdvertisementComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
