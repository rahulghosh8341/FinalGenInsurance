import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PolicyDto } from './buy-insurance/policyDto';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PolicyService {

  constructor(private http: HttpClient) { }

  generatePolicy(policyDto: PolicyDto): Observable<any> {
    let url = 'http://localhost:8586/generatepolicy';
    return this.http.post<any>(url, policyDto);
  }
}
