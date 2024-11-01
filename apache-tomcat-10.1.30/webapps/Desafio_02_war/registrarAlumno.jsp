<%--
  Created by IntelliJ IDEA.
  User: eduardo
  Date: 25/9/2024
  Time: 00:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*, Conexiones.Conexion" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Agregar Alumno</title>
</head>
<body>
<h1>Registrar Alumno</h1>

<form action="alumnos" method="post">
  <input type="hidden" name="action" value="registrar">
  <label for="carnet">Carnet:</label>
  <input type="text" id="carnet" name="carnet" required><br>

  <label for="nombre">Nombre:</label>
  <input type="text" id="nombre" name="nombre" required><br>

  <label for="apellidos">Apellidos:</label>
  <input type="text" id="apellidos" name="apellidos" required><br>

  <label for="fechaNacimiento">Fecha de Nacimiento:</label>
  <input type="date" id="fechaNacimiento" name="fechaNacimiento" required><br>

  <label for="direccion">Dirección:</label>
  <input type="text" id="direccion" name="direccion" required><br>

  <input type="submit" value="Registrar">
</form>

<a href="alumnos?action=listar">Volver a la lista</a>

</body>
</html>

