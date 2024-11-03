<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Detalles de Película</title>
    <link rel="stylesheet" href="../css/Menu8.css">
</head>
<body>
<%
    Integer idPelicula = (Integer) session.getAttribute("idPelicula");
    Integer idSala = (Integer) session.getAttribute("idSala");
    Integer idUsuario = (Integer) session.getAttribute("idUsuario");

    // Proporciona valores predeterminados si algún atributo es nulo
    idPelicula = (idPelicula != null) ? idPelicula : -1;
    idSala = (idSala != null) ? idSala : -1;
    idUsuario = (idUsuario != null) ? idUsuario : -1;
%>

<p>ID de la Película: <%= idPelicula %></p>
<p>ID de la Sala: <%= idSala %></p>
<p>ID del Usuario: <%= idUsuario %></p>

<nav class="menu">
    <section class="menu__container">
        <h1 class="menu__logo">Bienvenido PrimeCinema</h1>

        <ul class="menu__links">
            <li class="menu__item menu__item--show">
                <a href="menuUsuario.jsp" class="menu__link menu__link--inside">Inicio</a>
            </li>
            <li class="menu__item menu__item--show">
                <a href="MostrarCarteleraServlet" class="menu__link menu__link--inside">Cartelera</a>
            </li>
            <li class="menu__item menu__item--show">
                <a href="estrenos.jsp" class="menu__link menu__link--inside">Estrenos</a>
            </li>
            <li class="menu__item menu__item--show">
                <a href="sucursal" class="menu__link menu__link--inside">Sucursales</a>
            </li>
            <li class="menu__item menu__item--show">
                <a href="quienesSomos.jsp" class="menu__link menu__link--inside">Quienes Somos</a>
            </li>
        </ul>

        <div class="menu__hamburguer">
            <img src="xd" class="menu__img">
        </div>
    </section>
</nav>

<h1 class="centered-title">Detalles de Película</h1>

<%
    // Obtén los datos de la película del atributo de la solicitud
    String nombre = (String) request.getAttribute("nombre");
    String genero = (String) request.getAttribute("genero");
    String clasificacion = (String) request.getAttribute("clasificacion");
    String formato = (String) request.getAttribute("formato");
    double valorTerceraEdad = (double) request.getAttribute("valorTerceraEdad");
    double valorAdulto = (double) request.getAttribute("valorAdulto");

    // Obtén los datos de la sucursal y la sala de la película del atributo de la solicitud
    String nombreSucursal = (String) request.getAttribute("nombreSucursal");
    int numeroSala = (int) request.getAttribute("numeroSala");
    String horario = (String) request.getAttribute("horario");

    // Verifica si se han encontrado datos de la película
    if (nombre != null) {
        // Construye la ruta de la imagen
        String rutaBaseImagenes = "img/peliculas/";
        String rutaImagen = rutaBaseImagenes + nombre + ".jpg";
%>

<table class="detalle-pelicula">
    <tr>
        <th></th>
        <td><img src="<%= rutaImagen %>" alt="Portada de <%= nombre %>" class="movie-image"></td>
    </tr>
    <tr>
        <th>Película:</th>
        <td><%= nombre %></td>
    </tr>
    <tr>
        <th>Género:</th>
        <td><%= genero %></td>
    </tr>
    <tr>
        <th>Clasificación:</th>
        <td><%= clasificacion %></td>
    </tr>
    <tr>
        <th>Formato:</th>
        <td><%= formato %></td>
    </tr>
    <tr>
        <th>Sucursal:</th>
        <td><%= nombreSucursal %></td>
    </tr>
    <tr>
        <th>Sala:</th>
        <td><%= numeroSala %></td>
    </tr>
    <tr>
        <th>Horario:</th>
        <td><%= horario %></td>
    </tr>
    <tr>
        <th>Valor Tercera Edad:</th>
        <td><%= valorTerceraEdad %></td>
        <td><a class="comprar-button" href="Butaca.jsp">Comprar</a></td>
    </tr>
    <tr>
        <th>Valor Adulto:</th>
        <td><%= valorAdulto %></td>
        <td><a class="comprar-button" href="Butaca.jsp">Comprar</a></td>
    </tr>
</table>
<%
} else {
%>
<p>La película seleccionada no se encontró en la base de datos.</p>
<%
    }
%>

<a class="volver-button" href="MostrarCarteleraServlet">Volver a la Cartelera</a>

</body>
</html>

