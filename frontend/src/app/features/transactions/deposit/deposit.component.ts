import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AccountService } from '../../../core/services/account.service';

@Component({
  selector: 'app-deposit',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './deposit.component.html',
  styleUrls: ['./deposit.component.css']
})
export class DepositComponent {

  accountId!: string;
  amount!: number;

  successMessage = '';
  errorMessage = '';

  constructor(private accountService: AccountService) {}

  deposit() {

    this.successMessage = '';
    this.errorMessage = '';

    if (!this.accountId || !this.amount) {
      this.errorMessage = 'Please enter valid details';
      return;
    }

    const request = {
      accountId: this.accountId,
      amount: this.amount
    };

    this.accountService.deposit(request).subscribe({
      next: (response) => {
        this.successMessage = 'Deposit Successful!';
        this.accountId = "";
        this.amount = 0;
      },
      error: (err) => {
        this.errorMessage = 'Deposit Failed! Check Account ID.';
        console.error(err);
      }
    });
  }
}
