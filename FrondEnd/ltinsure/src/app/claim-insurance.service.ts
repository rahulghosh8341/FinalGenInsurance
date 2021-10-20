import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ApproveClaim } from './entity/approveClaim';
import { Claim } from './entity/claim';

@Injectable({
  providedIn: 'root',
})
export class ClaimInsuranceService {
  constructor(private http: HttpClient) {}

  claimInsurance(claim: Claim) {
    return this.http.post('http://localhost:8586/addClaimInsurance', claim);
  }

  updateStatus(approveClaim: ApproveClaim) {
    return this.http.post(
      'http://localhost:8586/updateClaimStatus',
      approveClaim
    );
  }
}
