import { Component } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {ProjectService} from "../../_services/project.service";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-github-callback',
  templateUrl: './github-callback.component.html',
  styleUrl: './github-callback.component.css'
})
export class GithubCallbackComponent {

  userId = window.localStorage.getItem("user_id");

  constructor(private route: ActivatedRoute,
              private projectService: ProjectService,
              private router: Router,
              private toastr: ToastrService) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      window.localStorage.setItem("github_code", params['code']);
    })
    this.validateGithubUser(window.localStorage.getItem("github_code")!);
  }

  validateGithubUser(code: string) {
    this.projectService.validateGithubUser(code).then(resp => {
      if (resp === true) {
        this.toastr.success("Successfully connected redirecting to app", "Success");
        this.router.navigate(["employee/" + this.userId + "/project"]);
      } else {
        this.toastr.error("Your github username doesn't match", "Error");
      }
    })
  }
}
