// Configuración del carrusel con JavaScript
let carrusel = document.getElementById("carrusel");
let peliculas = document.querySelectorAll(".pelicula");
let index = 0;

function mostrarSiguientePelicula() {
    index = (index + 1) % peliculas.length;
    carrusel.style.transform = "translateX(" + (-index * 300) + "px)";
}

setInterval(mostrarSiguientePelicula, 3000); // Cambiar de película cada 3 segundos
