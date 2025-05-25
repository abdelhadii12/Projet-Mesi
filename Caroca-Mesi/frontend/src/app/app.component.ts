import { Component, OnInit } from '@angular/core';
import { RouterOutlet, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, RouterModule, CommonModule],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'voiture-app';
  currentUser: any = null;
  isAdmin: boolean = false;

  ngOnInit() {
    this.checkUserStatus();
  }

  checkUserStatus() {
    const userStr = localStorage.getItem('user');
    if (userStr) {
      try {
        this.currentUser = JSON.parse(userStr);
        this.isAdmin = this.currentUser.role === 'ADMIN';
      } catch (e) {
        console.error('Error parsing user data:', e);
        this.clearUserData();
      }
    } else {
      this.clearUserData();
    }
  }

  clearUserData() {
    this.currentUser = null;
    this.isAdmin = false;
  }

  logout() {
    localStorage.removeItem('user');
    this.clearUserData();
    window.location.href = '/login';
  }
}
