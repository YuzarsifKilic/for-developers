import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SignInComponent } from './sign-in/sign-in.component';
import {ReactiveFormsModule} from "@angular/forms";
import { AdvertisementsComponent } from './advertisements/advertisements.component';
import { SearchBarComponent } from './search-bar/search-bar.component';
import { AdvertisementComponent } from './advertisement/advertisement.component';
import {HttpClientModule} from "@angular/common/http";
import { WorkTypeFilterComponent } from './work-type-filter/work-type-filter.component';
import { JobTitleFilterComponent } from './job-title-filter/job-title-filter.component';
import {ToastrModule} from "ngx-toastr";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { RegisterComponent } from './employee/register/register.component';
import { CompanyRegisterComponent } from './company/company-register/company-register.component';
import { LocationFilterComponent } from './location-filter/location-filter.component';
import {CityFilterComponent} from "./city-filter/city-filter.component";
import { EmployeeProfileComponent } from './employee/employee-profile/employee-profile.component';
import {MatIcon} from "@angular/material/icon";
import { CompanyProfileComponent } from './company/company-profile/company-profile.component';
import { AdvertisementSaveComponent } from './advertisements/advertisement-save/advertisement-save.component';
import { EmployeeHomeComponent } from './employee/employee-home/employee-home.component';
import { AddProjectComponent } from './project/add-project/add-project.component';
import { GithubCallbackComponent } from './employee/github-callback/github-callback.component';
import { ShowApplyComponent } from './apply/show-apply/show-apply.component';
import { CompanyHomeComponent } from './company/company-home/company-home.component';
import { EditAdvertisementComponent } from './advertisements/edit-advertisement/edit-advertisement.component';
import { EditSingleAdvertisementComponent } from './advertisements/edit-single-advertisement/edit-single-advertisement.component';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { EditCompanyProfileComponent } from './company/edit-company-profile/edit-company-profile.component';
import { EditEmployeeProfileComponent } from './employee/edit-employee-profile/edit-employee-profile.component';
import {AddEducationComponent} from "./add-education/add-education.component";
import {NgOptimizedImage} from "@angular/common";
import { CompanyShowApplyComponent } from './apply/company-show-apply/company-show-apply.component';
import { CompanyAdvertisementListComponent } from './apply/company-advertisement-list/company-advertisement-list.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    SignInComponent,
    AdvertisementsComponent,
    SearchBarComponent,
    AdvertisementComponent,
    CityFilterComponent,
    WorkTypeFilterComponent,
    JobTitleFilterComponent,
    RegisterComponent,
    CompanyRegisterComponent,
    LocationFilterComponent,
    EmployeeProfileComponent,
    CompanyProfileComponent,
    AdvertisementSaveComponent,
    EmployeeHomeComponent,
    AddProjectComponent,
    GithubCallbackComponent,
    ShowApplyComponent,
    CompanyHomeComponent,
    EditAdvertisementComponent,
    EditSingleAdvertisementComponent,
    ChangePasswordComponent,
    EditCompanyProfileComponent,
    EditEmployeeProfileComponent,
    AddEducationComponent,
    CompanyShowApplyComponent,
    CompanyAdvertisementListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    ToastrModule.forRoot(),
    MatIcon,
    NgOptimizedImage
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
