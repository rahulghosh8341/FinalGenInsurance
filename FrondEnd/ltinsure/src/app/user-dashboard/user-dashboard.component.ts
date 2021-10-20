import { Customer } from './../renew/cutomer';
import { UserDashboardService } from './user-dashboard.service';
import { Component, ElementRef, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css'],
})
export class UserDashboardComponent implements OnInit {
  date: Date = new Date();
  datepipe: DatePipe = new DatePipe('en-US');
  formattedDate = this.datepipe.transform(this.date, 'MMMM d, y');
  formattedDate2 = this.datepipe.transform(this.date, 'MMMM d');
  id = sessionStorage.getItem('id');
  name = sessionStorage.getItem('name');
  role = sessionStorage.getItem('role');
  policies: any;
  noPolicies: boolean = false;
  approvedClaim: any;
  notApprovedClaim: any;
  constructor(
    private service: UserDashboardService,
    private router: Router,
    private elementRef: ElementRef
  ) {
    this.service.getAllPolicies().subscribe((data: any) => {
      this.policies = data;
    });
    console.log(this.id);
  }

  ngOnInit(): void {
    this.service.fetchClaimData('Approved').subscribe((data) => {
      this.approvedClaim = data;
    });
    this.service.fetchClaimData('Not Approved').subscribe((data) => {
      this.notApprovedClaim = data;
    });
  }
  ngAfterViewInit() {
    this.elementRef.nativeElement.ownerDocument.body.style.backgroundColor =
      '#f3f6fd';
  }

  logout() {
    sessionStorage.clear();

    this.router.navigate(['home']);
  }
  calculateDiff(data1: Date, data2: Date) {
    console.log(data1, data2);
    let expdate = new Date(data1);
    let issueDate = new Date(data2);

    let days = Math.floor(
      (expdate.getTime() - issueDate.getTime()) / 1000 / 60 / 60 / 24
    );
    return days;
  }
}
