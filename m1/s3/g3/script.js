let btn = document.querySelector("#btn");

btn.addEventListener("click", addTask);

function addTask() {
  let li = document.createElement("li");
  let deleteBtn = document.createElement("button");
  deleteBtn.innerText = "Elimina";
  deleteBtn.addEventListener("click", function () {
    li.remove();
  });

  let value = document.getElementById("input").value;
  li.innerText = value;
  li.appendChild(deleteBtn);

  li.addEventListener("click", function () {
    li.classList.toggle("fatto");
  });

  document.querySelector("#target").append(li);
}
