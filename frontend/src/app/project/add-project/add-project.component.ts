import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {ProjectService} from "../../_services/project.service";
import {GithubRepositoryResponse} from "../../_models/github-repository-response";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {PROJECT_DAY, PROJECT_MONTH, PROJECT_YEAR} from "../../_consts/project-day";

@Component({
  selector: 'app-add-project',
  templateUrl: './add-project.component.html',
  styleUrl: './add-project.component.css'
})
export class AddProjectComponent {

  githubRepositoryResponses: GithubRepositoryResponse[] = [];
  githubRepository!: GithubRepositoryResponse;
  startedDay!: number;
  startedMonth!: number;
  startedYear!: number;
  finishedDay!: number;
  finishedMonth!: number;
  finishedYear!: number;

  protected readonly PROJECT_DAY = PROJECT_DAY;
  protected readonly PROJECT_MONTH = PROJECT_MONTH;
  protected readonly PROJECT_YEAR = PROJECT_YEAR;

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

  saveProject() {
    let startedDate = this.startedYear + "-" + this.startedMonth + "-" + this.startedDay;
    let finishedDate = this.finishedYear + "-" + this.finishedMonth + "-" + this.finishedDay;
    this.projectService
      .saveProject(
        this.projectSaveForm.get("projectTitle")?.value,
        this.projectSaveForm.get("projectDescription")?.value,
        startedDate,
        finishedDate,
        this.githubRepository.htmlUrl);
  }

  onSelectRepository(event: any) {
    this.githubRepository = event.target.value;
  }

  onSelectStartedDay(event: any) {
    this.startedDay = event.target.value;
  }


  onSelectedStartedMonth(event: any) {
    this.startedMonth = event.target.value;
  }

  onSelectedStartedYear(event: any) {
    this.startedYear = event.target.value;
  }

  onSelectedFinishDay(event: any) {
    this.finishedDay = event.target.value;
  }

  onSelectedFinishMonth(event: any) {
    this.finishedMonth = event.target.value;
  }

  onSelectedFinishYear(event: any) {
    this.finishedYear = event.target.value;
  }
}
