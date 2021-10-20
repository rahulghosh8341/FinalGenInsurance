import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';
import { PlansService } from '../available-plans/available-plans.service';
import { PolicyDto } from '../buy-insurance/policyDto';
import { Plan } from '../entity/plan';
import { PaymentDto } from '../payment/payment.dto';
import { PaymentService } from '../payment/payment.service';
import { PolicyService } from '../policy.service';

@Component({
  selector: 'app-renewpayment',
  templateUrl: './renewpayment.component.html',
  styleUrls: ['./renewpayment.component.css'],
})
export class RenewpaymentComponent implements OnInit {
  plan_amount: number | undefined;
  plan_dur: number | undefined;
  paymentDto1: PaymentDto = new PaymentDto();
  policyDto1: PolicyDto = new PolicyDto();

  plan: any;
  selectedPlan: Plan | undefined;
  plan_id: number | undefined;

  vehicleid: number | undefined;

  constructor(
    private paymentService: PaymentService,
    private policyService: PolicyService,
    private service: PlansService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {
    this.activatedRoute.paramMap.subscribe((params) => {
      this.plan_amount =
        Number(params.get('amount')) * Number(params.get('dur'));
    });
  }
  ngOnInit(): void {}

  makepayment() {
    console.log(this.plan_amount);

    this.paymentDto1.amount = this.plan_amount;
    this.paymentService.payNow(this.paymentDto1).subscribe((data: any) => {
      
      Swal.fire(
        'Payment Successfull!',
        'Policy has been renewed. You can view the details from dashboard!',
        'success'
      ); 
    });
    alert("Click 'OK' to confirm payment");

    this.router.navigate(['userDashboard']);
  }
}
