import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {SignInComponent} from "./auth/sign-in/sign-in.component";
import {GithubCallbackComponent} from "./auth/github-callback/github-callback.component";
import {EmployeeDetailsComponent} from "./employee-details/employee-details.component";
import {RegistrationComponent} from "./auth/registration/registration.component";
import {DemoComponent} from "./demo/demo.component";

const routes: Routes = [
  {path: "sign-in", component: SignInComponent},
  {path: "auth/github/callback", component: GithubCallbackComponent},
  {path: ":id/employee-details", component: EmployeeDetailsComponent},
  {path: "registration", component: RegistrationComponent},
  {path: "demo", component: DemoComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
