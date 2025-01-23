import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  invalidLogin: boolean = false;

  constructor(private authService: AuthService, private router: Router) { }

  signIn(form: NgForm) {
    const credentials = {
      username: form.value.username,
      password: form.value.password
    };
    this.authService.login(credentials).subscribe(response => {
      if (!response) {
        this.invalidLogin = true;
      }
      else this.router.navigate(['/user']);
    });
  }

  goBack(){
    this.router.navigate(['/']);
  }
}
