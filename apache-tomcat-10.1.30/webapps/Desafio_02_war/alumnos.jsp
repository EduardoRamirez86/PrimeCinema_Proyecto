<%--
  Created by IntelliJ IDEA.
  User: eduardo
  Date: 24/9/2024
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*, Conexiones.Conexion" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Alumno</title>
</head>
<body>
<h1>Lista de Alumnos</h1>

<table border="1">
    <tr>
        <th>Carnet</th>
        <th>Nombre</th>
        <th>Apellidos</th>
        <th>Fecha de Nacimiento</th>
        <th>Dirección</th>
        <th>Acciones</th>
    </tr>
    <c:forEach var="alumno" items="${alumnos}">
        <tr>
            <td>${alumno.carnet}</td>
            <td>${alumno.nombre}</td>
            <td>${alumno.apellidos}</td>
            <td>${alumno.fecha_nacimiento}</td>
            <td>${alumno.direccion}</td>
            <td>
                <a href="alumnos?action=editar&carnet=${alumno.carnet}">Editar</a> |
                <a href="alumnos?action=eliminar&carnet=${alumno.carnet}">Eliminar</a>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="registrarAlumno.jsp">Registrar Alumno</a>

</body>
</html>

