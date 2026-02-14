import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { AuthenticationService } from '../../../core/services/authentication.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  username = '';
  password = '';
  errorMessage = '';
  loading = false;

  constructor(
    private authService: AuthenticationService,
    private router: Router
  ) {}

  login() {
    this.loading = true;
    this.errorMessage = '';

    this.authService.login(this.username, this.password)
  .subscribe({
    next: () => {

      const role = this.authService.getUserRole();

      if (role === 'ROLE_MANAGER') {
        this.router.navigate(['/manager-dashboard']);
      } else if (role === 'ROLE_CLERK') {
        this.router.navigate(['/clerk-dashboard']);
      }
    },
    error: () => {
      this.errorMessage = 'Invalid credentials';
    }
  });
  }
}
