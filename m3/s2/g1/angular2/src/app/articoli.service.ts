import { Injectable } from '@angular/core';
import { Articolo } from './Models/articolo';

@Injectable({
  providedIn: 'root',
})
export class ArticoliService {
  articoliArray: Articolo[] = [];
  articoliRandom: Articolo[] = [];

  getArticoli(): Promise<Articolo[]> {
    return fetch('../assets/db.json')
      .then((articoli) => articoli.json())
      .then((articolo) => {
        this.articoliArray = articolo.posts;
        this.soloQuattroRandom();
        return articolo.posts;
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

  getActivePizza(): Promise<Articolo[]> {
    return this.getArticoli().then((res) => res.filter((a) => a.active));
  }

  getInactivePizza(): Promise<Articolo[]> {
    return this.getArticoli().then((res) => res.filter((a) => !a.active));
  }
}
