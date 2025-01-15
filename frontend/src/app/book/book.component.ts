import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ApiService } from '../api.service';
import { Book } from '../Book';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent {

  public chosenBook!: Book;

  constructor(private route: ActivatedRoute, private apiServ: ApiService ) {}

  ngOnInit(){
    this.getBookByIsbn();
  }

  getBookByIsbn(){
    this.route.paramMap.subscribe(params => {
      const isbn = params.get('isbn');
      if(isbn){
        this.apiServ.getBookByIsbn(isbn).subscribe(response => {
          if (response) {
            this.chosenBook = response;
          }
        });
      }
    });
  }
}
