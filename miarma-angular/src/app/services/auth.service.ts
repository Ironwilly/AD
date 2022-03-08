import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { LoginComponent } from '../login/login/login.component';
import { AuthLoginDto } from '../models/dto/auth.dto';
import { LoginResponse } from '../models/interfaces/auth.interface';



const AUTH_BASE_URL = 'auth';
const DEFAULT_HEADERS = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {
 

  authBaseUrl = `${environment.apiBaseUrl}/${AUTH_BASE_URL}`;

  constructor(private http: HttpClient) { }

  login(loginDto: AuthLoginDto): Observable<LoginResponse> {
    let requestUrl = `${this.authBaseUrl}/login`;
    return this.http.post<LoginResponse>(requestUrl, loginDto, DEFAULT_HEADERS);
  }


}
