import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import { SignInComponent } from './auth/sign-in/sign-in.component';
import { GithubCallbackComponent } from './auth/github-callback/github-callback.component';

@NgModule({
  declarations: [
    AppComponent,
    SignInComponent,
    GithubCallbackComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
