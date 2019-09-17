import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { UserRegistrationComponent } from './user-registration/user-registration.component';
import { MentorRegistrationComponent } from './mentor-registration/mentor-registration.component';
import { AdminRegistrationComponent } from './admin-registration/admin-registration.component';
import { AppComponent } from './app.component';
import { AdminComponent } from './admin/admin.component';
import { MentorComponent } from './mentor/mentor.component';
import { UserComponent } from './user/user.component';
import { AddSkillComponent } from './add-skill/add-skill.component';
import { PaymentComponent } from './payment/payment.component';


const routes: Routes = [

  { path: '', redirectTo:'/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
 
  { path: 'UserRegistration', component: UserRegistrationComponent },
  { path: 'MentorRegistration', component: MentorRegistrationComponent },
  { path: 'AdminRegistration', component: AdminRegistrationComponent },
  { path: 'Mentor', component: MentorComponent },
  { path: 'Admin', component: AdminComponent },
  { path: 'User', component: UserComponent },
  { path: 'AddSkill', component: AddSkillComponent },
  { path: 'Payments', component: PaymentComponent },
 

 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
