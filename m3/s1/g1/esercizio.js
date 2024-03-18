"use strict";
class User {
    constructor(_credito, _numeroChiamate, _nome, _cognome) {
        this.credito = _credito;
        this.numeroChiamate = _numeroChiamate;
        this.nome = _nome;
        this.cognome = _cognome;
    }
    ricarica(amount) {
        this.credito += amount;
    }
    chiamata(minuti) {
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
