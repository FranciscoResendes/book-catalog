import { Injectable } from '@angular/core';
import { ApiService } from './api.service';
import { catchError, map, Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  
  constructor(private apiService: ApiService) { }

  login(credentials: any): Observable<boolean> {
    return this.apiService.login(credentials).pipe(
      map(response => {
        if (response.token) {
          console.log(response.token);
          localStorage.setItem('token', response.token);
          return true;
        } 
        else  return false;
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
        if (response.status === 200) {
          localStorage.removeItem('token');
        }
      });
    }
  }
}
