import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {ProjectService} from "../../_services/project.service";
import {GithubRepositoryResponse} from "../../_models/github-repository-response";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-add-project',
  templateUrl: './add-project.component.html',
  styleUrl: './add-project.component.css'
})
export class AddProjectComponent {

  githubRepositoryResponses: GithubRepositoryResponse[] = [];
  githubRepository!: GithubRepositoryResponse;

  projectSaveForm: FormGroup = this.formBuilder.group({
    projectTitle: ['', Validators.required],
    projectDescription: ['', Validators.required]
  })

  constructor(private router: Router, private projectService: ProjectService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    if (window.localStorage.getItem("user_id") === null || window.localStorage.getItem("auth_token") === null || window.localStorage.getItem("auth_role") === null) {
      this.router.navigate(["/sign-in"]);
    }

    this.getRepositories();
  }

  getRepositories() {
    this.projectService.findRepositories(window.localStorage.getItem("github_code")!)
      .then(resp => {
        this.githubRepositoryResponses = resp;
      })
  }

  onSelectRepository(event: any) {
    this.githubRepository = event.target.value;
  }

  saveProject() {

  }
}
