import { Component } from '@angular/core';
import { iProdotto } from '../../Models/i-prodotto';
import { ProdService } from '../../prod.service';

@Component({
  selector: 'app-preferiti',
  templateUrl: './preferiti.component.html',
  styleUrl: './preferiti.component.scss',
})
export class PreferitiComponent {
  pref: iProdotto[] = [];

  constructor(private prodSvc: ProdService) {}

  ngOnInit() {}
}
