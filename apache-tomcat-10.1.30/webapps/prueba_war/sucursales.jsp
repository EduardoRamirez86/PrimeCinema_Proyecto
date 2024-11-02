<%@ page import="model.Sucursal" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Sucursal" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Lista de Sucursales</title>
  <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="container">
  <h2>Lista de Sucursales</h2>
  <a href="agregarSucursal.jsp" class="btn btn-success">Agregar Sucursal</a>
  <table class="table table-striped">
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
      for (Sucursal sucursal : sucursales) {
    %>
    <tr>
      <td><%= sucursal.getId() %></td>
      <td><%= sucursal.getNombreSucursal() %></td>
      <td><%= sucursal.getGerente() %></td>
      <td><%= sucursal.getDireccion() %></td>
      <td><%= sucursal.getTelefono() %></td>
      <td>
        <a href="SucursalServlet?action=edit&id=<%= sucursal.getId() %>" class="btn btn-warning">Editar</a>
        <a href="SucursalServlet?action=delete&id=<%= sucursal.getId() %>" class="btn btn-danger" onclick="return confirm('¿Estás seguro de que deseas eliminar esta sucursal?');">Eliminar</a>
      </td>
    </tr>
    <%
      }
    %>
    </tbody>
  </table>
</div>
</body>
</html>

