const usuario= document.querySelectorAll(".fauser");
const usuarioc= document.querySelectorAll(".user");

usuario.forEach((fauser) => {
    fauser.addEventListener("click", () => {
        usuarioc.forEach((user) => {
        user.classList.toggle("active");
        });
    });
});
