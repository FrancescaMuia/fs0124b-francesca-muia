import { Component } from '@angular/core';
import { Todo } from '../../Models/todo';
import { User } from '../../Models/user';
import { TodoService } from '../../service/todo.service';
import { UsersService } from '../../service/users.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrl: './users.component.scss',
})
export class UsersComponent {
  todos: Todo[] = [];
  users: User[] = [];

  constructor(private todoSvc: TodoService, private userSvc: UsersService) {}

  ngOnInit() {
    this.users = this.userSvc.getAll();
  }
}
