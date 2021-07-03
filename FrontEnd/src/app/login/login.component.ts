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

  errorDismiss() {
    this.iserror = false;
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
          if (data !== 1 || 0) {
            this.sidebar.apiResponse = data;
            console.log('services:', this.sidebar.apiResponse);
            this.router.navigate(['/home'], { skipLocationChange: true });
          } else if (data == 0) {
            this.iserror = true;
            this.apiError = 'user not found. please register';
          } else if (data == 1) {
            this.iserror = true;
            this.apiError = 'incorrect password';
          } else {
            this.iserror = true;
            this.apiError = 'server error!. Please try again later.';
          }
        },
        (err) => {
          console.log('error value:', err);
          this.iserror = true;
          this.apiError = 'server error!. Please try again later.';
        }
      );
  }
}
