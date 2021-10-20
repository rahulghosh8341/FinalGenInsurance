import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { AboutComponent } from './about/about.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { AvailablePlansComponent } from './available-plans/available-plans.component';
import { BuyInsuranceComponent } from './buy-insurance/buy-insurance.component';
import { ClaimComponent } from './claim/claim.component';
import { ClaimStatusComponent } from './claim-status/claim-status.component';
import { CongratulationsComponent } from './congratulations/congratulations.component';
import { ContactComponent } from './contact/contact.component';

import { EstimateComponent } from './estimate/estimate.component';
import { ForgetPasswordComponent } from './forget-password/forget-password.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { ModelComponent } from './model/model.component';
import { NavigatorComponent } from './navigator/navigator.component';
import { OtpComponent } from './otp/otp.component';
import { PaymentComponent } from './payment/payment.component';
import { PlansComponent } from './plans/plans.component';
import { RegistrationComponent } from './registration/registration.component';
import { RenewComponent } from './renew/renew.component';
import { ResetPasswordComponent } from './reset-password/reset-password.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { FormsModule } from '@angular/forms';
import { RenewpaymentComponent } from './renewpayment/renewpayment.component';
import { RenewsuccessComponent } from './renewsuccess/renewsuccess.component';


@NgModule({
  declarations: [
    AppComponent,
    AboutComponent,
    AdminDashboardComponent,
    AvailablePlansComponent,
    BuyInsuranceComponent,
    ClaimComponent,
    ClaimStatusComponent,
    CongratulationsComponent,
    ContactComponent,

    EstimateComponent,
    ForgetPasswordComponent,
    HomeComponent,
    LoginComponent,
    LogoutComponent,
    ModelComponent,
    NavigatorComponent,
    OtpComponent,
    PaymentComponent,
    PlansComponent,
    RegistrationComponent,
    RenewComponent,
    ResetPasswordComponent,
    UserDashboardComponent,
    RenewpaymentComponent,
    RenewsuccessComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
