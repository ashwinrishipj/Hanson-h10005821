import { Component, OnInit } from '@angular/core';
import { faFolder } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-course-material',
  templateUrl: './course-material.component.html',
  styleUrls: ['./course-material.component.scss'],
})
export class CourseMaterialComponent implements OnInit {
  faFolder = faFolder;

  constructor() {}

  ngOnInit(): void {}
}
