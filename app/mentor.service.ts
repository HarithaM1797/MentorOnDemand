import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MentorService {

  private baseUrl = 'http://localhost:8254/api';
private _email=new BehaviorSubject<String>(this._email);
_email$=this._email.asObservable();
  

   constructor(private http: HttpClient) { }

  createMentor(mentor: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}` + `/mentor/register`, mentor);
  }
 

  addMentorSkills(mentorSkills: Object): Observable<Object> {
    console.log(mentorSkills)
    return this.http.put(`${this.baseUrl}` + `/mentor/update`, mentorSkills);
}
  getMentorDetails(mentor:Object): Observable<any> {
    console.log(mentor)
    return this.http.post<any>(`${this.baseUrl}`+'/user/searchSkill/{mentor.skills}',mentor);
  }
  getMentorSkills(mentorId:any): Observable<Object> {
    console.log(mentorId)
  return this.http.post<any>(`${this.baseUrl}` + `/mentor/getMentorSkills/${mentorId}`, mentorId);
}
  getMentorId(email:string): Observable<any> {
    console.log(email)
  return this.http.post(`${this.baseUrl}` + `/mentor/getMentorId/${email}`, email);
}
 
  setEmail(email:string)
  {
    this._email.next(email);
  }
}
