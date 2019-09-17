import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  private baseUrl = 'http://localhost:8245/api';

  

  constructor(private http: HttpClient) { }
  createUser(user: Object): Observable<Object> {
    console.log(user)
    return this.http.post(`${this.baseUrl}` + `/user/register`, user);
}

}