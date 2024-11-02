<%@ page import="model.Sucursal" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Sucursales</title>
</head>
<body>
<h1>Lista de Sucursales</h1>
<c:if test="${not empty mensaje}">
    <p>${mensaje}</p>
</c:if>
<c:if test="${not empty sucursales}">
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nombre Sucursal</th>
            <th>Gerente</th>
            <th>Dirección</th>
            <th>Teléfono</th>
        </tr>
        <c:forEach var="sucursal" items="${sucursales}">
            <tr>
                <td>${sucursal.id}</td>
                <td>${sucursal.nombreSucursal}</td>
                <td>${sucursal.gerente}</td>
                <td>${sucursal.direccion}</td>
                <td>${sucursal.telefono}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>




