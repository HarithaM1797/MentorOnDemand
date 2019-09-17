import { Component } from '@angular/core';

import { LoginService } from './service/login.service';
import { MentorService } from './mentor.service';
import { Mentor } from './model/Mentor';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'mentordemandclient';

 
  mentor: Mentor = new Mentor();
  submitted = false;

  constructor(private mentorService: MentorService) { }

  ngOnInit() {
  }
  /*getMentorDetails(): void {
    this.submitted = false;
    this.mentor = new Mentor();
  }*/

  save() {
    this.mentorService.getMentorDetails(this.mentor)
      .subscribe(data => console.log(data), error => console.log(error));
    this.mentor = new Mentor();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }
}
