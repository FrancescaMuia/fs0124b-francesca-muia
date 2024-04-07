import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../environments/environment.development';
import { IUser } from './Models/i-user';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  usersUrl: string = environment.usersUrl;

  userArray: IUser[] = [];

  userSubject = new BehaviorSubject<IUser[]>([]);

  $users = this.userSubject.asObservable();

  constructor(private http: HttpClient) {
    this.getAllUsers().subscribe((data) => {
      this.userSubject.next(data);
      this.userArray = data;
    });
  }

  getAllUsers() {
    return this.http.get<IUser[]>(this.usersUrl);
  }
}
