import { Injectable, Component } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class UserDashboardService {
  constructor(private http: HttpClient) {}

  // Common utility
  isUserLoggedIn(id: string) {
    let user = sessionStorage.getItem(id);
    if (user === null) {
      return false;
    } else {
      return true;
    }
  }
  fetchClaimData(status: String) {
    return this.http.get('http://localhost:8586/getByClaimStatus/' + status);
  }

  getLoggedInId() {
    let user = sessionStorage.getItem('id');
    if (user === null) {
      return '';
    } else {
      return user;
    }
  }

  getLoggedInRole() {
    let role = sessionStorage.getItem('role');
    if (role === null) {
      return '';
    } else {
      return role;
    }
  }

  getAllPolicies() {
    return this.http.get('http://localhost:8586/getAllPolicy');
  }
}
