<%--
  Created by IntelliJ IDEA.
  User: eduardo
  Date: 1/11/2024
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Login</title>
</head>
<body>
<h2>Login</h2>
<form action="login" method="post">
  <label for="login">Usuario:</label>
  <input type="text" id="login" name="login" required>
  <br>
  <label for="password">Contraseña:</label>
  <input type="password" id="password" name="password" required>
  <br>
  <button type="submit">Iniciar Sesión</button>
</form>

<c:if test="${not empty error}">
  <p style="color:red;">${error}</p>
</c:if>
</body>
</html>


