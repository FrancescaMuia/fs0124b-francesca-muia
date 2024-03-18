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

  ricarica(amount: number) {
    this.credito += amount;
  }

  chiamata(minuti: number) {
    const costoPerMinuto = 0.2;
    const TotCostoChiamata = costoPerMinuto * minuti;
    this.credito -= TotCostoChiamata;
  }
}

let utente = new User(0, 0, "Mario", "Rossi");
utente.ricarica(20);
utente.chiamata(4);
console.log(utente.credito);
console.log(utente.numeroChiamate);
