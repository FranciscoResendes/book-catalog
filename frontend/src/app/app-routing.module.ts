import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { MainComponent } from './main/main.component';
import { UserComponent } from './user/user.component';
import { AuthGuardService } from './auth-guard.service';
import { BookComponent } from './book/book.component';
import { AuthorComponent } from './author/author.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: '', component: MainComponent},
  {path: 'user', component: UserComponent, canActivate: [AuthGuardService]},
  {path: 'book/:isbn', component: BookComponent},
  {path: 'authors', component: AuthorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
