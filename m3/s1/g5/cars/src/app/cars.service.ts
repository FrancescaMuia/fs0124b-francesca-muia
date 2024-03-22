import { Injectable } from '@angular/core';
import { iCar } from './Models/i-car';

@Injectable({
  providedIn: 'root',
})
export class CarsService {
  carArray: iCar[] = [];
  carRandom: iCar[] = [];

  getCars(): Promise<iCar[]> {
    return fetch('../assets/db.json')
      .then((res) => res.json())
      .then((res: iCar[]) => res);
  }

  getAudi(): Promise<iCar[]> {
    return this.getCars().then((res) => res.filter((c) => c.brand === 'Audi'));
  }

  getFiat(): Promise<iCar[]> {
    return this.getCars().then((res) => res.filter((c) => c.brand === 'Fiat'));
  }

  getFord(): Promise<iCar[]> {
    return this.getCars().then((res) => res.filter((c) => c.brand === 'Ford'));
  }

  soloDueRandom(): void {
    for (let i = 0; i < 2; i++) {
      let random = Math.floor(Math.random() * this.carArray.length);
      this.carRandom.push(this.carArray[random]);
      //per non ripetere stesso articolo
      this.carArray = this.carArray.filter(
        (car) => car !== this.carArray[random]
      );
    }
  }
}
