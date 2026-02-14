import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { Account } from '../../../shared/models/account';
import { AccountService } from '../../../core/services/account.service';

@Component({
  selector: 'app-account-details',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './account-details.component.html'
})
export class AccountDetailsComponent implements OnInit {

  account?: Account;
  error = '';
  loading = true;

  constructor(
    private route: ActivatedRoute,
    private accountService: AccountService,
    private router: Router
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));

    this.accountService.getAccountById(id).subscribe({
      next: (data) => {
        this.account = data;
        this.loading = false;
      },
      error: () => {
        this.error = 'Account not found';
        this.loading = false;
      }
    });
  }

  goBack() {
    this.router.navigate(['/accounts']);
  }
}
