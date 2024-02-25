import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompanyAdvertisementListComponent } from './company-advertisement-list.component';

describe('CompanyAdvertisementListComponent', () => {
  let component: CompanyAdvertisementListComponent;
  let fixture: ComponentFixture<CompanyAdvertisementListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CompanyAdvertisementListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CompanyAdvertisementListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
