import { Component, OnInit } from '@angular/core';
import { LoginService } from '../service/login.service';

import { MentorService } from '../mentor.service';
import { Mentor } from '../model/Mentor';

@Component({
  selector: 'app-mentor-registration',
  templateUrl: './mentor-registration.component.html',
  styleUrls: ['./mentor-registration.component.css']
})
export class MentorRegistrationComponent implements OnInit {

  mentor: Mentor = new Mentor();
  submitted = false;

  constructor(private mentorService: MentorService) { }

  ngOnInit() {
  }
  newMentor(): void {
    this.submitted = false;
    this.mentor = new Mentor();
  }

  save() {
    this.mentorService.createMentor(this.mentor)
      .subscribe(data => console.log(data), error => console.log(error));
    this.mentor = new Mentor();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }
}
