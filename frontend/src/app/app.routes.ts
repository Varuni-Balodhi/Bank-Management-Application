import { Routes } from '@angular/router';

import { LoginComponent } from './features/auth/login/login.component';
import { AccountListComponent } from './features/accounts/account-list/account-list.component';
import { AccountDetailsComponent } from './features/accounts/account-details/account-details.component';
import { CreateAccountComponent } from './features/accounts/create-account/create-account.component';
import { DepositComponent } from './features/transactions/deposit/deposit.component';
import { WithdrawComponent } from './features/transactions/withdraw/withdraw.component';
import { TransferComponent } from './features/transactions/transfer/transfer.component';
import { ClerkDashboardComponent } from './features/clerk/clerk-dashboard.component';
import { ManagerDashboardComponent } from './features/manager/manager-dashboard.component';
import { UserListComponent } from '@features/users/user-list.components';
//import { ApprovalListComponent } from '@features/approvals/approvals.component'

import { authGuard } from './core/guards/auth.guard';

export const routes: Routes = [

  // Default route
  { path: '', redirectTo: 'login', pathMatch: 'full' },

  // Login
  { path: 'login', component: LoginComponent },

  // Dashboards
  { path: 'clerk-dashboard', component: ClerkDashboardComponent, canActivate: [authGuard] },
  { path: 'manager-dashboard', component: ManagerDashboardComponent, canActivate: [authGuard] },

  // Accounts
  { path: 'accounts', component: AccountListComponent, canActivate: [authGuard] },
  { path: 'accounts/:id', component: AccountDetailsComponent, canActivate: [authGuard] },
  { path: 'accounts/create', component: CreateAccountComponent, canActivate: [authGuard] },

  // Transactions
  { path: 'deposit', component: DepositComponent, canActivate: [authGuard] },
  { path: 'withdraw', component: WithdrawComponent, canActivate: [authGuard] },
  { path: 'transfer', component: TransferComponent, canActivate: [authGuard] },

  //Users
  { path: 'users', component: AccountListComponent, canActivate: [authGuard] },
  { path: 'users/:id', component: AccountDetailsComponent, canActivate: [authGuard] },
  { path: 'users/create', component: CreateAccountComponent, canActivate: [authGuard] },

  { path: 'userList', component: UserListComponent, canActivate: [authGuard] },
  //{ path: 'approvals', component: ApprovalListComponent, canActivate: [authGuard] },

  // Wildcard MUST BE LASTs
  { path: '**', redirectTo: 'login' }
];
