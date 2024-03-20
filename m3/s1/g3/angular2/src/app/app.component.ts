import { Component } from '@angular/core';
import { Articolo } from './Models/articolo';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent {
  articoliArray: Articolo[] = [];

  ngOnInit() {
    fetch('../assets/db.json')
      .then((articoli) => articoli.json())
      .then((articolo) => (this.articoliArray = articolo.posts));
  }
}
