import { Component, OnInit } from '@angular/core';
import * as Aos from 'aos';
import { SideBarServiceService } from '../Services/side-bar-service.service';

interface Mark {
  name: string;
  theory: number;
  practical: number;
  total: number;
}

const Marks: Mark[] = [
  {
    name: "week1",
    theory: 50,
    practical: 50,
    total: 100
  },
  {
    name: "week4",
    theory: 40,
    practical: 40,
    total: 80
  },
  {
    name: "midterm",
    theory: 50,
    practical: 50,
    total: 100
  },
  {
    name: "final",
    theory: 50,
    practical: 50,
    total: 100
  },
];

@Component({
  selector: 'app-course-modal',
  templateUrl: './course-modal.component.html',
  styleUrls: ['./course-modal.component.scss']
})
export class CourseModalComponent implements OnInit {

  active = 'top';
  buttonDisable = true;

  marks = Marks;

  constructor(public sidebarService: SideBarServiceService) { }

  ngOnInit(): void {
    Aos.init();
  }

  onCloseHandled() {
    this.sidebarService.triggerCourseModal = 'none';
  }

}
