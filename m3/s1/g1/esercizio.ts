interface Smartphone {
  credito: number;
  numeroChiamate: number;
}

class User implements Smartphone {
  credito: number;
  numeroChiamate: number;
  nome: string;
  cognome: string;
  costoMinutiChiamate: number[];

  constructor(_credito: number, _numeroChiamate: number, _nome: string, _cognome: string) {
    this.credito = _credito;
    this.numeroChiamate = _numeroChiamate;
    this.nome = _nome;
    this.cognome = _cognome;
    this.costoMinutiChiamate = [];
  }

  ricarica(amount: number) {
    this.credito += amount;
  }

  chiamata(minuti: number) {
    const costoPerMinuto = 0.2;
    const TotCostoChiamata = costoPerMinuto * minuti;
    this.credito -= TotCostoChiamata;
    this.numeroChiamate += minuti;
    this.costoMinutiChiamate.push(TotCostoChiamata);
  }

  numero404() {
    return this.credito;
  }

  getNumeroChiamate() {
    return this.numeroChiamate;
  }

  getCostoMinutiChiamate(): number[] {
    return this.costoMinutiChiamate; //costo singola chiamata
  }

  azzeraChiamate(): void {
    this.numeroChiamate = 0;
  }
}

let utente = new User(0, 0, "Mario", "Rossi");
utente.ricarica(20);
utente.chiamata(4);
utente.chiamata(2);
console.log(utente.credito);
console.log(utente.numeroChiamate);
console.log(utente.numero404());
utente.azzeraChiamate();
console.log(utente.getNumeroChiamate());
console.log(utente.getCostoMinutiChiamate());
