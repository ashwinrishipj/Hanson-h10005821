import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
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

  unamePattern = "^[a-z0-9_-]{9,15}$";
  pwdPattern = "^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).{6,12}$";

  constructor(private formBuilder: FormBuilder,private router: Router) {
    this.loginForm = this.formBuilder.group(
      {
       username: ['',Validators.pattern(this.unamePattern)],
       password: ['',Validators.pattern(this.pwdPattern)]
      }
    )
  }

  ngOnInit(): void {}
  onLoginSubmit(){
    this.router.navigate(['/home'],{skipLocationChange:true});
  }
}
