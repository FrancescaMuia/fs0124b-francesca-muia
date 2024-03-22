import { Component } from '@angular/core';
import { iCar } from '../../Models/i-car';
import { CarsService } from '../../cars.service';

@Component({
  selector: 'app-audi',
  templateUrl: './audi.component.html',
  styleUrl: './audi.component.scss',
})
export class AudiComponent {
  carArray: iCar[] = [];

  constructor(private carSvc: CarsService) {}

  ngOnInit() {
    this.carSvc.getAudi().then((res) => {
      this.carArray = res;
    });
  }
}
