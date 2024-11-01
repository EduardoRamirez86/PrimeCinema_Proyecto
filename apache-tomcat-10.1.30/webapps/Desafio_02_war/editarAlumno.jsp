<%--
  Created by IntelliJ IDEA.
  User: eduardo
  Date: 25/9/2024
  Time: 09:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Editar Alumno</h1>

<form action="alumnos" method="post">
    <input type="hidden" name="action" value="actualizar">
    <input type="hidden" name="carnet" value="${alumno.carnet}">

    <label for="nombre">Nombre:</label>
    <input type="text" id="nombre" name="nombre" value="${alumno.nombre}" required><br>

    <label for="apellidos">Apellidos:</label>
    <input type="text" id="apellidos" name="apellidos" value="${alumno.apellidos}" required><br>

    <label for="fechaNacimiento">Fecha de Nacimiento:</label>
    <input type="date" id="fechaNacimiento" name="fechaNacimiento" value="${alumno.fecha_nacimiento}" required><br>

    <label for="direccion">Dirección:</label>
    <input type="text" id="direccion" name="direccion" value="${alumno.direccion}" required><br>

    <input type="submit" value="Actualizar">
</form>

<a href="alumnos?action=listar">Volver a la lista</a>
</body>
</html>
