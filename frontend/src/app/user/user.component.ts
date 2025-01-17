import { Component } from '@angular/core';
import { User } from '../User';
import { ApiService } from '../api.service';
import { AuthService } from '../auth.service';
import { Book } from '../Book';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {
  public currentUser?: User = undefined;
  public read: number = 0;
  public reading: number = 0;
  public toRead: number = 0;
  public paused: number = 0;
  public dropped: number = 0;
  //public reread: number = 0;
  
  constructor(private apiServ: ApiService, private authServ: AuthService) {}

  ngOnInit() {
    const token = this.authServ.isLoggedIn();
    if(token){
      this.apiServ.getUserInfo(token).subscribe(response => {
        if(response) {
          this.currentUser = response;
          this.calculateStats();
        } else {
          this.authServ.logout();
        }
      });
    }
  }

  calculateStats() {
    this.currentUser?.books.forEach(book => {
      switch(book.status){
        case 'read':
          this.read++;
          break;
        case 'reading':
          this.reading++;
          break;
        case 'to-read':
          this.toRead++;
          break;
        case 'paused':
          this.paused++;
          break;
        case 'dropped':
          this.dropped++;
          break;
      }
    });
  }
}