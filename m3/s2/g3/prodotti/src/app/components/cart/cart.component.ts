import { Component } from '@angular/core';
import { iProdotto } from '../../Models/i-prodotto';
import { ProdService } from '../../prod.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrl: './cart.component.scss',
})
export class CartComponent {
  show: boolean = false;

  products: iProdotto[] = [];

  constructor(private prodSvc: ProdService) {}

  ngOnInit() {
    this.prodSvc.$cart.subscribe((p) => {
      this.products.push(p);
    });
  }
}
