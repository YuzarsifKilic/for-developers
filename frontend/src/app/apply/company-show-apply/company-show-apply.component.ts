import { Component } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Apply} from "../../_models/apply";
import {CompanyApply} from "../../_models/company-apply";
import {ApplyService} from "../../_services/apply.service";

@Component({
  selector: 'app-company-show-apply',
  templateUrl: './company-show-apply.component.html',
  styleUrl: './company-show-apply.component.css'
})
export class CompanyShowApplyComponent {

  advertisementId!: number;
  applies$!: Promise<CompanyApply[]>;

  constructor(private route: ActivatedRoute, private applyService: ApplyService, private router: Router) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.advertisementId = params['advertisementId'];
    })
    this.applies$ = this.getApplies(this.advertisementId);
  }

  getApplies(advertisementId: number): Promise<CompanyApply[]> {
    return this.applyService.findAppliesByCompanyId(advertisementId);
  }

  employeePage(id: string) {
    this.router.navigate(["/employee/" + id]);
  }
}
