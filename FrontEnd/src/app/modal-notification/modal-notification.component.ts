import { Component, OnInit } from '@angular/core';
import { faFilePdf } from '@fortawesome/free-solid-svg-icons';
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
  selector: 'app-modal-notification',
  templateUrl: './modal-notification.component.html',
  styleUrls: ['./modal-notification.component.scss'],
})
export class ModalNotificationComponent implements OnInit {
  active = 'top';
  buttonDisable = true;
  fileToUpload: File | null = null;
  faFile = faFilePdf;

  marks = Marks;

  constructor(public sidebarService: SideBarServiceService) {}

  ngOnInit(): void {
    Aos.init();
  }

  onCloseHandled() {
    this.sidebarService.triggerNotificationModal = 'none';
  }

  handleFileInput(event: any) {
    this.buttonDisable = false;
    // this.fileToUpload = files.item(0);
    if (!(event.target.value instanceof HTMLInputElement)) {
      alert('wrong target');
    }
    alert(event.target.value);
  }

  fileUploaded() {
    console.log('file:', this.fileToUpload);
  }
}
