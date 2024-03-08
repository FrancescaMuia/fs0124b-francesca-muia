let form = document.getElementById("form");

form.addEventListener("submit", function (e) {
  e.preventDefault();

  let nome = document.querySelector("#name").value;
  let brand = document.querySelector("#brand").value;
  let prezzo = document.querySelector("#price").value;
  let img = document.querySelector("#imgUrl").value;
  let descrizione = document.querySelector("#description").value;

  let product = {
    name: nome,
    brand: brand,
    price: prezzo,
    imageUrl: img,
    description: descrizione,
  };

  fetch("https://striveschool-api.herokuapp.com/api/product/", {
    method: "POST",
    headers: {
      "Content-type": "application/json",
      Authorization: "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZGRmMTJkN2IxMTAwMTkwZTZlMGQiLCJpYXQiOjE3MDk4OTEwNTcsImV4cCI6MTcxMTEwMDY1N30.YWAN3Mh3MTSK9u_LrQj8pOBYI_izx7PMysbE89CZf7g",
    },
    body: JSON.stringify(product),
  })
    .then((res) => res.json())
    .then((res) => {
      console.log(res);
      location.href = "index.html";
    });
});
