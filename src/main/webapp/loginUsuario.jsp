<%--
  Created by IntelliJ IDEA.
  User: eduardo
  Date: 1/11/2024
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Iniciar Sesión de Usuario</title>
</head>
<body>
<h1>Iniciar Sesión de Usuario</h1>
<form action="loginUsuario" method="post">
  Usuario: <input type="text" name="usuario" required><br>
  Contraseña: <input type="password" name="password" required><br>
  <input type="submit" value="Iniciar Sesión">
</form>
<a href="registroUsuario.jsp">Registrar Usuario</a>
</body>
</html>

