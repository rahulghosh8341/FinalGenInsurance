import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { DataDto } from './data.dto';
import { LoginDto } from './login.dto';
import { LoginService } from './login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
  
export class LoginComponent implements OnInit {
  loginDto: LoginDto = new LoginDto();
  dataDto: DataDto = new DataDto();

  constructor(private loginService: LoginService, private router: Router) {}

  ngOnInit(): void {}
  login() {
    this.loginService.login(this.loginDto).subscribe((dataGot) => {
      let data: any;
      data = dataGot;

      if (data.status == 'SUCCESS') {
        let id = data.id;
        let name = data.name;
        let role = data.role;

        sessionStorage.setItem('id', id);
        sessionStorage.setItem('name', name);
        sessionStorage.setItem('role', role);

        if (role == 'ADMIN') {
          this.router.navigate(['adminDashboard']);
        } else {
          this.router.navigate(['userDashboard']);
        }
      } else {
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'Registered E-mail Id or Password didnot match!',
        }); 
        this.router.navigate(['login']);
      }
    });
  }
}
