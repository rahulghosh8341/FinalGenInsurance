import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Policy } from './policy';
import { Observable } from 'rxjs';
//import { Customer } from './customer';
//import { InsurancePlan } from './insurance_plan';
@Injectable({
  providedIn: 'root',
})
export class RenewService {
  constructor(private http: HttpClient) {}

  renew(policy: Policy): Observable<any> {
    let url = 'http://localhost:8586/renew';
    return this.http.post<any>(url, policy);
  }
}
