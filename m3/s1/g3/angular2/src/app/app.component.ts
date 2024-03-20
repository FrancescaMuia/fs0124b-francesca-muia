import { Component } from '@angular/core';
import { Articolo } from './Models/articolo';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent {
  articoliArray: Articolo[] = [];
  articoliRandom: Articolo[] = [];

  ngOnInit() {
    fetch('../assets/db.json')
      .then((articoli) => articoli.json())
      .then((articolo) => {
        this.articoliArray = articolo.posts;
        this.soloQuattroRandom();
      });
  }

  soloQuattroRandom(): void {
    for (let i = 0; i < 4; i++) {
      let random = Math.floor(Math.random() * this.articoliArray.length);
      this.articoliRandom.push(this.articoliArray[random]);
      //per non ripetere stesso articolo
      this.articoliArray = this.articoliArray.filter(
        (articolo) => articolo !== this.articoliArray[random]
      );
    }
  }
}
