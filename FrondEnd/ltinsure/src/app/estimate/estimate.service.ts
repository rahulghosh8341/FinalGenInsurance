import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Premium } from './premium';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class EstimateService {
  constructor(private http: HttpClient) {}

  estimate(premium: Premium): Observable<any> {
    let url = 'http://localhost:8586/estimate';
    return this.http.post<any>(url, premium);
  }
}
