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
  <title>Registro de Empleado</title>
</head>
<body>
<h1>Registro de Empleado</h1>
<form action="registrarEmpleado" method="post">
  <label for="usuario">Nombre de Usuario:</label><br>
  <input type="text" id="usuario" name="usuario" required><br>

  <label for="contrasenia">Contraseña:</label><br>
  <input type="password" id="contrasenia" name="contrasenia" required><br>

  <label for="nombre">Nombre:</label><br>
  <input type="text" id="nombre" name="nombre" required><br>

  <label for="apellido">Apellido:</label><br>
  <input type="text" id="apellido" name="apellido" required><br>

  <label for="dui">DUI:</label><br>
  <input type="text" id="dui" name="dui" required><br>

  <label for="fechaNacimiento">Fecha de Nacimiento:</label><br>
  <input type="date" id="fechaNacimiento" name="fechaNacimiento" required><br>

  <label for="direccion">Dirección:</label><br>
  <input type="text" id="direccion" name="direccion" required><br>

  <label for="correo">Correo Electrónico:</label><br>
  <input type="email" id="correo" name="correo" required><br>

  <label for="telefono">Teléfono:</label><br>
  <input type="text" id="telefono" name="telefono" required><br><br>

  <input type="submit" value="Registrar Empleado">
</form>
</body>
</html>



