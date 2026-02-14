import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AccountService } from '../../../core/services/account.service';

@Component({
  selector: 'app-withdraw',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './withdraw.component.html',
  styleUrls: ['./withdraw.component.css']
})
export class WithdrawComponent {

  accountId!: string;
  amount!: number;

  successMessage = '';
  errorMessage = '';
  loading = false;

  constructor(private accountService: AccountService) {}

  withdraw() {

    this.successMessage = '';
    this.errorMessage = '';

    if (!this.accountId || !this.amount || this.amount <= 0) {
      this.errorMessage = 'Please enter valid account ID and amount';
      return;
    }

    this.loading = true;

    const request = {
      accountId: this.accountId,
      amount: this.amount
    };

    this.accountService.withdraw(request).subscribe({
      next: () => {
        this.successMessage = 'Withdrawal Successful!';
        this.accountId = "";
        this.amount = 0;
        this.loading = false;
      },
      error: (err) => {
        this.errorMessage = 'Withdrawal Failed! Insufficient balance or invalid ID.';
        this.loading = false;
        console.error(err);
      }
    });
  }
}
