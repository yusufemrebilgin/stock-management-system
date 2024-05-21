const sidebarBtn = document.querySelector(".toggle-btn");

sidebarBtn.addEventListener("click", function () {
    document.querySelector("#sidebar").classList.toggle("expand");
});