import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Vehicle } from './entity/vehicle';

@Injectable({
  providedIn: 'root',
})
export class BuyInsuranceService {
  constructor(private http: HttpClient) {}

  buyInsurance(vehicle: Vehicle) {
    console.log(this.http.post('http://localhost:8586/buyInsurance', vehicle));
    return this.http.post('http://localhost:8586/buyInsurance', vehicle);
  }
}
