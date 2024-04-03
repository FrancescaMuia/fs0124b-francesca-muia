import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrl: './form.component.scss',
})
export class FormComponent {
  form!: FormGroup;

  constructor(private fb: FormBuilder) {}

  ngOnInit() {
    this.form = this.fb.group({
      name: this.fb.control(null),
      surname: this.fb.control(null),
      password: this.fb.control(null),
      confPassword: this.fb.control(null),
      option: this.fb.control(null),
      bio: this.fb.control(null),
      username: this.fb.control(null),
    });
  }
}
