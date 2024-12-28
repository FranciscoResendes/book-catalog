import { Injectable } from '@angular/core';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private apiService: ApiService) { }

  login(credentials: any): boolean {

    let isValid = false;
    this.apiService.login(credentials).subscribe(response => {
      if (response.status === 200) {
        console.log(response.result.token);
        localStorage.setItem('token', response.result.token);
        isValid = true;
      }
      return isValid;
    });
    return isValid;
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
