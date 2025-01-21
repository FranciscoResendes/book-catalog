import { Injectable } from '@angular/core';
import { ApiService } from './api.service';
import {  map, Observable} from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  
  constructor(private apiService: ApiService, private router: Router) { }

  login(credentials: any): Observable<boolean> {
    return this.apiService.login(credentials).pipe(
      map(response => {
        if (response.token) {
          localStorage.setItem('token', response.token);
          return true;
        } 
        else return false;
      })
    );
  }

  isLoggedIn(){
    return localStorage.getItem('token');
  }

  logout(){
    const token = localStorage.getItem('token');
    if (token) {
      this.apiService.logout(token).subscribe(response => {
          localStorage.removeItem('token'); //when server is completed, check if status is 200
          this.router.navigate(['/']);
      });
    }
  }

  register(credentials: any): Observable<boolean> {
    return this.apiService.createUser(credentials).pipe(
      map(response => {
        console.log(response);
        return response.status === 200;
      })
    );
  }
}
