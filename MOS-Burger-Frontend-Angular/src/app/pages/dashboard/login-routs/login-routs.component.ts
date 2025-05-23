import { Component } from '@angular/core';
import { Route, Router, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-login-routs',
  imports: [RouterOutlet],
  templateUrl: './login-routs.component.html',
  styleUrl: './login-routs.component.css'
})
export class LoginRoutsComponent {
constructor(private routers:Router){}
}
