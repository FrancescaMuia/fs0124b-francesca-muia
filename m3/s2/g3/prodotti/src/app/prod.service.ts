import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { iProdotto } from './Models/i-prodotto';
import { Root } from './Models/i-root';
import { Subject, tap } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ProdService {
  apiUrl: string = 'https://dummyjson.com/products';

  preferiti: iProdotto[] = [];
  favSubject = new Subject<iProdotto>();
  cartSubject = new Subject<iProdotto>();
  $favourites = this.favSubject.asObservable().pipe(
    tap((p) => {
      this.preferiti.push(p);
    })
  );
  $cart = this.cartSubject.asObservable();

  constructor(private http: HttpClient) {}

  getAll() {
    return this.http.get<Root>(this.apiUrl);
  }

  addToFavourites(product: iProdotto) {
    this.favSubject.next(product);
  }

  addToCart(product: iProdotto) {
    this.cartSubject.next(product);
  }
}
