import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  NgForm,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { faUser } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {
  faUser = faUser;
  loginForm: FormGroup;

  usernamePattern = '^[a-z0-9_-]{9,15}$';
  passwordPattern =
    '(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&])[A-Za-zd$@$!%*?&].{6,}';

  constructor(private formBuilder: FormBuilder, private router: Router) {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.pattern(this.usernamePattern)],
      password: ['', Validators.pattern(this.passwordPattern)],
    });
  }

  ngOnInit(): void {}
  onLoginSubmit() {
    this.router.navigate(['/home'], { skipLocationChange: true });
  }
}
