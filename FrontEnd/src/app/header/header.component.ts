import { Component, OnInit } from '@angular/core';
import { SideBarServiceService } from '../Services/side-bar-service.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent implements OnInit {
  constructor(public sidebarService: SideBarServiceService) {}

  ngOnInit(): void {}
}
