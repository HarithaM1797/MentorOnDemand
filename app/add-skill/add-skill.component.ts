import { Component, OnInit } from '@angular/core';
import { MentorSkills } from '../model/Mentor';
import { MentorService } from '../mentor.service';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-add-skill',
  templateUrl: './add-skill.component.html',
  styleUrls: ['./add-skill.component.css']
})
export class AddSkillComponent implements OnInit {

mentorSkills: MentorSkills = new MentorSkills();
  submitted = false;
  mentorId:Observable<any>;
email:string;
skillName:string;
mentorSkill:MentorSkills[];
  constructor(private mentorService: MentorService) { }

  ngOnInit() {
    this.mentorService._email$.subscribe(message => this.email=message);
     this.mentorService.getMentorId(this.email)
     .subscribe(data => this.mentorId=data);
   
     console.log(this.mentorId)
     this.getMentorSkills();
  

  }

  getMentorSkills()
  {
    console.log(this.mentorId)
    this.mentorService.getMentorSkills(this.mentorId)
    .subscribe((res:any[])=>{
      console.log('oooooooo',res[0].skillName)
      this.skillName=res[0].skillName;
    })
  }
  newAdmin(): void {
    this.submitted = false;
    this.mentorSkills = new MentorSkills();
  }

  save() {
    this.mentorSkills.mentorId=this.mentorId;
    this.mentorService.addMentorSkills(this.mentorSkills)
      .subscribe(data => console.log(data), error => console.log(error));
    this.mentorSkills = new MentorSkills();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }


}
