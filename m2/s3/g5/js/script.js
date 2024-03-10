fetch("https://striveschool-api.herokuapp.com/api/product/", {
  headers: {
    "Content-type": "application/json",
    Authorization: "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZGRmMTJkN2IxMTAwMTkwZTZlMGQiLCJpYXQiOjE3MDk4OTEwNTcsImV4cCI6MTcxMTEwMDY1N30.YWAN3Mh3MTSK9u_LrQj8pOBYI_izx7PMysbE89CZf7g",
  },
})
  .then((res) => res.json())
  .then((prodotti) => {
    console.log(prodotti);

    for (let prodotto of prodotti) {
      let card = generaClone();

      let cardImg = card.querySelector(".card-img-top");
      let cardTitle = card.querySelector(".card-title");
      let cardText = card.querySelector(".card-text");
      let btnEdit = card.querySelector(".edit");
      let btnInfo = card.querySelector(".moreInfo");

      cardImg.src = prodotto.imageUrl;
      cardTitle.innerText = prodotto.name;
      cardText.innerText = prodotto.description;
      btnEdit.href = `edit.html?id=${prodotto._id}`;
      btnInfo.href = `dettaglio.html?id=${prodotto._id}`;

      document.querySelector("#listaProdotti").appendChild(card);
    }
  })
  .catch((error) => console.error("Errore:", error));

function generaClone() {
  let template = document.querySelector("#template-card");
  let clone = template.content.cloneNode(true);

  return clone;
}
