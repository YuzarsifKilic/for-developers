import { Component } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AdvertisementService} from "../../_services/advertisement.service";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-advertisement-save',
  templateUrl: './advertisement-save.component.html',
  styleUrl: './advertisement-save.component.css'
})
export class AdvertisementSaveComponent {

  companyId!: string;

  workTypes = [
    {id: 1, name: "Remote"},
    {id: 2, name: "Hybrid"},
    {id: 3, name: "Freelance"},
    {id: 4, name: "Part Time"},
    {id: 5, name: "On Site"},
    {id: 6, name: "Flexible"},
    {id: 7, name: "Working"}
  ];

  jobTitles = [
    {id: 1, name: "Backend Developer"},
    {id: 2, name: "Frontend Developer"},
    {id: 3, name: "Full Stack Developer"},
    {id: 4, name: "Mobile Developer"},
    {id: 5, name: "Android Developer"},
    {id: 6, name: "IOS Developer"},
    {id: 7, name: "Data Science"},
    {id: 8, name: "Data Analyst"},
    {id: 9, name: "Data Engineer"},
    {id: 10, name: "Data Architect"},
    {id: 11, name: "Data Scientist"},
  ]


  constructor(private activatedRoute: ActivatedRoute,
              private formBuilder: FormBuilder,
              private advertisementService: AdvertisementService,
              private toastr: ToastrService,
              private router: Router) { }

  advertisementSaveForm: FormGroup = this.formBuilder.group({
    advertisementTitle: ['', Validators.required],
    advertisementContent: ['', Validators.required]
  })

  workType =  this.workTypes[0].name;
  jobTitle = this.jobTitles[0].name;

  ngOnInit(): void {
    this.companyId = this.activatedRoute.snapshot.paramMap.get('id') as string;
  }

  onSelectChange(event: any) {
    let selectedValue = event.target.value;
    console.log(selectedValue);
    this.jobTitle = selectedValue.toUpperCase().replace(" ", "_");
  }

  onSelectWorkType(event: any) {
    let selectedValue = event.target.value;
    console.log(selectedValue.toUpperCase().replace(" ", "_"));
    this.workType = selectedValue.toUpperCase().replace(" ", "_");
  }

  saveAdvertisement() {
    console.log(this.advertisementSaveForm.value);
    this.advertisementService.saveAdvertisement(
      this.advertisementSaveForm.get("advertisementTitle")?.value,
      this.advertisementSaveForm.get("advertisementContent")?.value,
      this.workType.toUpperCase(),
      this.jobTitle)
      .then(resp => {
        if (resp.status === 200) {
          this.router.navigate(["company/home/" + window.localStorage.getItem("user_id")]);
          this.toastr.success("Advertisement saved", "Success");
        } else {
          this.toastr.error("Something went wrong", "Error");
        }
      })
  }
}
