export interface Articolo {
  id: number;
  title: string;
  body: string;
  userId: number;
  tags: string[];
  active: boolean;
}
