import { Component } from '@angular/core';
import { iProdotto } from '../../Models/i-prodotto';
import { ProdService } from '../../prod.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent {
  prodotti: iProdotto[] = [];

  constructor(private prodSvc: ProdService) {}

  ngOnInit() {
    this.prodSvc.getAll().subscribe((prod) => {
      this.prodotti = prod.products;
    });
  }
}
