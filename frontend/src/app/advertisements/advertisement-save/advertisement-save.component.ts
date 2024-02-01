import { Component } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

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
    {id: 4, name: "Mobile App Developer"},
    {id: 5, name: "Android Developer"},
    {id: 6, name: "IOS Developer"},
    {id: 7, name: "Data Science"},
    {id: 8, name: "Data Analyst"},
    {id: 9, name: "Data Engineer"},
    {id: 10, name: "Data Architect"},
    {id: 11, name: "Data Scientist"},
  ];

  workTypeId!: number;
  jobTitleId!: number;


  constructor(private activatedRoute: ActivatedRoute, private formBuilder: FormBuilder) { }

  advertisementSaveForm: FormGroup = this.formBuilder.group({
    advertisementTitle: ['', Validators.required],
    advertisementContent: ['', Validators.required]
  })

  ngOnInit(): void {
    this.companyId = this.activatedRoute.snapshot.paramMap.get('id') as string;
  }

  onSelectChange(event: any) {
    let selectedValue = event.target.value;
    console.log(selectedValue);
    this.jobTitleId = selectedValue;
  }

  onSelectWorkType(event: any) {
    let selectedValue = event.target.value;
    console.log(selectedValue);
    this.workTypeId = selectedValue;
  }

  saveAdvertisement() {
    console.log(this.advertisementSaveForm.value);
    console.log(this.jobTitleId);
    console.log(this.workTypeId);
  }
}
