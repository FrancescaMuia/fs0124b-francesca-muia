/* ESERCIZIO 1
 Scrivi un algoritmo per trovare il più grande tra due numeri interi.
*/

let a = 5;
let b = 45;

if (a > b) {
  console.log("il più grande è a");
} else if (b > a) {
  console.log("il più grande è b");
} else {
  console.log("nessuno");
}

/*
oppure

if (a > b) {
  console.log("il più grande è " + a);
} else if (a < b) {
  console.log("il più grande è " + b);
} else {
  console.log("i numeri sono uguali");
}
*/

/* ESERCIZIO 2
  Scrivi un algoritmo che mostri "not equal" in console se un numero intero fornito è diverso da 5.
*/

let numeroIntero = 2;

if (numeroIntero === 5) {
  console.log("equal");
} else {
  console.log("not equal");
}

/*
oppure

let x = 8;
if(x !== 5) console.log('not equal');
*/

/* ESERCIZIO 3
  Scrivi un algoritmo che mostri "divisibile per 5" in console se un numero fornito è perfettamente divisibile per 5 (suggerimento: usa l'operatore modulo)
*/

let numeroDivisibile = 10;

if (numeroDivisibile % 5 === 0) {
  console.log("divisibile per 5");
} else {
  console.log("non divisibile");
}

/*
oppure

let x2 = 15

if (x2 % 5 === 0) {
  console.log('divisibile per 5')
}
*/

/* ESERCIZIO 4
  Scrivi un algoritmo per verificare che, dati due numeri interi, il valore di uno di essi sia 8 oppure se la loro addizione/sottrazione sia uguale a 8.
*/

/*
condizioni valide
let n1 = 4;
let n2 = 4;
oppure
let n1 = 2;
let n2 = 8;

non è valido
let n1 = 10;
let n2 = 12;
 */
let n1 = 10;
let n2 = 2;

/*
questa soluzione è più generica

if (n1 === 8 || n2 === 8 || n1 + n2 === 8 || n1 - n2 === 8) {
  console.log("uno è valido");
} else {
  console.log("niente è valido");
}
*/

if (n1 === 8 || n2 === 8) {
  console.log("uno dei due è 8");
} else if (n1 + n2 === 8 || n1 - n2 === 8) {
  console.log("addizione o sottrazione uguale a 8");
} else {
  console.log("niente è valido");
}

/*
oppure

let n1 = 10;
let n2 = 4;

if(n1 === 8 || n2 === 8 || (n1 + n2) === 8 || (n1 - n2) === 8) || (n2 - n1 === 8){
  console.log('verificato');
}
*/

/* ESERCIZIO 5
  Stai lavorando su un sito di e-commerce. Stai salvando il saldo totale del carrello dell'utente in una variabile "totalShoppingCart".
  C'è una promozione in corso: se il totale del carrello supera 50, l'utente ha diritto alla spedizione gratuita (altrimenti la spedizione ha un costo fisso pari a 10).
  Crea un algoritmo che determini l'ammontare totale che deve essere addebitato all'utente per il checkout.
*/

{
  let totalShoppingCart = 20;

  if (totalShoppingCart >= 50) {
    console.log("spedizione gratuita");
  } else {
    console.log(totalShoppingCart + 10);
  }
}

/*
oppure

let totalShoppingCart = 65
let shippingCost = 10
let amountToPay = totalShoppingCart

if (totalShoppingCart < 50) {
  amountToPay += shippingCost
}

console.log('Totale da pagare:', amountToPay)
*/

/* ESERCIZIO 6
  Stai lavorando su un sito di e-commerce. Oggi è il Black Friday e viene applicato il 20% su ogni prodotto.
  Modifica la risposta precedente includendo questa nuova promozione nell'algoritmo, determinando come prima se le spedizioni sono gratuite oppure no e e calcolando il totale.
*/

{
  let totalShoppingCart = 20;
  let totaleScontato = totalShoppingCart - totalShoppingCart * 0.2;

  if (totaleScontato >= 50) {
    console.log("spedizione gratuita");
  } else {
    console.log(totaleScontato + 10);
  }
}

/*
oppure

let totalShoppingCart2 = 65
totalShoppingCart2 = totalShoppingCart2 * 0.8
let shippingCost2 = 10
let amountToPay2 = totalShoppingCart2

if (totalShoppingCart2 < 50) {
  amountToPay2 += shippingCost2
}

console.log('Totale da pagare:', amountToPay2)
*/

/* ESERCIZIO 7
  Crea tre variabili, e assegna un valore numerico a ciascuna di esse.
  Utilizzando un blocco condizionale, crea un algoritmo per ordinarle secondo il loro valore, dal più alto al più basso.
  Alla fine mostra il risultato in console.
*/

let valore1 = 2;
let valore2 = 30;
let valore3 = 10;

if (valore1 >= valore2) {
  if (valore3 >= valore1) {
    console.log(valore3, valore1, valore2);
  } else {
    if (valore3 >= valore2) {
      console.log(valore1, valore3, valore2);
    } else {
      console.log(valore1, valore2, valore3);
    }
  }
} else {
  if (valore3 >= valore2) {
    console.log(valore3, valore2, valore1);
  } else {
    if (valore3 >= valore1) {
      console.log(valore2, valore3, valore1);
    } else {
      console.log(valore2, valore1, valore3);
    }
  }
}

/* ESERCIZIO 8
  Crea un algoritmo per verificare che un valore fornito sia un numero oppure no (suggerimento: cerca su un motore di ricerca "typeof").
*/

let valore4 = 50;

if (typeof valore4 === "number") {
  console.log(" è un numero");
} else {
  console.log(valore4 + " non è un numero");
}

/*
qui ho in console il contenuto dell'else

let valore5 = 'ciao';

if (typeof valore5 === "number") {
  console.log(" è un numero");
} else {
  console.log(valore5 + " non è un numero");
}
*/

/* ESERCIZIO 9
  Crea un algoritmo per controllare se un numero fornito sia pari o dispari (suggerimento: cerca l'operatore modulo su un motore di ricerca)
*/

let numero = 23;

if (numero % 2 === 0) {
  console.log("pari");
} else {
  console.log("dispari");
}

/* ESERCIZIO 10
  Modifica la logica del seguente algoritmo in modo che mostri in console il messaggio corretto in ogni circostanza.
  let val = 7
  if (val < 10) {
      console.log("Meno di 10");
    } else if (val < 5) {
      console.log("Meno di 5");
    } else {
      console.log("Uguale a 10 o maggiore");
    }
*/

let val = 7;
if (val < 10 && val > 5) {
  console.log("Meno di 10");
} else if (val < 5) {
  console.log("Meno di 5");
} else {
  console.log("Uguale a 10 o maggiore");
}

/*
oppure

let val = 7
if (val < 5) {
  console.log('Meno di 5')
} else if (val < 10) {
  console.log('Meno di 10')
} else {
  console.log('Uguale a 10 o maggiore')
}
*/

/* ESERCIZIO 11
  Fornito il seguente oggetto, scrivi del codice per aggiungere una proprietà "city", il cui valore sarà "Toronto".
*/

const me = {
  name: "John",
  lastName: "Doe",
  skills: ["javascript", "html", "css"],
};

me.city = "Toronto";
console.log(me);

/* ESERCIZIO 12
  Lavorando sempre sull'oggetto precedentemente fornito, scrivi del codice per rimuovere la proprietà "lastName".
*/

delete me.lastName;
console.log(me);

/* ESERCIZIO 13
  Lavorando sempre sull'oggetto precedentemente fornito, scrivi del codice per rimuovere l'ultimo elemento della proprietà "skills".
*/

me.skills.pop();
console.log(me);

/* ESERCIZIO 14
  Scrivi del codice per creare un array inizialmente vuoto. Riempilo successivamente con i numeri da 1 a 10.
*/

let array = [];
console.log(array);
array.push(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
console.log(array);

/* ESERCIZIO 15
  Scrivi del codice per sostituire l'ultimo elemento dell'array, ovvero il valore 10, con il valore 100.
*/

array.pop();
console.log(array);
array.push(100);
console.log(array);

array.splice(-1, 1, 100);
console.log(array);

/*
oppure

myArray[9] = 100
console.log(myArray)
*/
