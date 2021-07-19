import { Component, OnInit } from '@angular/core';
import * as AOS from 'aos';
import { SideBarServiceService } from 'src/app/Services/side-bar-service.service';

@Component({
  selector: 'app-notifications',
  templateUrl: './notifications.component.html',
  styleUrls: ['./notifications.component.scss']
})
export class NotificationsComponent implements OnInit {
  overdue: any[] = [];
  upcoming: any[] = [];

  constructor(public sidebarService: SideBarServiceService) {
    this.overdue = this.sidebarService.apiResponse.notifications.overDue;
    this.upcoming = this.sidebarService.apiResponse.notifications.upcoming;
  }


  ngOnInit(): void {
    AOS.init();
  }

}
