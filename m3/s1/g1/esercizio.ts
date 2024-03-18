interface Smartphone {
  credito: number;
  numeroChiamate: number;
}

class User implements Smartphone {
  credito: number;
  numeroChiamate: number;
  nome: string;
  cognome: string;

  constructor(_credito: number, _numeroChiamate: number, _nome: string, _cognome: string) {
    this.credito = _credito;
    this.numeroChiamate = _numeroChiamate;
    this.nome = _nome;
    this.cognome = _cognome;
  }
}
