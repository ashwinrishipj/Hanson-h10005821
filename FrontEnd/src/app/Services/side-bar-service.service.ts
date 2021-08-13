import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class SideBarServiceService {
  public feedStatus: string = 'updates';
  public apiResponse: any;
  public triggerNotificationModal: string = 'none';

  public modalContent: any = {
    notificationId: null,
    notificationType: 'null',
    notificationContent: 'null',
    notificationSubject: 'null',
    notificationDate: 'null',
    tutorId: null,
    tutorName: 'null',
  };

  public courseModal: any = {
    courseId: null,
    courseName: null,
    courseCredits: null,
    courseTutorId: null,
    courseTutorName: null,
    courseTutorEmail: null
  };

  public triggerCourseModal: string = 'none';
  constructor() { }
}
