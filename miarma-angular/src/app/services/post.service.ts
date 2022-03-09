import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { PostResponse } from '../models/interfaces/post.interface';


const postUrl = `${environment.apiBaseUrl}/post/all`
const DEFAULT_HEADERS = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Authorization': `Bearer ${localStorage.getItem('BEARER_TOKEN')}`,
  }),
};


@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private http: HttpClient) { }

  getPost():Observable<PostResponse[]>{
    let requestUrl = `${postUrl}`;

    return this.http.get<PostResponse[]>(`${requestUrl}`,DEFAULT_HEADERS);
  }
}
