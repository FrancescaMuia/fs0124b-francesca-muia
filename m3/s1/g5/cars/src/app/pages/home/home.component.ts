import { Component } from '@angular/core';
import { iCar } from '../../Models/i-car';
import { CarsService } from '../../cars.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent {
  carArray: iCar[] = [];
  carRandom: iCar[] = [];

  constructor(private carSvc: CarsService) {}

  ngOnInit() {
    // this.carSvc.getCars().then((res) => {
    //   this.carArr = res;
    // });
    this.carSvc.getCars().then((res) => {
      // this.articoliRandom = res;
      // console.log(this.articoliRandom);
      for (let i = 0; i < 2; i++) {
        let random = Math.floor(Math.random() * this.carArray.length);
        this.carRandom.push(res[random]);
        // per non ripetere stesso articolo
        this.carArray = res.filter((car) => car !== this.carArray[random]);
      }
    });
    console.log(this.carArray);
  }
}
