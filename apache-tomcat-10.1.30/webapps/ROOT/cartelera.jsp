<%--
  Created by IntelliJ IDEA.
  User: eduardo
  Date: 2/11/2024
  Time: 08:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.*" %>
<%@ page import="model.Conexion" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Cartelera de CinemaPrime</title>
  <link rel="stylesheet" href="css/Menu4.css">
</head>
<body>
<nav class="menu">
  <section class="menu__container">
    <h1 class="menu__logo">Bienvenido PrimeCinema</h1>

    <ul class="menu__links">
      <li class="menu__item menu__item--show">
        <a href="menuUsuario.jsp" class="menu__link menu__link--inside">Inicio</a>
      </li>
      <li class="menu__item menu__item--show">
        <a href="cartelera.jsp" class="menu__link menu__link--inside">Cartelera</a>
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
<h1 class="centered-title">Cartelera de CinemaPrime</h1>
<table class="cartelera">
  <tr>
    <th>Película</th>
    <th>Acción</th>
  </tr>
  <%
    Connection conexion = null;
    PreparedStatement statement = null;
    try {
      conexion = Conexion.ConectarBD("cinemaprime");
      String consulta = "SELECT nombre FROM peliculas"; // Ajusta según tu consulta
      statement = conexion.prepareStatement(consulta);
      ResultSet resultado = statement.executeQuery();

      while (resultado.next()) {
  %>
  <tr>
    <td><%= resultado.getString("nombre") %></td>
    <td>
      <form action="DetallePeliculaServlet" method="post">
        <input type="hidden" name="pelicula" value="<%= URLEncoder.encode(resultado.getString("nombre"), "UTF-8") %>">
        <input type="submit" value="Comprar">
      </form>
    </td>
  </tr>
  <%
      }
      statement.close();
      conexion.close();
    } catch (SQLException e) {
      e.printStackTrace();
      request.setAttribute("errorMessage", "Error al acceder a la base de datos.");
      // Redirigir o mostrar el mensaje de error en el JSP
    }
  %>
</table>

</table>
</body>
</html>
