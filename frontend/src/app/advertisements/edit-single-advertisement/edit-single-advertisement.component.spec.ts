import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditSingleAdvertisementComponent } from './edit-single-advertisement.component';

describe('EditSingleAdvertisementComponent', () => {
  let component: EditSingleAdvertisementComponent;
  let fixture: ComponentFixture<EditSingleAdvertisementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [EditSingleAdvertisementComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EditSingleAdvertisementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
