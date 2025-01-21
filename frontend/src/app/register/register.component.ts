import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  constructor(private authService: AuthService, private router: Router){}

  register(form: NgForm){
    const user = {
      username: form.value.username,
      email: form.value.email,
      password: form.value.password,
      role: 'ROLE_USER',
      books: [],
      date: new Date()
    };
    this.authService.register(user).subscribe(isValid => {
      if (!isValid) {
        console.log('Error');
      }
      else this.router.navigate(['/login']);
    });
  }
  
    goBack(){
      this.router.navigate(['/']);
    }
}
