<%@ page import="model.Usuario" %>
<%@ page session="true" %>
<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    if (usuario == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Bienvenido</title>
</head>
<body>
<h2>Bienvenido, <%= usuario.getNombreCompleto() %></h2>
<p>ID de Usuario: <%= usuario.getId() %></p>
<p>Correo Electrónico: <%= usuario.getCorreoElectronico() %></p>
<p><a href="logout">Cerrar Sesión</a></p>
</body>
</html>
