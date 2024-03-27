import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { iProdotto } from './Models/i-prodotto';
import { Root } from './Models/i-root';

@Injectable({
  providedIn: 'root',
})
export class ProdService {
  apiUrl: string = 'https://dummyjson.com/products';

  constructor(private http: HttpClient) {}

  getAll() {
    return this.http.get<Root>(this.apiUrl);
  }
}
