import { Component } from '@angular/core';
import { ApiService } from '../api.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  invalidLogin: boolean = false;

  constructor(private apiService: ApiService) { }

  signIn(form: NgForm) {
    const credentials = {
      username: form.value.username,
      password: form.value.password
    };
    this.apiService.login(credentials).subscribe(response => {
      if (response) {
        console.log(response);
      } else {
        this.invalidLogin = true;
      }
    }, error => {
      this.invalidLogin = true;
      console.error('Login error:', error);
    });
  }
}
