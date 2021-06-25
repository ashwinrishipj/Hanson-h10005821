import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import {
  faExclamationTriangle,
  faUser,
} from '@fortawesome/free-solid-svg-icons';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import * as AOS from 'aos';
import { SideBarServiceService } from '../Services/side-bar-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {
  faUser = faUser;
  faError = faExclamationTriangle;
  loginForm: FormGroup;
  iserror: boolean = false;
  apiError: String = '';

  usernamePattern = '^[a-z0-9_-]{9,15}$';
  passwordPattern =
    '(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&])[A-Za-zd$@$!%*?&].{6,}';

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private http: HttpClient,
    public sidebar: SideBarServiceService
  ) {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.pattern(this.usernamePattern)],
      password: ['', Validators.pattern(this.passwordPattern)],
    });
  }

  ngOnInit(): void {
    AOS.init();
  }

  onLoginSubmit() {
    const headers = {
      'content-type': 'application/json',
      'Access-Control-Allow-Origin': '*',
    };

    this.http
      .post(
        'http://localhost:8080/validate',
        {
          emailId: this.loginForm.value.username,
          password: this.loginForm.value.password,
        },
        { headers: headers }
      )
      .subscribe(
        (data) => {
          console.log(data);
          this.router.navigate(['/home'], { skipLocationChange: true });
        },
        (err) => {
          console.log('error value:', err);

          if (
            err.error.text === 'incorrect password' ||
            err.error.text === 'user not found. Please register'
          ) {
            this.iserror = true;
            this.apiError = err.error.text;
          } else {
            this.sidebar.apiResponse = err.error.text;
            this.router.navigate(['/home'], { skipLocationChange: true });
          }
        }
      );
  }
}
