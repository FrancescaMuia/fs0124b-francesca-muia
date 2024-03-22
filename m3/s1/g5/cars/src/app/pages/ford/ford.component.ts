import { Component } from '@angular/core';
import { iCar } from '../../Models/i-car';
import { CarsService } from '../../cars.service';

@Component({
  selector: 'app-ford',
  templateUrl: './ford.component.html',
  styleUrl: './ford.component.scss',
})
export class FordComponent {
  carArray: iCar[] = [];

  constructor(private carSvc: CarsService) {}

  ngOnInit() {
    this.carSvc.getFord().then((res) => {
      this.carArray = res;
    });
  }
}
