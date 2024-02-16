import { Component } from '@angular/core';
import {PROJECT_DAY, PROJECT_MONTH, PROJECT_YEAR} from "../_consts/project-day";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {UniversityService} from "../_services/university.service";
import {University} from "../_models/university";
import {CourseService} from "../_services/course.service";
import {Course} from "../_models/course";
import {DEGREE} from "../_consts/degree";
import {EducationService} from "../_services/education.service";
import {ToastrService} from "ngx-toastr";
import {Router} from "@angular/router";

@Component({
  selector: 'app-add-education',
  templateUrl: './add-education.component.html',
  styleUrl: './add-education.component.css'
})
export class AddEducationComponent {

  constructor(private formBuilder: FormBuilder,
              private educationService: EducationService,
              private universityService: UniversityService,
              private courseService: CourseService,
              private tosatr: ToastrService,
              private router: Router) { }

  protected readonly PROJECT_MONTH = PROJECT_MONTH;
  protected readonly PROJECT_YEAR = PROJECT_YEAR;
  protected readonly PROJECT_DAY = PROJECT_DAY;

  educationSaveForm: FormGroup = this.formBuilder.group({
    gnp: ['', Validators.required]
  })

  universities: University[] = [];
  courses: Course[] = [];
  degree!: string;
  universityId!: number;
  courseId!: number;
  startYear!: number;
  endYear!: number;

  ngOnInit(): void {
    this.universityService.getUniversities()
      .then(resp => {
        console.log(resp);
        this.universities = resp.data;
      })
  }

  saveEducation() {
    this.educationService.saveEducation(
      this.universityId,
      this.courseId,
      this.startYear,
      this.endYear,
      this.educationSaveForm.value.gnp,
      this.degree,
      window.localStorage.getItem("user_id")!
    ).then(resp => {
      if (resp.status == 200) {
        this.tosatr.success("Education added successfully!", "Success");
        this.router.navigate(["/employee/home/" + window.localStorage.getItem("user_id")]);
      }
    })
  }

  onSelectUniversity(event: any) {
    let id = event.target.value.split("-")[0]
    this.universityId = id;
    this.courseService.getCourses(id)
      .then(resp => {
        console.log(resp);
        this.courses = resp.data;
      })
  }

  onSelectedStartedYear($event: any) {
    this.startYear = $event.target.value;
  }

  onSelectedFinishYear($event: any) {
    this.endYear = $event.target.value;
  }

  onSelectDegree($event: any) {
    this.degree = $event.target.value;
  }

  protected readonly DEGREE = DEGREE;

  onSelectCourse($event: any) {
    this.courseId = $event.target.value.split("-")[0];
  }
}
