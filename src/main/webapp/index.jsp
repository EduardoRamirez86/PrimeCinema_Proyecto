<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Sucursal" %>

<html>
<head>
    <title>Lista de Sucursales</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        h1 {
            color: #333;
        }
        ul {
            list-style-type: none;
            padding: 0;
        }
        li {
            margin-bottom: 10px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .error {
            color: red;
        }
    </style>
</head>
<body>
<h1>Lista de Sucursales</h1>

<%
    List<Sucursal> sucursales = (List<Sucursal>) request.getAttribute("sucursales");
    String mensaje = (String) request.getAttribute("mensaje");

    // Si hay un mensaje de error, mostrarlo
    if (mensaje != null) {
%>
<p class="error"><strong><%= mensaje %></strong></p>
<%
} else if (sucursales != null && !sucursales.isEmpty()) {
%>
<ul>
    <% for (Sucursal sucursal : sucursales) { %>
    <li>
        <strong>Nombre:</strong> <%= sucursal.getNombreSucursal() %> <br>
        <strong>Gerente:</strong> <%= sucursal.getGerente() %> <br>
        <strong>Dirección:</strong> <%= sucursal.getDireccion() %> <br>
        <strong>Teléfono:</strong> <%= sucursal.getTelefono() %>
    </li>
    <% } %>
</ul>
<%
} else {
%>
<p>No se encontraron sucursales en la base de datos.</p>
<%
    }
%>
</body>
</html>






