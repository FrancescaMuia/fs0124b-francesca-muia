const numeriCaselle = document.querySelector(".contentCaselle");

//ciclo per avere i numeri
for (let i = 1; i <= 76; i++) {
  //creo i div con i numeri e assegno la classe
  const numbers = document.createElement("div");
  numbers.classList.add("caselle");

  //inserisco numeri nelle caselle
  numbers.innerText = i;

  //appendo le caselle al contenitore per vederle
  numeriCaselle.append(numbers);
}
