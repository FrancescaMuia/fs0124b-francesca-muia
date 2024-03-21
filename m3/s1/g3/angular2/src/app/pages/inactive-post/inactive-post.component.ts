import { Component } from '@angular/core';
import { ArticoliService } from '../../articoli.service';
import { Articolo } from '../../Models/articolo';

@Component({
  selector: 'app-active-post',
  templateUrl: './inactive-post.component.html',
  styleUrl: './inactive-post.component.scss',
})
export class InactivePostComponent {
  articoliArray: Articolo[] = [];
  articoliRandom: Articolo[] = [];

  constructor(private articoliSvc: ArticoliService) {}

  ngOnInit() {
    this.articoliSvc.getArticoli().then((res) => {
      this.articoliArray = res.filter((articolo) => articolo.active === false);
    });
  }
}
