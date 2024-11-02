<%--
  Created by IntelliJ IDEA.
  User: eduardo
  Date: 2/11/2024
  Time: 09:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="controller.ObtenerSucursalServlet" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Sucursal" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Lista de Sucursales</title>
  <link rel="stylesheet" href="css/Menu3.css">
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
        <a href="ObtenerSucursalServlet" class="menu__link menu__link--inside">Sucursales</a>
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
<h1 class="centered-title">Lista de Sucursales</h1>
<div class="sucursales-container">
  <ul>
    <%
      // Obtén la lista de sucursales del atributo de solicitud
      List<Sucursal> sucursales = (List<Sucursal>) request.getAttribute("sucursales");

      // Verifica si la lista de sucursales no está vacía
      if (sucursales != null && !sucursales.isEmpty()) {
        for (Sucursal sucursal : sucursales) {
    %>
    <li class="sucursal-item">
      <strong>Nombre de Sucursal:</strong> <%= sucursal.getNombreSucursal() %><br>
      <strong>Gerente:</strong> <%= sucursal.getGerente() %><br>
      <strong>Dirección:</strong> <%= sucursal.getDireccion() %><br>
      <strong>Teléfono:</strong> <%= sucursal.getTelefono() %><br>
    </li>
    <%
      }
    } else {
    %>
    <li>No hay sucursales disponibles.</li>
    <%
      }
    %>
  </ul>
</div>
</body>
</html>
