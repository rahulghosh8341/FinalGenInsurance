import { Injectable } from '@angular/core';
import { PaymentDto } from './payment.dto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class PaymentService {
  constructor(private http: HttpClient) {}

  payNow(paymentDto: PaymentDto): Observable<any> {
    let url = 'http://localhost:8586/payment';
    return this.http.post<any>(url, paymentDto);
  }
}
