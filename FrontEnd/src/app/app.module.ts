import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HomeComponent } from './Student/home/home.component';
import { SidebarComponent } from './Student/sidebar/sidebar.component';
import { NotificationsComponent } from './Student/notifications/notifications.component';
import { SideBarServiceService } from './Services/side-bar-service.service';
import { UpdatesComponent } from './Student/updates/updates.component';
import { CoursesComponent } from './Student/courses/courses.component';
import { SettingsComponent } from './Student/settings/settings.component';
import { CommonModule, NgClass } from '@angular/common';
import { HeaderComponent } from './header/header.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    SidebarComponent,
    NotificationsComponent,
    UpdatesComponent,
    CoursesComponent,
    SettingsComponent,
    HeaderComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CommonModule,
    FontAwesomeModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [SideBarServiceService],
  bootstrap: [AppComponent],
})
export class AppModule {}
