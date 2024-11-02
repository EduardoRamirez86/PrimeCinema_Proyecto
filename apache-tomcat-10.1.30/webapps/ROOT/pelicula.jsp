<%--
  Created by IntelliJ IDEA.
  User: eduardo
  Date: 2/11/2024
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Pelicula" %>
<html>
<head>
    <title>Películas - Cinemaprime</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #007BFF;
            color: white;
        }
    </style>
</head>
<body>
<h1>Lista de Películas</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Género</th>
        <th>Clasificación</th>
        <th>Formato</th>
        <th>Valor Tercera Edad</th>
        <th>Valor Adulto</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Pelicula> peliculas = (List<Pelicula>) request.getAttribute("peliculas");
        for (Pelicula pelicula : peliculas) {
    %>
    <tr>
        <td><%= pelicula.getIdPelicula() %></td>
        <td><%= pelicula.getNombre() %></td>
        <td><%= pelicula.getGenero() %></td>
        <td><%= pelicula.getClasificacion() %></td>
        <td><%= pelicula.getFormato() %></td>
        <td><%= pelicula.getValorTerceraEdad() %></td>
        <td><%= pelicula.getValorAdulto() %></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<nav>
    <a href="index.jsp">Volver al inicio</a>
</nav>
</body>
</html>

