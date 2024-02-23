window.addEventListener("scroll", function () {
  let navbar = document.getElementById("navbar");
  let button = document.getElementById("btn");
  let scrollPosition = window.scrollY;

  if (scrollPosition > 300) {
    navbar.classList.add("sticky");
    button.classList.add("green");
  } else {
    navbar.classList.remove("sticky");
    button.classList.remove("green");
  }
});
