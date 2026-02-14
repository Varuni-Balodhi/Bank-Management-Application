import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BaseChartDirective } from 'ng2-charts';
import { Router } from '@angular/router';
import { AccountService } from '@core/services/account.service';

@Component({
  selector: 'app-clerk-dashboard',
  standalone: true,
  imports: [CommonModule, BaseChartDirective],
  templateUrl: './clerk-dashboard.component.html'
})
export class ClerkDashboardComponent implements OnInit {

  transfers: any[] = [];

  todayTransactions = 8;
  deposits = 5;
  withdrawals = 3;

  chartData = [5, 3];
  chartLabels = ['Deposits', 'Withdrawals'];

  constructor(
    private router: Router,
    private accountService: AccountService
  ) {}

  ngOnInit(): void {
    this.loadTransfers();
  }

  loadTransfers(): void {
    this.accountService.getTransfers().subscribe({
      next: (data) => {
        this.transfers = data;
        console.log("TRANSFERS:", this.transfers);
      },
      error: (err) => {
        console.error("Error loading transfers", err);
      }
    });
  }

  goToDeposit(): void {
    this.router.navigate(['/deposit']);
  }

  goToWithdraw(): void {
    this.router.navigate(['/withdraw']);
  }

  goToTransfer(): void {
    this.router.navigate(['/transfer']);
  }
}
