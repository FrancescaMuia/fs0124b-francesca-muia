import { Component } from '@angular/core';
import { ArticoliService } from '../../articoli.service';
import { Articolo } from '../../Models/articolo';

@Component({
  selector: 'app-active-post',
  templateUrl: './active-post.component.html',
  styleUrl: './active-post.component.scss',
})
export class ActivePostComponent {
  articoliRandom: Articolo[] = [];

  constructor(private articoliSvc: ArticoliService) {}

  ngOnInit() {}
}
