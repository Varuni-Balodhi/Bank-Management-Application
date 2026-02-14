import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AccountService } from '../../core/services/account.service';

@Component({
  selector: 'app-user-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users: any[] = [];

  constructor(private accountService: AccountService) {}

  ngOnInit() {
    this.accountService.getUsers().subscribe({
      next: (data) => {
        this.users = data;
        console.log("USERS IN USER COMP",this.users);
        console.log(this.users.length);
      }
    });
  }
}
