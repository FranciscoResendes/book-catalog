import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Book } from './Book';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private api = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  public getAllBooks(): Observable<Book> {
    return this.http.get<Book>(`${this.api}/books`);
  }

  public login(credentials: any) {
    return this.http.post(`${this.api}/user`, credentials);
  }
}
