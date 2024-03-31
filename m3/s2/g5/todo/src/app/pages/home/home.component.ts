import { Component } from '@angular/core';
import { Todo } from '../../Models/todo';
import { TodoService } from '../../service/todo.service';
import { User } from '../../Models/user';
import { UsersService } from '../../service/users.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent {
  todos: Todo[] = [];
  users: User[] = [];

  constructor(private todoSvc: TodoService, private userSvc: UsersService) {}

  ngOnInit() {
    this.todos = this.todoSvc.getAll();
  }

  toggleChangeStatus(todo: Todo): void {
    todo.completed = !todo.completed;
  }

  getUserName(userId: number): string {
    return this.userSvc.getName(userId);
  }
}
