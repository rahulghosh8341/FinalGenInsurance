import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OtpService } from './otp.service';

@Component({
  selector: 'app-otp',
  templateUrl: './otp.component.html',
  styleUrls: ['./otp.component.css'],
})
export class OtpComponent implements OnInit {
  constructor(private router: Router, private service: OtpService) {}
  otp: string | undefined;
  ngOnInit(): void {}

  verifyOtp() {
    //this.service.verifyOtp(this.otp).subscribe(dataDto =>{
    let data: any;
    //data = dataDto
    //if(data.status == 'SUCCESS'){
    //sessionStorage.setItem('forgotEmail', data.emailId)
    this.router.navigate(['resetPassword']);
    //}
    //else{
    //this.router.navigate(['forgetPassword'])
    //}
    //})
  }
}
