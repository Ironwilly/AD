import { Component, OnInit } from '@angular/core';
import { AuthLoginDto } from 'src/app/models/dto/auth.dto';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  email: string | undefined;
  password: string | undefined;

  constructor(private authService: AuthService) { }
  loginDto = new AuthLoginDto();

  ngOnInit(): void {
  }

  login(){
    this.authService.login(this.loginDto).subscribe(loginResult => {
      alert(`Te has logueado y tu token es ${loginResult.token}`)
    
  });

  }
}
