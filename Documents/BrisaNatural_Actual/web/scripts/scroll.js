function ocultar(){
document.getElementById('myBtn').style.display = 'none';
}
function mostrar(){
document.getElementById('myBtn').style.display = 'flex';
}

// Detectamos cuando el usuario desplace la pantalla
window.onscroll = function (){
    // Obtenemos la posicion del scroll en pantall
    var scroll = document.documentElement.scrollTop || document.body.scrollTop;

    // Realizamos alguna accion cuando el scroll este entre la posicion 300
    if(scroll > 300 && scroll < 10000000){
        mostrar();
    }
    else{
        ocultar();
    }
} 