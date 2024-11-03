<%--
  Created by IntelliJ IDEA.
  User: eduardo
  Date: 2/11/2024
  Time: 08:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Estrenos de Películas</title>
  <link rel="stylesheet" type="text/css" href="css/Menu5.css">
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

<div id="contenedor">
  <h1 class="centered-title">Estrenos de Películas</h1>

  <div id="pantalla">
    <div id="carrusel">
      <%-- Obtener la lista de imágenes de la carpeta "imagenes" --%>
      <%
        String rutaImagenes = "/img/";
        String[] nombresImagenes = {"Marvels.jpg","Five.jpg","Hambre.jpg", "Napoleon.jpg","Wonka.jpg"};
      %>

      <%-- Mostrar las imágenes en el carrusel --%>
      <% for (String nombreImagen : nombresImagenes) { %>
      <div class="pelicula">
        <img src="<%= rutaImagenes + nombreImagen %>" alt="<%= nombreImagen %>">
      </div>
      <% } %>
    </div>
  </div>
</div>

<script src="js/carrusel.js"></script>

</body>
</html>
