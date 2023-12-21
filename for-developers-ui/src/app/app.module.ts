import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import { SignInComponent } from './auth/sign-in/sign-in.component';
import { GithubCallbackComponent } from './auth/github-callback/github-callback.component';
import {ReactiveFormsModule} from "@angular/forms";
import {Router} from "@angular/router";
import {ToastrModule} from "ngx-toastr";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { EmployeeDetailsComponent } from './employee-details/employee-details.component';
import { RegistrationComponent } from './auth/registration/registration.component';
import { DemoComponent } from './demo/demo.component';

@NgModule({
  declarations: [
    AppComponent,
    SignInComponent,
    GithubCallbackComponent,
    EmployeeDetailsComponent,
    RegistrationComponent,
    DemoComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
