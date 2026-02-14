import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../../../core/services/authentication.service';

@Component({
  selector: 'app-navbar',
  standalone: true,
  template: `
  <nav class="navbar navbar-dark bg-dark px-4">
    <span class="navbar-brand">🏦 Bank Management</span>
    <button class="btn btn-outline-light" (click)="logout()">Logout</button>
  </nav>
  `
})
export class NavbarComponent {

  constructor(private authService: AuthenticationService,
              private router: Router) {}

  logout() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }
}
