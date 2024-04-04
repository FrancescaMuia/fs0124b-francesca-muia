import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss',
})
export class LoginComponent {
  @ViewChild('f', { static: true }) form!: NgForm;

  submit(form: NgForm) {
    if (form.valid) {
      console.log('Dati del login:', form.value);
    }
  }
}
