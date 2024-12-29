import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate{

  constructor(private router: Router, private authServ: AuthService) {}

  canActivate(): boolean {
    const token = this.authServ.isLoggedIn();
    if (!token) {
      this.router.navigate(['/login']);
      return false;
    }
    return true;
  }
}
