import { Component, OnInit } from '@angular/core';
import * as Aos from 'aos';
import { SideBarServiceService } from '../Services/side-bar-service.service';

@Component({
  selector: 'app-modal-notification',
  templateUrl: './modal-notification.component.html',
  styleUrls: ['./modal-notification.component.scss'],
})
export class ModalNotificationComponent implements OnInit {
  active = 'top';
  buttonDisable = true;
  file: any;

  constructor(public sidebarService: SideBarServiceService) {}

  ngOnInit(): void {
    Aos.init();
  }

  onCloseHandled() {
    this.sidebarService.triggerNotificationModal = 'none';
  }

  fileChangeEvent(e: File) {
    this.file = e;
    this.buttonDisable = false;
  }
}
