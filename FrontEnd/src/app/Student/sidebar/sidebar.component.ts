import { Component, OnInit } from '@angular/core';
import { faBell, faBook, faCog, faHome, faSignOutAlt } from '@fortawesome/free-solid-svg-icons';
import { SideBarServiceService } from 'src/app/Services/side-bar-service.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss'],
})
export class SidebarComponent implements OnInit {

  faHome = faHome;
  faBook = faBook;
  faBell = faBell;
  faSettings = faCog;
  faSignOut = faSignOutAlt;
  
  constructor(public sidebar : SideBarServiceService ) { }

  ngOnInit(): void {
  }

  updateMainView(type: string){
    this.sidebar.feedStatus = type;
  }
}
