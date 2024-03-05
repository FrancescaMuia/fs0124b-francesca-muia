let name = document.querySelector("#nameAdded");
let save = document.querySelector("#btnSave");
let remove = document.querySelector("#btnDelete");
let memorizzato = document.querySelector("#datoMemorizzato");

btnSave.addEventListener("click", function () {
  let name = nameAdded.value;
  localStorage.setItem("savedName", name);
  memorizzato.innerText = name;
});

btnDelete.addEventListener("click", function () {
  localStorage.removeItem("savedName");
  memorizzato.innerText = "";
});
