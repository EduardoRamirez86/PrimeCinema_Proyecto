<%--
  Created by IntelliJ IDEA.
  User: eduardo
  Date: 2/11/2024
  Time: 09:12
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/styleLogin.css">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
  <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>
  <title>Bienvenido a mi Formulario</title>
</head>

<body>
<div class="container-form sign-up">
  <div class="welcome-back">
    <div class="message">
      <h2>Bienvenido a PrimeCinema</h2>
      <p>Si ya tienes una cuenta por favor inicia sesion aqui</p>
      <button class="sign-up-btn">Iniciar Sesion</button>
    </div>
  </div>
  <form class="formulario" action="registro" method="post" onsubmit="return validarFormulario1()">
    <h2 class="create-account">Crear una cuenta</h2>
    <div class="iconos">
      <div class="border-icon">
        <i class='bx bxl-instagram'></i>
      </div>
      <div class="border-icon">
        <i class='bx bxl-linkedin'></i>
      </div>
      <div class="border-icon">
        <i class='bx bxl-facebook-circle'></i>
      </div>
    </div>
    <p class="cuenta-gratis">Crear una cuenta gratis</p>
    <br>
    <br>
    <!-- Dentro de tu formulario -->
    <div id="errorContainer" style="display: none; color: red;">
      <p id="errorMessage"></p>
    </div>



    <input type="text" name="login" id="login" placeholder="Usuario" required>

    <input type="password" name="password" id="password" placeholder="Contraseña" required>

    <input type="text" name="nombre_Completo" id="nombre_Completo" placeholder="Nombre Completo" required>

    <input type="text" name="dui" id="dui" placeholder="DUI" required>

    <input type="text" name="direccion" id="direccion" placeholder="Direccion" required>

    <input type="email" name="email" id="email" placeholder="Correo Electrnico" required>

    <input type="text" name="telefono" id="telefono" placeholder="Telefono" required>
    <input type="submit" value="Registrarse">




  </form>

</div>

<div class="container-form sign-in"> <!-- Cambiado de 'sign-up' a 'sign-in' para que se muestre el formulario de inicio de sesión -->
  <form class="formulario" action="login" method="post">

    <h2 class="create-account">Iniciar Sesion</h2>
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
    <p class="cuenta-gratis">¿Aun no tienes una cuenta?</p>
    <input type="text" id="usuario" name="usuario" placeholder="Ingresa tu usuario" required>
    <input type="password" id="contrasenia" name="contrasenia" placeholder="Ingresa tu contraseña" required>
    <input type="submit" value="Iniciar Sesion">
  </form>
  <div class="welcome-back">
    <div class="message">
      <h2>Bienvenido de nuevo</h2>
      <p>Si aun no tienes una cuenta por favor registrarse aqui</p>
      <button class="sign-in-btn">Registrarse</button>
    </div>
  </div>
</div>

<script src="js/script.js"></script>
<script src="js/validaciones.js"></script>
</body>

</html>
