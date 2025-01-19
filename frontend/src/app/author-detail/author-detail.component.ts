import { Component } from '@angular/core';
import { ApiService } from '../api.service';
import { Author } from '../Author';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-author-detail',
  templateUrl: './author-detail.component.html',
  styleUrls: ['./author-detail.component.css']
})
export class AuthorDetailComponent {
  public chosenAuthor!: Author;

  constructor(private apiServ: ApiService, private route: ActivatedRoute){}

  ngOnInit(){
    const authorName = this.route.snapshot.paramMap.get('name');
    if (authorName) {
      this.apiServ.getAuthorByName(authorName).subscribe((data: Author) => {
        this.chosenAuthor = data;
      });
    } 
  }
}
