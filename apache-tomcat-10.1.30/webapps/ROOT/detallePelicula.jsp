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
    // Obtener los objetos de la solicitud
    Pelicula pelicula = (Pelicula) request.getAttribute("pelicula");
    Sala sala = (Sala) request.getAttribute("sala");
    Sucursal sucursal = (Sucursal) request.getAttribute("sucursal");

    // Verificar si la película está disponible
    if (pelicula != null) {
%>

<table class="detalle-pelicula">
    <tr>
        <th>Película:</th>
        <td><%= pelicula.getNombre() %></td>
    </tr>
    <tr>
        <th>Género:</th>
        <td><%= pelicula.getGenero() != null ? pelicula.getGenero() : "N/A" %></td>
    </tr>

    <% if (sala != null) { %>
    <tr>
        <th>Sala:</th>
        <td><%= sala.getNumeroSala() %></td> <!-- Sin comparación con null -->
    </tr>
    <% } else { %>
    <tr>
        <th>Sala:</th>
        <td>No asignada</td> <!-- Valor por defecto si sala es nulo -->
    </tr>
    <% } %>

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



