import { Component, OnInit } from '@angular/core';
import { faUser } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  faUser = faUser;

  constructor() { }

  ngOnInit(): void {
  }

  public onInputOtp(event:any){
   
  }
  public submitOtp(event : any){
    event.preventDefault();
    // alert(this.digitOne);
  }

}
