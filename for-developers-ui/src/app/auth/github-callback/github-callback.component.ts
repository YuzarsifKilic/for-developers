import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "../../_services/auth.service";
import {first} from "rxjs";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {EmployeeService} from "../../_services/employee.service";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-github-callback',
  templateUrl: './github-callback.component.html',
  styleUrl: './github-callback.component.css'
})
export class GithubCallbackComponent implements OnInit {

  saveEmployeeForm: FormGroup = this.formBuilder.group({
    firstName: ['', Validators.required],
    lastName: ['', Validators.required],
    email: ['', Validators.required],
    githubUsername: ['', Validators.required],
    phoneNumber: ['', Validators.required]
  })

  constructor(private formBuilder: FormBuilder,
              private route: ActivatedRoute,
              private authService: AuthService,
              private router: Router,
              private employeeService: EmployeeService,
              private toastr: ToastrService) {
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
        localStorage.setItem("token", resp.access_token)
      }, error => {
        console.log(error)
      })
  }

  saveEmployee() {
    this.employeeService.createEmployee(
      this.saveEmployeeForm.get("firstName")?.value,
      this.saveEmployeeForm.get("lastName")?.value,
      this.saveEmployeeForm.get("email")?.value,
      this.saveEmployeeForm.get("githubUsername")?.value,
      this.saveEmployeeForm.get("phoneNumber")?.value)
      .pipe(first())
      .subscribe((resp) =>{
        this.toastr.success("Sucessfully logged in, redirecting to details page...", "Success");
        localStorage.setItem("githubUsername", resp.githubUsername)
        setTimeout(() => {
          this.router.navigate([`${resp.id}/employee-details`])
        }, 2000);
      }, error => {
        console.log(error)
        this.toastr.error(error.error.message, "Error")
      })
  }
}
