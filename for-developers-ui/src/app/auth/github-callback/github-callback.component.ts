import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "../../_services/auth.service";
import {first} from "rxjs";

@Component({
  selector: 'app-github-callback',
  templateUrl: './github-callback.component.html',
  styleUrl: './github-callback.component.css'
})
export class GithubCallbackComponent implements OnInit {

  constructor(private route: ActivatedRoute,
              private authService: AuthService,
              private router: Router) {
    this.route.queryParams.subscribe(params => {
      this.getAccessToken(params["code"])
    })
  }

  ngOnInit(): void {
  }

  private getAccessToken(code: string) {
    this.authService.getAccessToken(code)
      .pipe(first())
      .subscribe((resp) => {
        alert(resp.access_token)
        localStorage.setItem("token", resp.accessToken)
        setTimeout(() => {
          this.router.navigate([""])
        }, 2000);
      }, error => {
        console.log(error)
      })
  }
}
