let url = new URLSearchParams(location.search);
console.log(url);
let id = url.get("id");
console.log(id);

fetch(`https://striveschool-api.herokuapp.com/api/product/${id}`, {
  headers: {
    "Content-Type": "application/json",
    Authorization: "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZGRmMTJkN2IxMTAwMTkwZTZlMGQiLCJpYXQiOjE3MDk4OTEwNTcsImV4cCI6MTcxMTEwMDY1N30.YWAN3Mh3MTSK9u_LrQj8pOBYI_izx7PMysbE89CZf7g",
  },
})
  .then((res) => res.json())
  .then((p) => {
    document.querySelector("#name").value = p.name;
    document.querySelector("#brand").value = p.brand;
    document.querySelector("#price").value = p.price;
    document.querySelector("#imgUrl").value = p.imageUrl;
    document.querySelector("#description").value = p.description;
  });

const salva = document.querySelector("#salva");
salva.addEventListener("click", function (e) {
  e.preventDefault();

  let name = document.querySelector("#name").value;
  let brand = document.querySelector("#brand").value;
  let price = document.querySelector("#price").value;
  let imageUrl = document.querySelector("#imgUrl").value;
  let description = document.querySelector("#description").value;

  let pModificato = {
    name,
    brand,
    price,
    imageUrl,
    description,
  };

  fetch(`https://striveschool-api.herokuapp.com/api/product/${id}`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
      Authorization: "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZGRmMTJkN2IxMTAwMTkwZTZlMGQiLCJpYXQiOjE3MDk4OTEwNTcsImV4cCI6MTcxMTEwMDY1N30.YWAN3Mh3MTSK9u_LrQj8pOBYI_izx7PMysbE89CZf7g",
    },
    body: JSON.stringify(pModificato),
  })
    .then((res) => res.json())
    .then((res) => {
      console.log(res);
      location.href = "index.html";
    })
    .catch((error) => console.error("Errore:", error));
});

const elimina = document.querySelector("#elimina");
elimina.addEventListener("click", function () {
  fetch(`https://striveschool-api.herokuapp.com/api/product/${id}`, {
    method: "DELETE",
    headers: {
      "Content-Type": "application/json",
      Authorization: "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZGRmMTJkN2IxMTAwMTkwZTZlMGQiLCJpYXQiOjE3MDk4OTEwNTcsImV4cCI6MTcxMTEwMDY1N30.YWAN3Mh3MTSK9u_LrQj8pOBYI_izx7PMysbE89CZf7g",
    },
  })
    .then((res) => res.json())
    .then(() => {
      location.href = "index.html";
    })
    .catch((error) => console.error("Errore:", error));
});
