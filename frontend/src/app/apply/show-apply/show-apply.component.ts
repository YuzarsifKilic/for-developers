import { Component } from '@angular/core';
import {ApplyService} from "../../_services/apply.service";
import {Apply} from "../../_models/apply";

@Component({
  selector: 'app-show-apply',
  templateUrl: './show-apply.component.html',
  styleUrl: './show-apply.component.css'
})
export class ShowApplyComponent {

  applies$!: Promise<Apply[]>;

  constructor(private applyService: ApplyService) { }

  ngOnInit() {
    this.applies$ =this.getApplies();
  }

  getApplies() {
    return this.applyService.findAppliesByEmployeeId();
  }

  removeApply() {

  }
}
