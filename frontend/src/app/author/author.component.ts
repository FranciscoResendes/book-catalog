import { Component } from '@angular/core';
import { ApiService } from '../api.service';
import { Author } from '../Author';

@Component({
  selector: 'app-author',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.css']
})
export class AuthorComponent {

  public authors!: Author[];

  constructor(private apiServ: ApiService) {}

  ngOnInit() {
    this.apiServ.getAllAuthors().subscribe((data) => {
      this.authors = data;
    });
  }

}
