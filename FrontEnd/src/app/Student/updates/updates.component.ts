import { Component, OnInit } from '@angular/core';
import { SideBarServiceService } from 'src/app/Services/side-bar-service.service';

@Component({
  selector: 'app-updates',
  templateUrl: './updates.component.html',
  styleUrls: ['./updates.component.scss']
})
export class UpdatesComponent implements OnInit {

  constructor(public sidebarService : SideBarServiceService) { 
    console.log("from services:",sidebarService.apiResponse);
  }

  ngOnInit(): void {
  }

}
