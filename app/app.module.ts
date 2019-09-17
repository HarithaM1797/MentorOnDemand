import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { UserRegistrationComponent } from './user-registration/user-registration.component';
import { MentorRegistrationComponent } from './mentor-registration/mentor-registration.component';
import { AdminRegistrationComponent } from './admin-registration/admin-registration.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { UserComponent } from './user/user.component';
import { MentorComponent } from './mentor/mentor.component';
import { AdminComponent } from './admin/admin.component';
import { AddSkillComponent } from './add-skill/add-skill.component';
import { PaymentComponent } from './payment/payment.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    UserRegistrationComponent,
    MentorRegistrationComponent,
    AdminRegistrationComponent,
    UserComponent,
    MentorComponent,
    AdminComponent,
    AddSkillComponent,
    PaymentComponent,
  
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
