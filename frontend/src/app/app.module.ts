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
import { CityFilterComponent } from './city-filter/city-filter.component';
import { DistinctFilterComponent } from './city-filter/distinct-filter/distinct-filter.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    SignInComponent,
    AdvertisementsComponent,
    SearchBarComponent,
    AdvertisementComponent,
    WorkTypeFilterComponent,
    JobTitleFilterComponent,
    RegisterComponent,
    CompanyRegisterComponent,
    CityFilterComponent,
    DistinctFilterComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        BrowserAnimationsModule,
        ReactiveFormsModule,
        ToastrModule.forRoot()
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
