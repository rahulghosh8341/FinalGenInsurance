import { TestBed } from '@angular/core/testing';

import { BuyInsuranceService } from './buy-insurance.service';

describe('BuyInsuranceService', () => {
  let service: BuyInsuranceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BuyInsuranceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
