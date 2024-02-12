import { Component } from '@angular/core';
import {AuthService} from "../_services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {

  loggedIn!: boolean;
  username!: string;

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
    this.authService.username$.subscribe((value) => {
      this.username = value;
      console.log(this.username);
    })
    this.authService.loggedIn$.subscribe((value) => {
      this.loggedIn = value;
    })
  }


  signIn() {
    this.router.navigate(['/sign-in']);
  }

  homePage() {
    if (window.localStorage.getItem("auth_role") === "ROLE_EMPLOYEE") {
      this.router.navigate(["employee/home/" + window.localStorage.getItem("user_id")]);
    } else if (window.localStorage.getItem("auth_role") === "ROLE_COMPANY") {
      this.router.navigate(["company/home/" + window.localStorage.getItem("user_id")]);
    }
  }
}
