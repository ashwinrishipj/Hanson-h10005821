import { Component, OnInit } from '@angular/core';
import { faHome, faPodcast } from '@fortawesome/free-solid-svg-icons';
import * as AOS from 'aos';
import { SideBarServiceService } from 'src/app/Services/side-bar-service.service';

@Component({
  selector: 'app-notifications',
  templateUrl: './notifications.component.html',
  styleUrls: ['./notifications.component.scss'],
})
export class NotificationsComponent implements OnInit {
  overdue: any[] = [];
  upcoming: any[] = [];
  faHome = faHome;
  faPod = faPodcast;

  constructor(public sidebarService: SideBarServiceService) {
    this.overdue = this.sidebarService.apiResponse.notifications.overDue;
    this.upcoming = this.sidebarService.apiResponse.notifications.upcoming;
  }

  ngOnInit(): void {
    AOS.init();
  }

  triggerModal(data: any) {
    this.sidebarService.triggerNotificationModal = 'block';
    this.sidebarService.modalContent = data;
    console.log("sidebar",this.sidebarService.modalContent)
  }
}
