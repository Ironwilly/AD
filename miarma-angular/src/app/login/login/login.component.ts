import { Input } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { AuthLoginDto } from 'src/app/models/dto/auth.dto';
import { PostResponse } from 'src/app/models/interfaces/post.interface';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginDto = new AuthLoginDto();

  email?: string ;
  password?: string ;
  token?: string  ;

  constructor(private authService: AuthService, private router: Router,) { }


  ngOnInit(): void {
  }

  login(){

    this.authService.login(this.loginDto).subscribe(loginResult => {
      localStorage.setItem('BEARER_TOKEN', loginResult.token)
      console.log(localStorage.getItem('BEARER_TOKEN'));
      this.router.navigate(['/postList']);


  });

  }
}
