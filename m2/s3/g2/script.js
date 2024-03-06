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

let n = sessionStorage.getItem("numero") || 0;

const numeroDiv = document.querySelector("#timer");
numeroDiv.innerHTML = n;

setInterval(function () {
  n++;
  sessionStorage.setItem("numero", n);
  numeroDiv.innerHTML = n;
}, 1000);

// let i = sessionStorage.getItem("count") ? parseInt(sessionStorage.getItem("count")) : 0;

// const conta = function () {
//   i = i + 1;
//   document.getElementById("timer").innerText = i + " secondi di sessione aperta";
//   sessionStorage.setItem("count", i);
// };

// setInterval(conta, 1000);
