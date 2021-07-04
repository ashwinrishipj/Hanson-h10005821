import { Component, OnInit } from '@angular/core';
import { SideBarServiceService } from 'src/app/Services/side-bar-service.service';
import * as AOS from 'aos';
import { faSearch } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {
  faSearch = faSearch;

  constructor(public sidebarService: SideBarServiceService) {}

  ngOnInit(): void {
    AOS.init();
  }
}
