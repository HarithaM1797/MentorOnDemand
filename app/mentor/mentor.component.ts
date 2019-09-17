import { Component, OnInit } from '@angular/core';
import { LoginService } from '../service/login.service';
import { MentorService } from '../mentor.service';

@Component({
  selector: 'app-mentor',
  templateUrl: './mentor.component.html',
  styleUrls: ['./mentor.component.css']
})
export class MentorComponent implements OnInit {
  email: any;

  constructor(private loginService : LoginService, private mentorService: MentorService) { }
mentorId:number;
  ngOnInit() {
   
    this.mentorService._email$.subscribe(message => this.email=message);
  }

}
