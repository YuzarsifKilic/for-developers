import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowApplyComponent } from './show-apply.component';

describe('ShowApplyComponent', () => {
  let component: ShowApplyComponent;
  let fixture: ComponentFixture<ShowApplyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ShowApplyComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ShowApplyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
