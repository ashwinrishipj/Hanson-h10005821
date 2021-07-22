import { Component, OnInit } from '@angular/core';
import { SideBarServiceService } from 'src/app/Services/side-bar-service.service';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.scss'],
})
export class CoursesComponent implements OnInit {
  constructor(public sideBarService: SideBarServiceService) {}

  ngOnInit(): void {}
}
