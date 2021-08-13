import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { SideBarServiceService } from 'src/app/Services/side-bar-service.service';

@Component({
  selector: 'app-settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.scss'],
})
export class SettingsComponent implements OnInit {
  modalDisplay: String = 'none';
  userID: number = 0;

  updateProfile = {
    userId: this.userID,
    userName: '',
    userAddress: '',
    userCity: '',
    userState: '',
    userZipCode: ''
  };

  userData: any = null;

  headers = {
    'content-type': 'application/json',
    'Access-Control-Allow-Origin': '*',
  };

  constructor(private http: HttpClient, public sideBarServices: SideBarServiceService) {
    this.userID = this.sideBarServices.apiResponse.userId;
    this.fetchUserProfile();
  }

  ngOnInit(): void { }

  public onChangeValue(type: String, value: any) {
    switch (type) {
      case 'userId':
        this.updateProfile.userId = value;
        break;

      case 'userName':
        this.updateProfile.userName = value;
        break;

      case 'userAddress':
        this.updateProfile.userAddress = value;
        break;

      case 'userCity':
        this.updateProfile.userCity = value;
        break;

      case 'userState':
        this.updateProfile.userState = value;
        break;

      case 'userZipCode':
        this.updateProfile.userZipCode = value;
        break;
      default:
        break;
    }
  }

  profileEdit() {
    this.modalDisplay = 'block';
  }

  dismissModal() {
    this.modalDisplay = 'none';
  }

  updateUserProfile() {
    this.dismissModal();

    this.http
      .post(
        'http://localhost:8080/updateProfile',
        this.updateProfile,
        { headers: this.headers }
      )
      .subscribe(
        (data) => {
          console.log(data);
          if (data == true) {
            alert("updated successfully");
            this.fetchUserProfile();
          } else {
            alert("server error: please try again")
          }
        },
        (err) => {
          alert("server error: please try again")
        }
      );
  }

  fetchUserProfile() {
    this.http
      .post(
        'http://localhost:8080/getProfile',
        { "userId": this.userID },
        { headers: this.headers }
      )
      .subscribe(
        (data) => {
          console.log(data);
          if (data) {
            console.log(data);
            this.userData = data;
            console.log("userData:", this.userData[0]);
          } else {
            alert("server error: please try again");
          }
        },
        (err) => {
          console.log("error in fetching...", err);
        }
      );
  }
}