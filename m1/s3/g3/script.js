let btn = document.querySelector("#btn");

btn.addEventListener("click", addTask);

function addTask() {
  let newDiv = document.createElement("div");
  let deleteBtn = document.createElement("button");
  deleteBtn.innerText = "Elimina";
  deleteBtn.addEventListener("click");

  let value = document.getElementById("input").value;
  newDiv.innerText = value;

  document.querySelector("#target").append(newDiv, deleteBtn);
}
