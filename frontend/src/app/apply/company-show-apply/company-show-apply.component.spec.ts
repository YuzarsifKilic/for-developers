import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompanyShowApplyComponent } from './company-show-apply.component';

describe('CompanyShowApplyComponent', () => {
  let component: CompanyShowApplyComponent;
  let fixture: ComponentFixture<CompanyShowApplyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CompanyShowApplyComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CompanyShowApplyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
