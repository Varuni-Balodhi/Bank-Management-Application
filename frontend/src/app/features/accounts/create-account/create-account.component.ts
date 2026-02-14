import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AccountService } from '../../../core/services/account.service';
import { Account } from '../../../shared/models/account';
@Component({
  selector: 'app-create-account',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './create-account.component.html'
})
export class CreateAccountComponent {

  account: Account = {
  id: 0,
  name: '',
  balance: 0,
  email: '',
  phone: ''
};
  errorMessage: string = '';

  constructor(
    private accountService: AccountService,
    private router: Router
  ) {}

  onSubmit(): void {
    this.accountService.createAccount(this.account).subscribe({
      next: () => this.router.navigate(['/accounts']),
      error: err => {
        this.errorMessage = 'Error creating account';
        console.error(err);
      }
    });
  }
}
