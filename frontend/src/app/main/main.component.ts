import { Component } from '@angular/core';
import { Book } from '../Book';
import { ApiService } from '../api.service';
import { lastValueFrom } from 'rxjs';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent {
  public books: Book[] = [];

  public selectedBook?: Book = undefined;
  public showPopup: boolean = false;

  constructor(private apiServ: ApiService){}

  ngOnInit(){
    this.getBooks();
  }

  public async getBooks(){
    try{
      this.books = await lastValueFrom(this.apiServ.getAllBooks());
      console.log(this.books);
    }catch(e){
      console.log(e);
    }
  }

  openAddPopup(book: Book){
    this.selectedBook = book;
    this.showPopup = true;
  }

  submitAddBook(){

  }

  closePopup(){
    this.showPopup = false;
    this.selectedBook = undefined;
  }
}
