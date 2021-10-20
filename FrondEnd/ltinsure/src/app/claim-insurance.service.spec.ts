import { TestBed } from '@angular/core/testing';

import { ClaimInsuranceService } from './claim-insurance.service';

describe('ClaimInsuranceService', () => {
  let service: ClaimInsuranceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ClaimInsuranceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
