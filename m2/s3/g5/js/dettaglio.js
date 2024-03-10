let url = new URLSearchParams(location.search);
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
    let img = document.querySelector(".card-img-top");
    let title = document.querySelector(".card-title");
    let text = document.querySelector(".card-text");
    let price = document.querySelector(".price");
    let description = document.querySelector(".description");

    img.src = p.imageUrl;
    text.innerHTML = p.brand;
    title.innerHTML = p.name;
    price.innerHTML = p.price;
    description.innerHTML = p.description;
  });
