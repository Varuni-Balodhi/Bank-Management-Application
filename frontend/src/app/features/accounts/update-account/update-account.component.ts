import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AccountService } from '../../../core/services/account.service';
import { Account } from '../../../shared/models/account';

@Component({
  selector: 'app-update-account',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './update-account.component.html'
})
export class UpdateAccountComponent implements OnInit {

  id: number = 0;
  account: Account = {
  id: 0,
  name: '',
  balance: 0,
  email: '',
  phone: ''
};
  errorMessage: string = '';

  constructor(
    private route: ActivatedRoute,
    private accountService: AccountService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.id = Number(this.route.snapshot.paramMap.get('id'));

    this.accountService.getAccountById(this.id).subscribe({
      next: data => this.account = data,
      error: err => {
        this.errorMessage = 'Account not found';
        console.error(err);
      }
    });
  }

  onSubmit(): void {
    this.accountService.updateAccount(this.id, this.account).subscribe({
      next: () => this.router.navigate(['/accounts']),
      error: err => {
        this.errorMessage = 'Error updating account';
        console.error(err);
      }
    });
  }
}
