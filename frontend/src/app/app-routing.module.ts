import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {SignInComponent} from "./sign-in/sign-in.component";
import {AdvertisementsComponent} from "./advertisements/advertisements.component";
import {RegisterComponent} from "./employee/register/register.component";

const routes: Routes = [
  {path: "sign-in", component: SignInComponent},
  {path: "advertisements", component: AdvertisementsComponent},
  {path: "employee/register", component: RegisterComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
