import { Component, OnInit } from '@angular/core';
import { SideBarServiceService } from 'src/app/Services/side-bar-service.service';
import * as AOS from 'aos';

@Component({
  selector: 'app-updates',
  templateUrl: './updates.component.html',
  styleUrls: ['./updates.component.scss'],
})
export class UpdatesComponent implements OnInit {
  update: any[] = [];

  constructor(public sidebarService: SideBarServiceService) {
    this.update = this.sidebarService.apiResponse.updates;
  }

  ngOnInit(): void {
    AOS.init();
  }

  
}
