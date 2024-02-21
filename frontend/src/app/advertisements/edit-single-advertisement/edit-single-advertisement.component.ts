import { Component } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {AdvertisementService} from "../../_services/advertisement.service";
import {Advertisement} from "../../_models/advertisement";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-edit-single-advertisement',
  templateUrl: './edit-single-advertisement.component.html',
  styleUrl: './edit-single-advertisement.component.css'
})
export class EditSingleAdvertisementComponent {

  advertisementId!: number;
  advertisement$!: Promise<Advertisement>;

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

  advertisementSaveForm: FormGroup = this.formBuilder.group({
    advertisementTitle: ['', Validators.required],
    advertisementContent: ['', Validators.required]
  })

  workType =  this.workTypes[0].name;
  jobTitle = this.jobTitles[0].name;

  constructor(private route: ActivatedRoute, private advertisementService: AdvertisementService, private formBuilder: FormBuilder, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.advertisementId = params['advertisementId'];
    })
    this.advertisement$ = this.getAdvertisement();
  }

  getAdvertisement() {
    return this.advertisementService.getAdvertisementByAdvertisementId(this.advertisementId);
  }

  onSelectJobTitle(event: any) {
    let selectedValue = event.target.value;
    this.jobTitle = selectedValue.toUpperCase().replace(" ", "_");
  }

  onSelectWorkType(event: any) {
    let selectedValue = event.target.value;
    this.workType = selectedValue.toUpperCase().replace(" ", "_");
  }

  updateAdvertisement() {
    this.advertisementService.updateAdvertisement(
      this.advertisementSaveForm.get("advertisementTitle")?.value,
      this.advertisementSaveForm.get("advertisementContent")?.value,
      this.workType,
      this.jobTitle,
      this.advertisementId)
      .then(resp => {
        if (resp.status === 200) {
          this.toastr.success("Advertisement updated successfully!", "Success!");
        } else {
          this.toastr.error(resp.data, "Error!");
        }
      })
  }
}
