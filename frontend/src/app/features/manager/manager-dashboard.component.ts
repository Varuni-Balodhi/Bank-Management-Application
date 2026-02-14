import { Component, OnInit, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardCardComponent } from '../../shared/components/dashboard-card/dashboard-card.comoponent';
import { ChartWidgetComponent } from '../../shared/components/chart-widget/chart-widget.component';
import { BaseChartDirective } from 'ng2-charts';
import { Router } from '@angular/router';
import { AccountService } from '@core/services/account.service';
import { UserListComponent } from '@features/users/user-list.components';
@Component({
  selector: 'app-manager-dashboard',
  standalone: true,
  imports: [CommonModule, DashboardCardComponent, ChartWidgetComponent,BaseChartDirective, UserListComponent],
  templateUrl: './manager-dashboard.component.html'
})
export class ManagerDashboardComponent implements OnInit {
  constructor(
      private router: Router,
      private accountService: AccountService
    ) {}
   users: any[]=[];
   totalUsers = 12;
   totalAccounts = 30;
   pendingApprovals = 4;

  chartData = [5, 10, 7, 3];
  chartLabels = ['Deposits', 'Withdrawals', 'Transfers', 'Pending'];

  goToAccounts() {
    this.router.navigate(['/accounts']);
  }

  getUsers(){
     this.router.navigate(['/userList']);
  }
   ngOnInit() {
  }
  goToApprovals() {
    this.router.navigate(['/approvals']);
  }

}
