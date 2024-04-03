import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrl: './form.component.scss',
})
export class FormComponent {
  firstform!: FormGroup;

  constructor(private fb: FormBuilder) {}

  ngOnInit() {
    this.firstform = this.fb.group({
      name: this.fb.control(null, [Validators.required]),
      surname: this.fb.control(null),
      password: this.fb.control(null),
      confPassword: this.fb.control(null),
      option: this.fb.control(null),
      bio: this.fb.control(null),
      username: this.fb.control(null),
    });
  }

  submitForm() {
    console.log(this.firstform.value);
  }

  isValid(name: string): boolean {
    const field = this.firstform.get(name);

    if (!field) return true;

    return field.touched && field.invalid;
  }
}
