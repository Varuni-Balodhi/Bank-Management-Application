import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AccountService } from '../../../core/services/account.service';
import { TransferRequest } from '../../../shared/models/transfer-request';

@Component({
  selector: 'app-transfer',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './transfer.component.html',
  styleUrls: ['./transfer.component.css']
})
export class TransferComponent {

  fromAccountId: number = 0;
  toAccountId: number = 0;
  amount: number = 0;
  errorMessage: string = '';

  constructor(
    private accountService: AccountService,
    private router: Router
  ) {}

  onSubmit(): void {

    const request: TransferRequest = {
      fromAccountId: this.fromAccountId,
      toAccountId: this.toAccountId,
      amount: this.amount
    };

    this.accountService.transfer(request).subscribe({
      next: () => this.router.navigate(['/accounts']),
      error: err => {
        this.errorMessage = 'Transfer failed';
        console.error(err);
      }
    });
  }
}
