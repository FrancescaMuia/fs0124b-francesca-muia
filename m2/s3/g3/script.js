fetch("https://striveschool-api.herokuapp.com/books")
  .then((response) => response.json())
  .then((books) => {
    console.log(books);
    books.forEach((book) => {
      let bookCard = `
        <div class="card" style="width: 18rem;">
          <img src="${book.img}" class="card-img-top">
          <div class="card-body">
            <h5 class="card-title">${book.title}</h5>
            <p class="card-text">Price: €${book.price}</p>
            <button class="btn btn-danger scarta">Scarta</button>
          </div>
        </div>
      `;
      document.getElementById("books").innerHTML += bookCard;
    });

    document.querySelectorAll(".scarta").forEach((button) => {
      button.addEventListener("click", function () {
        this.closest(".card").remove();
      });
    });
  });
