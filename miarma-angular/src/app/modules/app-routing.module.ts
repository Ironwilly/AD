import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from '../login/login/login.component';
import { PostListComponent } from '../post/post-list/post-list.component';

const routes: Routes = [

  {path: 'login', component: LoginComponent},
  {path: 'postList', component: PostListComponent},
  {path: '',pathMatch: 'full',redirectTo: '/login'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
