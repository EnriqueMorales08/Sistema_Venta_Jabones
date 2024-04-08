const faqs= document.querySelectorAll(".contp");
faqs.forEach((contp) => {
    contp.addEventListener("click", () => {
        contp.classList.toggle("active");
    });
});
 