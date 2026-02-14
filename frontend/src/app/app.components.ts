import { Component } from '@angular/core';
import { RouterOutlet, Router} from '@angular/router';
import { AuthenticationService } from '../app/core/services/authentication.service';
import { NavbarComponent } from "./shared/components/navbar/navbar.component";
import { UserListComponent } from '@features/users/user-list.components';

@Component({
  standalone: true,
  selector: 'app-root',
  imports: [RouterOutlet, NavbarComponent, UserListComponent],
  templateUrl: './app.component.html'
})
export class AppComponent {

  constructor(
    private authService: AuthenticationService,
    private router: Router
  ) {}

  logout() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }
}
