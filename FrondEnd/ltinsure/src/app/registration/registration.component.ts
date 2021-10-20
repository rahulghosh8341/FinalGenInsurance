import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { DataDto } from '../login/data.dto';
import { Customer } from '../model/customer';
import { RegisterationService } from './registration.service';
@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css'],
})
export class RegistrationComponent implements OnInit {
  datadto: DataDto = new DataDto();
  customer: Customer = new Customer();
  successfull: boolean = false;
  confirmpassword: string | undefined;
  constructor(
    private customerService: RegisterationService,
    private router: Router
  ) {}
  ngOnInit(): void {}
  register() {
    this.customerService.register(this.customer).subscribe((data) => {
      if (data.status == 'SUCCESS') {
        Swal.fire(
          'Registration Successful!',
          'You can now login to LTInsure!',
          'success'
        );
        this.router.navigate(['login']);
      } else {
        //If error re register
        //alert(JSON.stringify(data));
        const values = Object.values(data);
        Swal.fire({
          icon: 'error',
          title: values[0],
          text: 'Email id is already taken!',
        });
        this.router.navigate(['register']);
      }
    });
  }
}
