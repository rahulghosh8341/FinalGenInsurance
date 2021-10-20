import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  constructor(private router: Router) {}

  ngOnInit(): void {}

  checkSessionBuy() {
    if (sessionStorage.getItem('id') == null) {
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'You need to login to access this feature!',
      });  
    } else this.router.navigate(['buyInsurance']);
  }
  checkSessionCalculate() {
    if (sessionStorage.getItem('id') == null) {
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'You need to login to access this feature!',
      });  
    } else {
      this.router.navigate(['estimate']);
    }
  }
  checkSessionClaim() {
    if (sessionStorage.getItem('id') == null) {
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'You need to login to access this feature!',
      });  
    } else window.location.href =
      'https://www.thebalance.com/understanding-insurance-claims-2645921';
  }
  checkSessionRenew() {
    if (sessionStorage.getItem('id') == null) {
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'You need to login to access this feature!',
      });  
    } else this.router.navigate(['renew']);
  }
}
