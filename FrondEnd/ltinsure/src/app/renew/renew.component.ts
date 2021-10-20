import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { Customer } from './cutomer';
import { InsurancePlan } from './insurance_plan';
import { Policy } from './policy';
import { RenewService } from './renew.service';

@Component({
  selector: 'app-renew',
  templateUrl: './renew.component.html',
  styleUrls: ['./renew.component.css'],
})
export class RenewComponent implements OnInit {
  policy: Policy = new Policy();
  customer: Customer = new Customer();
  values: any|undefined;
  constructor(private renewService: RenewService, private router: Router) {}
  ngOnInit(): void {}

  renewPlan() {
    this.renewService.renew(this.policy).subscribe((data) => {
        this.values = Object.values(data);
       console.log(this.values[0]);
    });

    if (this.values[0] === 'SUCCESS') {
      alert('Thank you ! Please proceed for payment');
      this.router.navigate([
        'renewpayment',
        this.policy.planAmount,
        this.policy.duration,
      ]);
    } else if (
      this.values[0] === 'FAILURE' &&
      this.values[1] === 'Policy does not exist'
    ) {
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: this.values[1],
      });
      this.router.navigate(['renew']);
    } else if (
      this.values[0] === 'FAILURE' &&
      this.values[1] === 'Policy has not expired yet. Cannot be renewed'
    ) {
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: this.values[1],
      });
      this.router.navigate(['renew']);
    }  
  }
}
