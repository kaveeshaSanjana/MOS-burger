import { Component } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import { HeaderComponent } from './common/header/header.component';
import { NgIf } from '@angular/common';
import { DashboardComponent } from "./pages/dashboard/dashboard.component";
import { LoginComponent } from "./pages/dashboard/login-routs/login/login.component";

@Component({
  selector: 'app-root',
  imports: [HeaderComponent, RouterOutlet, NgIf, DashboardComponent, LoginComponent ,LoginComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'MOS';

}
