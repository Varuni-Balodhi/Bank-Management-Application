import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Account {
  id: number;
  name: string;
  balance: number;
  email: string;
  phone: string;
}

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  private baseUrl = 'http://localhost:8080/accounts';
  private txUrl = 'http://localhost:8080/transactions';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Account[]> {
    return this.http.get<Account[]>(this.baseUrl);
  }

  createAccount(account: Account) {
  return this.http.post(this.baseUrl, account);
 }

 updateAccount(id: number, account: Account) {
  return this.http.put(`${this.baseUrl}/${id}`, account);
 }

 getAccountById(id: number) {
  return this.http.get<Account>(`${this.baseUrl}/${id}`);
 }

  delete(id: number) {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }

  deposit(request: any) {
    return this.http.put(`${this.txUrl}/deposit`, request);
  }

  withdraw(request: any) {
    return this.http.put(`${this.txUrl}/withdraw`, request);
  }

  transfer(request: any) {
    return this.http.put(`${this.txUrl}/transfer`, request);
  }
  getUsers() {
   return this.http.get<any[]>('http://localhost:8080/users');
  }
  createUser(user: any) {
  return this.http.post('http://localhost:8080/users', user);
  }
  getTransfers() {
  return this.http.get<any[]>('http://localhost:8080/transactions');
  }

  updateUser(id: number, user: any) {
  return this.http.put(`http://localhost:8080/users/${id}`, user);
  }

  getUserById(id: number) {
  return this.http.get(`http://localhost:8080/users/${id}`);
  }


}
