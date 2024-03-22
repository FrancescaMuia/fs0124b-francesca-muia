import { Component } from '@angular/core';
import { iCar } from '../../Models/i-car';
import { CarsService } from '../../cars.service';

@Component({
  selector: 'app-fiat',
  templateUrl: './fiat.component.html',
  styleUrl: './fiat.component.scss',
})
export class FiatComponent {
  carArray: iCar[] = [];

  constructor(private carSvc: CarsService) {}

  ngOnInit() {
    this.carSvc.getFiat().then((res) => {
      this.carArray = res;
    });
  }
}
