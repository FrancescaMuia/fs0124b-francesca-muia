async function chiamata(query) {
  const apiKey = "sUJ9ljZG3us09kZlcRU483nIwGGPJqPg7nTHDYD9X6Lkf7ymNa3zVJX6";

  return await fetch(`https://api.pexels.com/v1/search?query=${query}`, {
    method: "GET",
    headers: {
      Authorization: apiKey,
    },
  }).then((dati) => dati.json());
}

// chiamata("cat").then((cats) => {
//   console.log(cats);
// });

let button = document.querySelector(".my-2");
button.addEventListener("click", () => {
  chiamata("cat").then((dati) => {
    console.log(dati);
    let img = document.querySelectorAll(".card-img-top");
    img.forEach((img, index) => {
      img.src = dati.photos[index].src.medium;
    });
  });
});
