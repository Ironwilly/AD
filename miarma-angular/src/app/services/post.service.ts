import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { PostResponse } from '../models/interfaces/post.interface';


const postUrl = `${environment.apiBaseUrl}/post/public`


@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private http: HttpClient) { }

  getPost():Observable<PostResponse>{
    return this.http.get<PostResponse>(`${postUrl}`);
  }
}
