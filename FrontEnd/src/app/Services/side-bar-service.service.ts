import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SideBarServiceService {
  public feedStatus : String ="home";
  constructor() { }
}
