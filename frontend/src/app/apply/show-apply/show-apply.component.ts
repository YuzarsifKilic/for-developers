import { Component } from '@angular/core';
import {ApplyService} from "../../_services/apply.service";
import {Apply} from "../../_models/apply";

@Component({
  selector: 'app-show-apply',
  templateUrl: './show-apply.component.html',
  styleUrl: './show-apply.component.css'
})
export class ShowApplyComponent {

  applies: Apply[] = [];

  constructor(private applyService: ApplyService) { }

  ngOnInit() {
    this.getApplies();

  }

  getApplies() {
    this.applyService.findAppliesByEmployeeId()
      .then(resp => {
        this.applies = resp.data;
      })
  }

  removeApply() {

  }
}
