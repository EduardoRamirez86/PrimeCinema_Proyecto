<%--
  Created by IntelliJ IDEA.
  User: eduardo
  Date: 24/9/2024
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Conexiones.MateriaDAO, Conexiones.Materia" %>
<%@ page import="java.util.List" %>
<%
  MateriaDAO materiaDAO = new MateriaDAO();
  List<Materia> materias = materiaDAO.listarMaterias();
%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Gestión de Materias</title>
</head>
<body>
<h1>Gestionar Materias</h1>
<form action="materiaServlet" method="post">
  <h2>Registrar Materia</h2>
  Código: <input type="text" name="codigo"><br>
  Nombre: <input type="text" name="nombre"><br>
  Descripción: <input type="text" name="descripcion"><br>
  Fecha de Creación: <input type="date" name="fecha_creacion"><br>
  <input type="submit" value="Registrar">
</form>

<h2>Lista de Materias</h2>
<table border="1">
  <tr>
    <th>Código</th>
    <th>Nombre</th>
    <th>Descripción</th>
    <th>Fecha de Creación</th>
    <th>Acciones</th>
  </tr>
  <%
    for (Materia materia : materias) {
  %>
  <tr>
    <td><%= materia.getCodigoMateria() %></td>
    <td><%= materia.getNombre() %></td>
    <td><%= materia.getDescripcion() %></td>
    <td><%= materia.getFechaCreacion() %></td>
    <td>
      <a href="materiaServlet?action=editar&codigo=<%= materia.getCodigoMateria() %>">Editar</a>
      <a href="materiaServlet?action=eliminar&codigo=<%= materia.getCodigoMateria() %>">Eliminar</a>
    </td>
  </tr>
  <%
    }
  %>
</table>
</body>
</html>

