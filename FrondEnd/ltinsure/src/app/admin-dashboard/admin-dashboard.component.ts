import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApproveClaim } from '../entity/approveClaim';
import { AdminDashboardService } from './admin-dashboard.service';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css'],
})
export class AdminDashboardComponent implements OnInit {
  data: any;
  customerCount: any;
  renewCount: any;
  claimCount: any;
  name = sessionStorage.getItem('name');

  constructor(private service: AdminDashboardService, private router: Router) {}

  statusUpdate(id: any, status: any) {
    let data = new ApproveClaim();

    data.claimId = id;
    data.status = status;

    this.service.updateStatus(data).subscribe((data) => {
      window.location.reload();
    });
  }

  logout() {
    sessionStorage.clear();
    this.router.navigate(['login']);
  }

  ngOnInit(): void {
    this.service.fetchClaimData('PENDING').subscribe((data) => {
      this.data = data;
    });

    this.service.fetchCustomerCount().subscribe((data) => {
      this.customerCount = data;
    });

    this.service.fetchClaimCount().subscribe((data) => {
      this.claimCount = data;
    });

    this.service.fetchRenewCount().subscribe((data) => {
      this.renewCount = data;
    });
  }
}
