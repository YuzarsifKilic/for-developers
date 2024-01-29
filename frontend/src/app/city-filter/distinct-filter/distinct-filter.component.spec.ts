import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DistinctFilterComponent } from './distinct-filter.component';

describe('DistinctFilterComponent', () => {
  let component: DistinctFilterComponent;
  let fixture: ComponentFixture<DistinctFilterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DistinctFilterComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DistinctFilterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
