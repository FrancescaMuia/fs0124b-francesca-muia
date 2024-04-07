import { Component } from '@angular/core';
import { IUser } from '../../Models/i-user';
import { UserService } from '../../user.service';

@Component({
  selector: 'app-registrati',
  templateUrl: './registrati.component.html',
  styleUrl: './registrati.component.scss',
})
export class RegistratiComponent {
  users: IUser[] = [];

  constructor(private userSvc: UserService) {}

  ngOnInit(): void {
    this.userSvc.$users.subscribe((users) => {
      this.users = users;
    });
  }
}
