import { PolicyService } from './../policy.service';
import { PolicyDto } from './../buy-insurance/policyDto';
import { Component, ElementRef, Input, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { PlansService } from '../available-plans/available-plans.service';
import { Plan } from '../entity/plan';
import { PaymentDto } from './payment.dto';
import { PaymentService } from './payment.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css'],
})
export class PaymentComponent implements OnInit {
  paymentDto: PaymentDto = new PaymentDto();
  policyDto: PolicyDto = new PolicyDto();

  plan: any;
  selectedPlan: Plan | undefined;
  plan_id: number | undefined;
  plan_amount: number = 0;
  plan_dur: number = 0;
  vehicleid: number | undefined;

  constructor(
    private paymentService: PaymentService,
    private policyService: PolicyService,
    private service: PlansService,
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private elementRef: ElementRef
  ) {
    this.service.getAllInsuranceData().subscribe((data: any) => {
      this.plan = data;
    });
    this.activatedRoute.paramMap.subscribe((params) => {
      this.vehicleid = Number(params.get('vehicleid'));
      this.plan_id = Number(params.get('p1'));
      this.plan_amount = Number(params.get('amount'));
      this.plan_dur = Number(params.get('dur'));
    });
  }

  ngOnInit(): void {}
  ngAfterViewInit() {
    this.elementRef.nativeElement.ownerDocument.body.style.backgroundColor =
      '#fff';
  }

  pay() {
    // for (let key of Object.keys(this.plan)) {
    //   let obj = this.plan[key];
    //   if (obj.id == this.plan_id) {
    //     this.plan_amount = obj.amount;
    //   }
    // }
    console.log(this.plan_amount);

    this.paymentDto.amount = this.plan_amount;
    this.paymentService.payNow(this.paymentDto).subscribe((data: any) => {
      // alert(JSON.stringify(data));

      Swal.fire(
        'Payment Successfull!',
        'Policy is generated. You can view the details from dashboard.',
        'success'
      ); 
    });
    alert("Click 'OK' to confirm payment");

    this.policyDto.issueDate = new Date();
    this.policyDto.expiryDate = new Date();
    this.policyDto.planAmount = this.plan_amount;
    this.policyDto.policyAmount = this.plan_amount;
    this.policyDto.duration = this.plan_dur.toString();
    this.policyDto.insurancePlanid = this.plan_id;
    this.policyDto.customerid = JSON.parse(sessionStorage.getItem('id')!);
    this.policyDto.vehicleId = this.vehicleid;
    this.policyService
      .generatePolicy(this.policyDto)
      .subscribe((data: any) => {});

    //create policy service
    //in spring create a mapping to insert data  -->generate policy
    //add in user-dashboard  --mapping getall policy

    this.router.navigate(['userDashboard']);
  }
}
