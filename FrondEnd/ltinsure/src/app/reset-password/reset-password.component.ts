import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { ResetPasswordService } from './reset-password.service';

@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.css'],
})
export class ResetPasswordComponent implements OnInit {
  newPassword: string | undefined;
  confirmPassword: string | undefined;

  isNotSame = false;

  reset = new ResetDto();

  constructor(private service: ResetPasswordService, private router: Router) {}

  ngOnInit(): void {}

  resetPassword() {
    this.reset.emailId = sessionStorage.getItem('email')?.toString();
    console.log(this.reset.emailId);
    this.reset.newPassword = this.newPassword;

    this.service.resetPassword(this.reset).subscribe((dataDto) => {
      let data: any;
      data = dataDto;
      if (data.status == 'SUCCESS') {
        Swal.fire('Password Reset Successful', 'Now you can login with the new Password', 'success');
        this.router.navigate(['login']);
      } else {
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'We are unable to change the password, Try after some time!',
        });  
        this.router.navigate(['home']);
      }
    });
  }
}

export class ResetDto {
  emailId: string | undefined;
  newPassword: string | undefined;
}
