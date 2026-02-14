import { Component, OnInit } from '@angular/core';
import { AccountService, Account } from '../../../core/services/account.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-account-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './account-list.component.html'
})
export class AccountListComponent implements OnInit {

  accounts: Account[] = [];
  users: any[] = [];
  constructor(
    private accountService: AccountService,
    private router: Router
  ) {}


  ngOnInit() {
  this.accountService.getUsers().subscribe({
    next: data => {
      this.users = data;
    },
    error: err => console.error(err)
    });
  }
  loadUsers() {
  this.accountService.getUsers().subscribe(data => {
    this.users = data;
  });
}
  loadAccounts() {
    this.accountService.getAll().subscribe(data => {
      this.accounts = data;
    });
  }

  view(id: number) {
    this.router.navigate(['/account-details', id]);
  }

  delete(id: number) {
    this.accountService.delete(id).subscribe(() => {
      this.loadAccounts();
    });
  }
}
