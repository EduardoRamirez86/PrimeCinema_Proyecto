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
  <title>Registro de Usuario</title>
</head>
<body>
<h2>Registro de Usuario</h2>
<form action="registrarUsuario" method="post">
  <label for="usuario">Usuario:</label>
  <input type="text" id="usuario" name="usuario" required><br><br>

  <label for="password">Contraseña:</label>
  <input type="password" id="password" name="password" required><br><br>

  <label for="nombre">Nombre:</label>
  <input type="text" id="nombre" name="nombre" required><br><br>

  <label for="apellido">Apellido:</label>
  <input type="text" id="apellido" name="apellido" required><br><br>

  <label for="dui">DUI:</label>
  <input type="text" id="dui" name="dui" required><br><br>

  <label for="direccion">Dirección:</label>
  <input type="text" id="direccion" name="direccion" required><br><br>

  <label for="correoElectronico">Correo Electrónico:</label>
  <input type="email" id="correoElectronico" name="correoElectronico" required><br><br>

  <label for="telefono">Teléfono:</label>
  <input type="text" id="telefono" name="telefono" required><br><br>

  <input type="submit" value="Registrar">
</form>
<br>
<a href="loginUsuario.jsp">Ya tengo cuenta. Iniciar sesión.</a>
</body>
</html>





