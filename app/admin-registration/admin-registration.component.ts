import { Component, OnInit } from '@angular/core';
import { LoginService } from '../service/login.service';

import { AdminService } from '../admin.service';
import { Admin } from '../model/Admin';

@Component({
  selector: 'app-admin-registration',
  templateUrl: './admin-registration.component.html',
  styleUrls: ['./admin-registration.component.css']
})
export class AdminRegistrationComponent implements OnInit {

  
  admin: Admin = new Admin();
  submitted = false;

  constructor(private adminService: AdminService) { }

  ngOnInit() {
  }
  newAdmin(): void {
    this.submitted = false;
    this.admin = new Admin();
  }

  save() {
    this.adminService.createAdmin(this.admin)
      .subscribe(data => console.log(data), error => console.log(error));
    this.admin = new Admin();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

}
