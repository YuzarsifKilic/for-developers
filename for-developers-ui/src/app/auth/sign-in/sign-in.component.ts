import { Component } from '@angular/core';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrl: './sign-in.component.css'
})
export class SignInComponent {


  authorizeGithub() {
    window.location.href = "http://localhost:8080/auth/github/authorize"
  }
}
