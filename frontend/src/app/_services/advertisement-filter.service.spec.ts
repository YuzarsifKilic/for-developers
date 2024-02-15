import { TestBed } from '@angular/core/testing';

import { AdvertisementFilterService } from './advertisement-filter.service';

describe('AdvertisementFilterService', () => {
  let service: AdvertisementFilterService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdvertisementFilterService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
