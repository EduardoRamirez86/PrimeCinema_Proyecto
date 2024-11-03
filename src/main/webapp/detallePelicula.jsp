<%@ page import="model.Pelicula" %>
<%@ page import="model.Sala" %>
<%@ page import="model.Sucursal" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Detalles de Película</title>
    <link rel="stylesheet" href="css/Menu4.css">
</head>
<body>

<h1 class="centered-title">Detalles de Película</h1>

<%
    // Obtener los datos de la película del atributo de la solicitud
    Pelicula pelicula = (Pelicula) request.getAttribute("pelicula");
    Sala sala = (Sala) request.getAttribute("sala");
    Sucursal sucursal = (Sucursal) request.getAttribute("sucursal");

    if (pelicula != null) {
        // Construye la ruta de la imagen
        String rutaBaseImagenes = "img/peliculas/";
        String rutaImagen = rutaBaseImagenes + pelicula.getNombre().replaceAll(" ", "_") + ".jpg"; // Reemplaza espacios por guiones bajos
%>

<table class="detalle-pelicula">
    <tr>
        <th>Portada:</th>
        <td><img src="<%= rutaImagen %>" alt="Portada de <%= pelicula.getNombre() %>" class="movie-image"></td>
    </tr>
    <tr>
        <th>Película:</th>
        <td><%= pelicula.getNombre() %></td>
    </tr>
    <tr>
        <th>Género:</th>
        <td><%= pelicula.getGenero() != null ? pelicula.getGenero() : "N/A" %></td>
    </tr>
    <tr>
        <th>Clasificación:</th>
        <td><%= pelicula.getClasificacion() != null ? pelicula.getClasificacion() : "N/A" %></td>
    </tr>
    <tr>
        <th>Formato:</th>
        <td><%= pelicula.getFormato() != null ? pelicula.getFormato() : "N/A" %></td>
    </tr>

    <% if (sala != null) { %>
    <tr>
        <th>Sala:</th>
        <td><%= sala.getNumeroSala() %></td>
    </tr>
    <% } else { %>
    <tr>
        <th>Sala:</th>
        <td>No asignada</td>
    </tr>
    <% } %>

    <% if (sucursal != null) { %>
    <tr>
        <th>Sucursal:</th>
        <td><%= sucursal.getNombreSucursal() %></td>
    </tr>
    <% } else { %>
    <tr>
        <th>Sucursal:</th>
        <td>No asignada</td>
    </tr>
    <% } %>

    <!-- Valores para comprar -->
    <tr>
        <th>Valor Tercera Edad:</th>
        <% int valorTerceraEdad = (int) pelicula.getValorTerceraEdad(); %> <!-- Asumiendo que es int -->
        <td><%= valorTerceraEdad > 0 ? valorTerceraEdad : "N/A" %></td>
        <% if (valorTerceraEdad > 0) { %>
        <td><a class="comprar-button" href="Butaca.jsp?tipo=terceraEdad&valor=<%= valorTerceraEdad %>">Comprar</a></td>
        <% } else { %>
        <td>N/A</td>
        <% } %>
    </tr>

    <tr>
        <th>Valor Adulto:</th>
        <% int valorAdulto = (int) pelicula.getValorAdulto(); %> <!-- Asumiendo que es int -->
        <td><%= valorAdulto > 0 ? valorAdulto : "N/A" %></td>
        <% if (valorAdulto > 0) { %>
        <td><a class="comprar-button" href="Butaca.jsp?tipo=adulto&valor=<%= valorAdulto %>">Comprar</a></td>
        <% } else { %>
        <td>N/A</td>
        <% } %>
    </tr>

</table>

<%
} else {
%>
<p>No se encontró la película seleccionada.</p>
<%
    }
%>

<a class="volver-button" href="MostrarCarteleraServlet">Volver a la Cartelera</a>

</body>
</html>


