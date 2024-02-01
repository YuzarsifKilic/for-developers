import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdvertisementSaveComponent } from './advertisement-save.component';

describe('AdvertisementSaveComponent', () => {
  let component: AdvertisementSaveComponent;
  let fixture: ComponentFixture<AdvertisementSaveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AdvertisementSaveComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AdvertisementSaveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
