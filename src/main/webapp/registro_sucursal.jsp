<%--
  Created by IntelliJ IDEA.
  User: eduardo
  Date: 2/11/2024
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/styleSucursal.css">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
  <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>
  <title>Bienvenido a mi Formulario</title>
</head>

<body>
<div class="container-form sign-up">

  <form class="formulario"  action="registrar-sucursal" method="post" onsubmit="return validarFormulario4()">
    <h2 class="create-account">Registro Sucursal</h2>
    <div class="iconos">
      <div class="border-icon">
        <i class='bx bxl-instagram'></i>
      </div>
      <div class="border-icon">
        <i class='bx bxl-linkedin' ></i>
      </div>
      <div class="border-icon">
        <i class='bx bxl-facebook-circle' ></i>
      </div>
    </div>
    <br>
    <br>
    <!-- Dentro de tu formulario -->
    <div id="errorContainer" style="display: none; color: red;">
      <p id="errorMessage"></p>
    </div>
    <input type="text" placeholder="Nombre de Sucursal"  id="nombre_sucursal" name="nombre_sucursal" required>
    <input type="text" placeholder="Nombre de Gerente"  id="gerente" name="gerente" required>
    <input type="text" placeholder="Direccion de Sucursal"  id="direccion" name="direccion" required>
    <input type="text" placeholder="Telefono de Sucursal" id="telefono" name="telefono" required>

    <input type="submit" value="Registrar Sucursal">


  </form>
</div>

<script src="js/validaciones.js"></script>
</body>

</html>
