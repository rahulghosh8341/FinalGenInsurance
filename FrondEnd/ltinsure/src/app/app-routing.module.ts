import { RenewsuccessComponent } from './renewsuccess/renewsuccess.component';
import { RenewpaymentComponent } from './renewpayment/renewpayment.component';
import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RenewComponent } from './renew/renew.component';
import { PlansComponent } from './plans/plans.component';
import { BuyInsuranceComponent } from './buy-insurance/buy-insurance.component';
import { EstimateComponent } from './estimate/estimate.component';
import { ClaimComponent } from './claim/claim.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { HomeComponent } from './home/home.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { PaymentComponent } from './payment/payment.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { CongratulationsComponent } from './congratulations/congratulations.component';
import { ClaimStatusComponent } from './claim-status/claim-status.component';
import { ContactComponent } from './contact/contact.component';
import { ForgetPasswordComponent } from './forget-password/forget-password.component';
import { OtpComponent } from './otp/otp.component';
import { AboutComponent } from './about/about.component';
import { AvailablePlansComponent } from './available-plans/available-plans.component';
import { ResetPasswordComponent } from './reset-password/reset-password.component';
const routes: Routes = [
  { path: 'renew', component: RenewComponent },
  { path: 'renewpayment/:amount/:dur', component: RenewpaymentComponent },
  { path: 'congratulationsrenew', component: RenewsuccessComponent },
  { path: 'plans', component: PlansComponent },
  { path: 'buyInsurance', component: BuyInsuranceComponent },
  { path: 'claimInsurance/:amount', component: ClaimComponent },
  { path: 'estimate', component: EstimateComponent },
  { path: 'login', component: LoginComponent },
  { path: 'registration', component: RegistrationComponent },
  { path: 'home', component: HomeComponent },
  { path: '', component: HomeComponent },
  { path: 'userDashboard', component: UserDashboardComponent },
  { path: 'adminDashboard', component: AdminDashboardComponent },
  { path: 'payment/:vehicleid/:p1/:amount/:dur', component: PaymentComponent },
  { path: 'congratulations', component: CongratulationsComponent },
  { path: 'claimStatus', component: ClaimStatusComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'otp', component: OtpComponent },
  { path: 'forgetPassword', component: ForgetPasswordComponent },
  { path: 'about', component: AboutComponent },
  { path: 'availablePlans/:vehicleid', component: AvailablePlansComponent },
  { path: 'resetPassword', component: ResetPasswordComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
