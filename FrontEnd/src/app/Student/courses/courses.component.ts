import { Component, OnInit } from '@angular/core';
import { SideBarServiceService } from 'src/app/Services/side-bar-service.service';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.scss'],
})
export class CoursesComponent implements OnInit {
  overdue: any[] = [];
  courseUpcoming: any[] = [];

  constructor(public sideBarService: SideBarServiceService) {
    this.overdue = this.sideBarService.apiResponse.notifications.overDue;
    this.courseUpcoming = this.sideBarService.apiResponse.notifications.upcoming;
  }

  ngOnInit(): void { }

  triggerModal(data: any) {
    this.sideBarService.triggerCourseModal = 'block';
    this.sideBarService.courseModal = this.sideBarService.apiResponse.courses[data];
  }
}
