import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private baseUrl = 'http://localhost:8245/api';

  

  constructor(private http: HttpClient) { }
  createAdmin(admin: Object): Observable<Object> {
    console.log(admin)
    return this.http.post(`${this.baseUrl}` + `/adminDetails`, admin);
  }
}
