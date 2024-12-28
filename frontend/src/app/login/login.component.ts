import { Component } from '@angular/core';
import { ApiService } from '../api.service';
import { NgForm } from '@angular/forms';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  invalidLogin: boolean = false;

  constructor(private authService: AuthService) { }

  signIn(form: NgForm) {
    const credentials = {
      username: form.value.username,
      password: form.value.password
    };
    if(!this.authService.login(credentials)){
      this.invalidLogin = true;
    }
  }
}
