import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {SignInComponent} from "./auth/sign-in/sign-in.component";
import {GithubCallbackComponent} from "./auth/github-callback/github-callback.component";

const routes: Routes = [
  {path: "sign-in", component: SignInComponent},
  {path: "auth/github/callback", component: GithubCallbackComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
