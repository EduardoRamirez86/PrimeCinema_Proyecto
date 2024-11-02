<%--
  Created by IntelliJ IDEA.
  User: eduardo
  Date: 1/11/2024
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Iniciar Sesión - Usuario</title>
</head>
<body>
<h2>Iniciar Sesión - Usuario</h2>
<form action="loginUsuario" method="post">
  <label for="usuario">Usuario:</label>
  <input type="text" id="usuario" name="usuario" required><br><br>

  <label for="password">Contraseña:</label>
  <input type="password" id="password" name="password" required><br><br>

  <input type="submit" value="Iniciar Sesión">
</form>
<br>
<a href="registroUsuario.jsp">Crear una cuenta nueva.</a>
</body>
</html>


