import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  public username: string = "";
  public password: string = "";

  constructor(private http: HttpClient, private router: Router) { }

  cheackUser(username: string, password: string) {
    if (username != "" && password != "") {
      console.log(password);
      
      localStorage.clear();
      this.http.get<string>(`/login/check/${username}/${password}`,{responseType:"text" as 'json'}).subscribe(
        (response: string) => {
          console.log("Response: " + response);
      
          // Safely store the token in local storage
          localStorage.setItem("token", response);
      
          // Navigate to the dashboard
          this.router.navigate(['/dashboard']);
        },
        (error) => {
          console.error("Error occurred:", error);
        }
      );    }
  }
}
