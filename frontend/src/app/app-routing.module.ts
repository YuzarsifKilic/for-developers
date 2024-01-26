import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {SignInComponent} from "./sign-in/sign-in.component";
import {AdvertisementsComponent} from "./advertisements/advertisements.component";

const routes: Routes = [
  {path: "sign-in", component: SignInComponent},
  {path: "advertisements", component: AdvertisementsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
