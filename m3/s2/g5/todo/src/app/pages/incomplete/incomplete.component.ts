import { Component } from '@angular/core';
import { Todo } from '../../Models/todo';
import { User } from '../../Models/user';
import { TodoService } from '../../service/todo.service';
import { UsersService } from '../../service/users.service';

@Component({
  selector: 'app-incomplete',
  templateUrl: './incomplete.component.html',
  styleUrl: './incomplete.component.scss',
})
export class IncompleteComponent {
  todos: Todo[] = [];
  users: User[] = [];

  constructor(private todoSvc: TodoService, private userSvc: UsersService) {}

  ngOnInit() {
    this.todos = this.todoSvc.getIncomplete();
  }

  toggleChangeStatus(todo: Todo): void {
    todo.completed = !todo.completed;
    //metto nel nuovo array i task non uguali a quello rimosso
    if (todo.completed) {
      this.todos = this.todos.filter((t) => t !== todo);
    }
  }

  getUserName(userId: number): string {
    return this.userSvc.getName(userId);
  }
}
