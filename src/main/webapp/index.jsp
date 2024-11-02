<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://jakarta.apache.org/taglibs/standard" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista de Sucursales</title>
    <link rel="stylesheet" href="styles.css"> <!-- Si tienes un archivo CSS -->
</head>
<body>
<h1>Lista de Sucursales</h1>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Nombre de Sucursal</th>
        <th>Gerente</th>
        <th>Dirección</th>
        <th>Teléfono</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="sucursal" items="${listaSucursales}">
        <tr>
            <td>${sucursal.id}</td>
            <td>${sucursal.nombreSucursal}</td>
            <td>${sucursal.gerente}</td>
            <td>${sucursal.direccion}</td>
            <td>${sucursal.telefono}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<h2>Agregar Nueva Sucursal</h2>
<form action="sucursales" method="post">
    <label for="nombreSucursal">Nombre de Sucursal:</label>
    <input type="text" id="nombreSucursal" name="nombreSucursal" required>

    <label for="gerente">Gerente:</label>
    <input type="text" id="gerente" name="gerente" required>

    <label for="direccion">Dirección:</label>
    <input type="text" id="direccion" name="direccion" required>

    <label for="telefono">Teléfono:</label>
    <input type="text" id="telefono" name="telefono" required>

    <input type="submit" value="Agregar Sucursal">
</form>
</body>
</html>
