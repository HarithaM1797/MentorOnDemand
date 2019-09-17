import { Component, OnInit } from '@angular/core';
import { LoginService } from '../service/login.service';

import { UserServiceService } from '../user-service.service';
import { User } from '../model/User';

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent implements OnInit {

  user: User = new User();
  submitted = false;

  constructor(private userService: UserServiceService ) { }

  ngOnInit() {
  }
  newUser(): void {
    this.submitted = false;
    this.user = new User();
  }

  save() {
    console.log(this.user)
    this.userService.createUser(this.user)
    
      .subscribe(data => console.log(data), error => console.log(error));
    this.user = new User();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

}
