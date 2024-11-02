<%--
  Created by IntelliJ IDEA.
  User: eduardo
  Date: 2/11/2024
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/stylePelicula.css">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>
    <title>Bienvenido a mi Formulario</title>
</head>

<body>
<div class="container-form sign-up">
    <form class="formulario"  action="RegistroPeliculaServlet" method="post" onsubmit="return validarFormulario2()">
        <h2 class="create-account">Registro Pelicula</h2>
        <div class="iconos">
            <div class="border-icon">
                <i class='bx bxl-instagram'></i>
            </div>
            <div class="border-icon">
                <i class='bx bxl-linkedin' ></i>
            </div>
            <div class="border-icon">
                <i class='bx bxl-facebook-circle' ></i>
            </div>
        </div>
        <br>

        <br>
        <!-- Dentro de tu formulario -->
        <div id="errorContainer" style="display: none; color: red;">
            <p id="errorMessage"></p>
        </div>

        <input type="text" id="nombre" name="nombre" placeholder="Nombre de la película" ><br>

        <label for="genero">Género:</label>
        <select id="genero" name="genero" required>
            <option value="Acción">Acción</option>
            <option value="Comedia">Comedia</option>
            <option value="Drama">Drama</option>
            <option value="Ciencia ficción">Ciencia ficción</option>
            <!-- Agrega más géneros según tus necesidades -->
        </select><br>

        <label for="clasificacion">Clasificación:</label>
        <select id="clasificacion" name="clasificacion" required>
            <option value="A">Mayor de 18</option>
            <option value="AA">AAaaaaaaaa</option>
            <option value="B">B</option>
            <option value="B15">B15</option>
            <option value="C">C</option>
            <option value="D">D</option>
            <!-- Agrega más clasificaciones según tus necesidades -->
        </select><br>

        <label for="formato_proyeccion">Formato:</label>
        <select id="formato_proyeccion" name="formato_proyeccion">
            <option value="Tradicional">Tradicional</option>
            <option value="3D">3D</option>
        </select><br>

        <label for="precio_tercera_edad">Precio_tercera_edad: $</label>
        <input type="text" id="precio_tercera_edad" name="precio_tercera_edad" readonly><br>

        <label for="precio_adultos">Precio_adultos: $</label>
        <input type="text" id="precio_adultos" name="precio_adultos" readonly><br>

        <input type="submit" value="Registrar Película">



    </form>
</div>

<script>
    // JavaScript para actualizar los precios en función del formato de proyección seleccionado
    const formatoProyeccion = document.getElementById("formato_proyeccion");
    const precioTerceraEdad = document.getElementById("precio_tercera_edad");
    const precioAdultos = document.getElementById("precio_adultos");

    formatoProyeccion.addEventListener("change", () => {
        const selectedFormat = formatoProyeccion.value;
        if (selectedFormat === "Tradicional") {
            precioTerceraEdad.value = "3.90";
            precioAdultos.value = "5.00";
        } else if (selectedFormat === "3D") {
            precioTerceraEdad.value = "5.60";
            precioAdultos.value = "6.55";
        }
    });

    // Inicialmente, establece los precios para "Tradicional"
    precioTerceraEdad.value = "3.90";
    precioAdultos.value =  "5.00";
</script>
<script src="js/validaciones.js"></script>


</body>

</html>
