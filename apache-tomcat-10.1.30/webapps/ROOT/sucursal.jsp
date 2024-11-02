<%--
  Created by IntelliJ IDEA.
  User: eduardo
  Date: 2/11/2024
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Sucursal" %>
<html>
<head>
  <title>Gestión de Sucursales - Cinemaprime</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
      margin: 0;
      padding: 20px;
    }
    h1 {
      color: #333;
    }
    table {
      width: 100%;
      border-collapse: collapse;
      margin-top: 20px;
    }
    th, td {
      padding: 10px;
      text-align: left;
      border: 1px solid #ddd;
    }
    th {
      background-color: #007BFF;
      color: white;
    }
    a.button {
      text-decoration: none;
      padding: 8px 12px;
      color: white;
      background-color: #28a745;
      border-radius: 4px;
      margin-top: 10px;
      display: inline-block;
    }
    a.button-danger {
      background-color: #dc3545;
    }
  </style>
</head>
<body>

<h1>Gestión de Sucursales</h1>
<a href="agregarSucursal.jsp" class="button">Agregar Sucursal</a>

<table>
  <thead>
  <tr>
    <th>ID</th>
    <th>Nombre Sucursal</th>
    <th>Gerente</th>
    <th>Dirección</th>
    <th>Teléfono</th>
    <th>Acciones</th>
  </tr>
  </thead>
  <tbody>
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
  </tbody>
</table>

<nav>
  <a href="index.jsp">Volver al inicio</a>
</nav>

</body>
</html>


