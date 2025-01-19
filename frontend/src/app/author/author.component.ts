import { Component } from '@angular/core';
import { ApiService } from '../api.service';
import { Author } from '../Author';
import { Router } from '@angular/router';

@Component({
  selector: 'app-author',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.css']
})
export class AuthorComponent {

  public authors!: Author[];

  constructor(private apiServ: ApiService, private router: Router) {}

  ngOnInit() {
    this.apiServ.getAllAuthors().subscribe((data) => {
      this.authors = data;
    });
  }

  goToAuthor(name: string) {
    this.router.navigate(['/author', name]);
  }

}
