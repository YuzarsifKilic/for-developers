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
    EmployeeProfileComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        BrowserAnimationsModule,
        ReactiveFormsModule,
        ToastrModule.forRoot(),
        MatIcon
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
