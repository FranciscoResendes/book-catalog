import { Component } from '@angular/core';
import { User } from '../User';
import { ApiService } from '../api.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {
  public currentUser?: User = undefined;
  
  constructor(private apiServ: ApiService, private authServ: AuthService) {}

  ngOnInit() {
    const token = this.authServ.isLoggedIn();
    if(token){
      this.apiServ.getUserInfo(token).subscribe(response => {
        if(response) this.currentUser = response

        else this.authServ.logout();
      });
    }
    }

}
