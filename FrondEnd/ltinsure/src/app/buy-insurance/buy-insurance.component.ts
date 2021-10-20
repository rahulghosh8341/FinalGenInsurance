import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BuyInsuranceService } from '../buy-insurance.service';
import { Vehicle } from '../entity/vehicle';
import { LoginService } from '../login/login.service';

@Component({
  selector: 'app-buy-insurance',
  templateUrl: './buy-insurance.component.html',
  styleUrls: ['./buy-insurance.component.css'],
})
export class BuyInsuranceComponent implements OnInit {
  vehicle: Vehicle = new Vehicle();
  vehicleid: number | undefined;

  constructor(
    private service: BuyInsuranceService,
    private router: Router,
    private loginService: LoginService
  ) {}

  buyInsurance() {
    this.service
      .buyInsurance(this.setVehicleDto(this.vehicle))
      .subscribe((data) => {
        this.vehicleid = +JSON.stringify(data);
        this.router.navigate(['availablePlans', this.vehicleid]);
      });
   
  }

  setVehicleDto(vehicle: Vehicle) {
    vehicle.customerId = JSON.parse(sessionStorage.getItem('id')!);
    return vehicle;
  }

  ngOnInit(): void {}
}
