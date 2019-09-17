import { Component, OnInit } from '@angular/core';
import { Login } from '../model/login';
import { LoginService } from '../service/login.service';
import { Router } from '@angular/router';
import { MentorService } from '../mentor.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
private mentorId:number;
private email:string;
   private loginList: Login[];
  login: Login = new Login();
  constructor(private router: Router, private loginService: LoginService ,private mentorService: MentorService) { }

  ngOnInit() {
    //this.loginService.getCredentials(this.login1).subscribe(response => this.login1= response, error => alert(`${error.message}\nWaiting for response from server`));
  
  }

  checkLogin() {

            this.loginService.getCredentials(this.login)
            .subscribe((res:any[])=>{
            //console.log(res)
            this.loginList=res;
            })
              

            if(this.loginList[0].role==="admin")
            {
            this.router.navigate(['Admin']);
            }


            if(this.loginList[0].role==="mentor")
            {
              this.email=this.loginList[0].email;
              this.mentorService.setEmail(this.email);
            this.router.navigate(['Mentor']);
            }
           

            if(this.loginList[0].role==="user")
            {
            this.router.navigate(['User']);
            }
            this.mentorService.getMentorId(this.email);
            //console.log(this.email,this.mentorId)
            this.loginService.setMentorId(this.mentorId);
     }

  
 
  onSubmit() {

    
    this.checkLogin();
    
  }
}

