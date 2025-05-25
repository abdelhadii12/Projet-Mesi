import { Component } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { Router, RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-signup',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  email = '';
  password = '';
  firstName = '';
  lastName = '';
  phoneNumber = '';
  address = '';
  message: string | null = null;

  constructor(private auth: AuthService, private router: Router) {}

  onSignup() {
    const userData = {
      email: this.email,
      password: this.password,
      firstName: this.firstName,
      lastName: this.lastName,
      phoneNumber: this.phoneNumber,
      address: this.address
    };

    this.auth.signup(userData).subscribe({
      next: () => {
        // After successful signup, automatically log in
        this.auth.login({ email: this.email, password: this.password }).subscribe({
          next: (user: any) => {
            localStorage.setItem('user', JSON.stringify(user));
            this.router.navigate(['/']);
          },
          error: () => {
            this.message = 'Signup successful but login failed. Please try logging in manually.';
            this.router.navigate(['/login']);
          }
        });
      },
      error: () => {
        this.message = 'Email already exists';
      }
    });
  }
}
