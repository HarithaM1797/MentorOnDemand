import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Login } from '../model/login';
import { Observable, BehaviorSubject } from 'rxjs';
@Injectable({
  providedIn: 'root'
})


export class LoginService {
  
  private baseUrl = 'http://localhost:8254/api';

  private _mentorId=new BehaviorSubject<number>(this._mentorId);
  _mentorId$=this._mentorId.asObservable();

   constructor(private http: HttpClient) { }
   //Send data from login form in Home page to rest Controller
  
  
  sendLoginData(login: Login): Observable<Object> {
    return this.http.post(`${this.baseUrl}` + `/login`, login);
  }
  getCredentials(login:Object): Observable<any> {
    
    return this.http.post<any>(`${this.baseUrl}`+'/getRole/login',login);
  }
 setMentorId(mentorId:number)
 {
   this._mentorId.next(mentorId);
 }
  
}
