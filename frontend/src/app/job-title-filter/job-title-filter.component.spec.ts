import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JobTitleFilterComponent } from './job-title-filter.component';

describe('JobTitleFilterComponent', () => {
  let component: JobTitleFilterComponent;
  let fixture: ComponentFixture<JobTitleFilterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [JobTitleFilterComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(JobTitleFilterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
