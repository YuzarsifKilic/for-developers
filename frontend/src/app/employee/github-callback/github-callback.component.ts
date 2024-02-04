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

  constructor(private route: ActivatedRoute,
              private projectService: ProjectService,
              private router: Router,
              private toastr: ToastrService) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.projectService.code = params['code'];
      window.localStorage.setItem("github_code", params['code']);
      this.toastr.success("Successfully connected redirecting to home page", "Success");
      this.router.navigate(["employee/home/" + window.localStorage.getItem("user_id")]);
    })
  }

}
