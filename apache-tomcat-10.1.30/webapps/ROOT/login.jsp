<%--
  Created by IntelliJ IDEA.
  User: eduardo
  Date: 2/11/2024
  Time: 09:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Login</title>
  <link rel="stylesheet" type="text/css" href="styles.css"> <!-- Enlaza a tu archivo CSS si tienes -->
</head>
<body>
<div class="login-container">
  <h2>Iniciar Sesión</h2>

  <form action="login" method="post">
    <div class="form-group">
      <label for="usuario">Usuario:</label>
      <input type="text" id="usuario" name="usuario" required>
    </div>

    <div class="form-group">
      <label for="password">Contraseña:</label>
      <input type="password" id="password" name="password" required>
    </div>

    <button type="submit">Iniciar Sesión</button>
  </form>

  <c:if test="${not empty param.error}">
    <div class="error-message">
      <p>${param.error}</p> <!-- Mostrar mensaje de error -->
    </div>
  </c:if>
</div>
</body>
</html>

