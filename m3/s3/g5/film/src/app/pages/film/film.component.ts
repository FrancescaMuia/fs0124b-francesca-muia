import { Component } from '@angular/core';
import { IFilm } from '../../Models/ifilm';
import { FilmService } from '../../film.service';

@Component({
  selector: 'app-film',
  templateUrl: './film.component.html',
  styleUrl: './film.component.scss',
})
export class FilmComponent {
  film: IFilm[] = [];

  constructor(private filmSvc: FilmService) {}

  ngOnInit() {
    this.filmSvc.$film.subscribe((films) => {
      this.film = films;
    });
  }
}
