<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/estiloDetallePelicula.css">
    <title>Detalles de Película</title>
</head>
<body>
<h1>Detalles de Película</h1>

<%
    // Obtén los datos de la película del atributo de la solicitud
    String nombre = (String) request.getAttribute("nombre");
    String genero = (String) request.getAttribute("genero");
    String clasificacion = (String) request.getAttribute("clasificacion");
    String formato = (String) request.getAttribute("formato");
    double valorTerceraEdad = (double) request.getAttribute("valor_tercera_edad");
    double valorAdulto = (double) request.getAttribute("valor_adulto");


    int idPelicula = (int) session.getAttribute("idPelicula");


    // Verifica si se han encontrado datos de la película
    if (nombre != null) {
%>

<p>ID del Usuario: ${idUsuario}</p>
<p>ID pelicula: <%= idPelicula %></p>


<table class="detalle-pelicula">
    <tr>
        <th>Nombre:</th>
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
        <th>Valor Tercera Edad:</th>
        <td><%= valorTerceraEdad %></td>
        <td><a class="comprar-button" href="../Butaca.jsp">Comprar</a></td>
    </tr>
    <tr>
        <th>Valor Adulto:</th>
        <td><%= valorAdulto %></td>
        <td><a class="comprar-button">Comprar</a></td>
    </tr>
</table>
<%
} else {
%>
<p>La película seleccionada no se encontró en la base de datos.</p>
<%
    }
%>

<a class="volver-button" href="../cartelera.jsp">Volver a la Cartelera</a>

</body>
</html>
