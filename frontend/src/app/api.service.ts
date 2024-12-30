import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Book } from './Book';
import { User } from './User';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private api = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  public getAllBooks(): Observable<Book[]> {
    return this.http.get<Book[]>(`${this.api}/books`);
  }

  public login(credentials: { username: string, password: string }): Observable<any> {
    return this.http.post<any>(`${this.api}/user`, credentials);
  }

  public getUserInfo(jwt: string): Observable<User> {
    const headers = new HttpHeaders().set('Authorization', jwt);
    return this.http.get<User>(`${this.api}/user`, { headers });
  }

  public logout(jwt: string): Observable<any> {
    const headers = new HttpHeaders().set('Authorization', jwt);
    return this.http.delete<any>(`${this.api}/logout`, { headers });
  }

  public addBook(jwt: string, book: Book): Observable<any> {
    const headers = new HttpHeaders().set('Authorization', jwt);
    return this.http.post<any>(`${this.api}/books`, book, { headers });
  }
}
