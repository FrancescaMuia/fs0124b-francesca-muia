import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../environments/environment.development';
import { IFilm } from './Models/ifilm';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class FilmService {
  filmUrl = environment.moviesUrl;

  filmArray: IFilm[] = [];

  filmSubject = new BehaviorSubject<IFilm[]>([]);

  $film = this.filmSubject.asObservable();
  constructor(private http: HttpClient) {
    this.getAllFilm().subscribe((data) => {
      this.filmSubject.next(data);
      this.filmArray = data;
    });
  }

  getAllFilm() {
    return this.http.get<IFilm[]>(this.filmUrl);
  }
}
