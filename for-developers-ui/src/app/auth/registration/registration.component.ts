import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AuthService} from "../../_services/auth.service";
import {first} from "rxjs";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrl: './registration.component.css'
})
export class RegistrationComponent implements OnInit{

  constructor(private authService: AuthService) { }

  getAuthenticationInfo() {
    this.authService.getAuthInfo()
      .pipe(first())
      .subscribe((resp) => {
        console.log(resp);
      })
  }

  ngOnInit(): void {
    this.getAuthenticationInfo();
  }

}
