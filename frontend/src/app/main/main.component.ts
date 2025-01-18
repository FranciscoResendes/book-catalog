import { Component } from '@angular/core';
import { Book } from '../Book';
import { ApiService } from '../api.service';
import { lastValueFrom } from 'rxjs';
import { NgForm } from '@angular/forms';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent {
  public books: Book[] = [];

  public selectedBook?: Book = undefined;
  public showPopup: boolean = false;

  constructor(private apiServ: ApiService, public authService: AuthService, private router: Router){}

  ngOnInit(){
    this.getBooks();
  }

  public async getBooks(){
    try{
      this.books = await lastValueFrom(this.apiServ.getAllBooks());
    }catch(e){
      console.log(e);
    }
  }

  openAddPopup(book: Book){
    this.selectedBook = book;
    this.showPopup = true;
  }

  submitAddBook(frm: NgForm){

    const book = {
      isbn: this.selectedBook?.isbn ?? '',
      title: frm.value.title,
      author: this.selectedBook?.author ?? '',
      genre: this.selectedBook?.genre ?? '',
      status: frm.value.status,
      chaptersRead: frm.value.chaptersRead,
      pages: this.selectedBook?.pages ?? 0,
      score: this.selectedBook?.score ?? 0,
      synopsis: this.selectedBook?.synopsis ?? '',
      cover: this.selectedBook?.cover ?? ''
    };

    const jwt = this.authService.isLoggedIn();
    if (jwt) {
      this.apiServ.addBook(jwt, book).subscribe(response => {
        if (response) {
          console.log(response);
        }
      });
    }
    else{
      console.log("You are not logged in");
    } 

    this.showPopup = false;
    this.selectedBook = undefined;
  }

  closePopup(){
    this.showPopup = false;
    this.selectedBook = undefined;
  }

  goToBook(book: Book){
    this.router.navigate(['/book', book.isbn]);
  }
}
