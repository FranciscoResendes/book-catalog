import { Component } from '@angular/core';
import { AuthService } from './auth.service';
import { ApiService } from './api.service';
import { Book } from './Book';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'book-catalog';
  searchText: string = '';
  searchResults: Book[] = [];

  constructor(public authService: AuthService, private apiService: ApiService, private router: Router){}

  isLoginPage(){
    return window.location.pathname === '/login';
  }

  search(){
    if(this.searchText.length > 0){
      this.apiService.searchBooks(this.searchText).subscribe(
        (data: Book[]) => {
          this.searchResults = data;
          this.searchText = '';
          this.router.navigate(['/search']);
        });
    }
  }
}
