import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PlansService } from './available-plans.service';

@Component({
  selector: 'app-available-plans',
  templateUrl: './available-plans.component.html',
  styleUrls: ['./available-plans.component.css'],
})
export class AvailablePlansComponent implements OnInit {
  plan: any;
  plan_id: number | undefined;
  plan_amount: number | undefined;
  plan_dur!: number;
  vehicleid: number |undefined;
  constructor(
    private service: PlansService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.service.getAllInsuranceData().subscribe((data: any) => {
      this.plan = data;
    });

    this.activatedRoute.paramMap.subscribe((params) => {
      this.vehicleid = Number(params.get('vehicleid'));
    });
  }
  selectPlan(id: number, amount: number) {
    console.log(id);
    this.plan_id = id;
    this.plan_amount = amount*this.plan_dur;
    this.router.navigate([
      'payment',
      this.vehicleid,
      this.plan_id,
      this.plan_amount,
      this.plan_dur
    ]);
  }
}
