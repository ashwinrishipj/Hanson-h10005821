import { Component, OnInit } from '@angular/core';
import { SideBarServiceService } from 'src/app/Services/side-bar-service.service';
import * as AOS from 'aos';

@Component({
  selector: 'app-updates',
  templateUrl: './updates.component.html',
  styleUrls: ['./updates.component.scss'],
})
export class UpdatesComponent implements OnInit {
  updates: any[] = [];

  constructor(public sidebarService: SideBarServiceService) {
    this.updates = this.sidebarService.apiResponse;
  }

  ngOnInit(): void {
    AOS.init();
  }
}
