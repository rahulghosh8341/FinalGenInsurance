import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class ForgotPasswordService {
  emailDto = new EmailDto();
  constructor(private http: HttpClient) {}

  sendOtp(email: String) {
    this.emailDto.email = email;
    const url = 'http://localhost:8586/forgotPassword';
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      Accept: 'application/json',
    });
    return this.http.post(url, this.emailDto, { headers: headers });
  }
}

export class EmailDto {
  email: String | undefined;
}
