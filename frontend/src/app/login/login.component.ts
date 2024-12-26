import { Component } from '@angular/core';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  invalidLogin: boolean = false;

  constructor(private apiService: ApiService) { }

  signIn(credentials: any){
    this.apiService.login(credentials).subscribe(response => {
      if(response){
        console.log(response);
      }
      else
        this.invalidLogin = true;
    });
  }


}
