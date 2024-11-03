<%--
  Created by IntelliJ IDEA.
  User: eduardo
  Date: 2/11/2024
  Time: 09:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="controller.SucursalServlet" %>
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
<h1 class="centered-title">Lista de Sucursales</h1>
<div class="sucursales-container">
  <ul>
    <%
      List<Sucursal> sucursales = (List<Sucursal>) request.getAttribute("sucursales");
      if (sucursales != null && !sucursales.isEmpty()) {
        for (Sucursal sucursal : sucursales) {
    %>
    <tr>
      <td><%= sucursal.getIdSucursal() %></td>
      <td><%= sucursal.getNombreSucursal() %></td>
      <td><%= sucursal.getGerente() %></td>
      <td><%= sucursal.getDireccion() %></td>
      <td><%= sucursal.getTelefono() %></td>
      <td>
        <a href="SucursalServlet?action=edit&id=<%= sucursal.getIdSucursal() %>" class="button">Editar</a>
        <a href="SucursalServlet?action=delete&id=<%= sucursal.getIdSucursal() %>" class="button button-danger" onclick="return confirm('¿Estás seguro de eliminar esta sucursal?');">Eliminar</a>
      </td>
    </tr>
    <%
      }
    } else {
    %>
    <tr>
      <td colspan="6">No hay sucursales registradas.</td>
    </tr>
    <%
      }
    %>
  </ul>
</div>
</body>
</html>
