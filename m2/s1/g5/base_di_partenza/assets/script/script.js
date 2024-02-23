window.addEventListener("scroll", function () {
  var navbar = document.getElementById("navbar");
  var scrollPosition = window.scrollY;

  if (scrollPosition > 300) {
    navbar.classList.add("sticky");
  } else {
    navbar.classList.remove("sticky");
  }
});
