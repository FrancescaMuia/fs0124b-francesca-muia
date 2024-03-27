import { iProdotto } from './i-prodotto';

export interface Root {
  products: iProdotto[];
  total: number;
  skip: number;
  limit: number;
}
