<%--
  Created by IntelliJ IDEA.
  User: eduardo
  Date: 2/11/2024
  Time: 09:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Cooperativa Shariff - Login</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body style="background-image: url('img/fondo2.jpg'); background-size: cover; background-repeat: no-repeat; background-position: center; height: 100vh; margin: 0;">
<nav class="navbar navbar-dark bg-dark fixed-top">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Prime Cinema</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasDarkNavbar" aria-controls="offcanvasDarkNavbar" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="offcanvas offcanvas-end text-bg-dark" tabindex="-1" id="offcanvasDarkNavbar" aria-labelledby="offcanvasDarkNavbarLabel">
      <div class="offcanvas-header">
        <h3 class="offcanvas-title" id="offcanvasDarkNavbarLabel">Menu</h3>
        <button type="button" class="btn-close btn-close-white" data-bs-dismiss="offcanvas" aria-label="Close"></button>
      </div>
      <div class="offcanvas-body">
        <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
          <li class="nav-item">
            <h5><a class="nav-link active" aria-current="page" href="#">Login</a></h5>
          </li>
          <li class="nav-item">
            <h6><a class="nav-link" href="#">Nosotros</a></h6>
          </li>
          <li class="nav-item">
            <h6><a class="nav-link" href="#">Contactanos</a></h6>
          </li>
        </ul>
      </div>
    </div>
  </div>
</nav>
<!--Fin Nav-->

<div class="container">
  <div class="row position-relative" style="height: 93.67vh;">
    <div class="col-6 p-4 position-absolute top-50 start-50 translate-middle" style="background-color: white; border-radius: 10px;">
      <form action="login" method="post">
        <h2 class="h3 mb-3 fw-normal">Iniciar Sesión</h2>

        <div class="form-floating mb-3">
          <input type="text" class="form-control" name="usuario" id="usuario" placeholder="Usuario" required>
          <label for="usuario">Usuario</label>
        </div>

        <div class="form-floating">
          <input type="password" class="form-control" name="password" id="password" placeholder="Contraseña" required>
          <label for="password">Contraseña</label>
        </div>

        <div class="mt-3 mb-3 form-check">
          <input type="checkbox" class="form-check-input" id="exampleCheck1">
          <label class="form-check-label" for="exampleCheck1">Recuérdame</label>
        </div>

        <button type="submit" class="btn btn-primary">Iniciar Sesión</button>

        <%-- Mostrar mensaje de error si existe --%>
        <%
          String error = (String) request.getAttribute("error");
          if (error != null) {
        %>
        <div class="alert alert-danger mt-3" role="alert">
          <%= error %>
        </div>
        <%
          }
        %>
      </form>
    </div>
  </div>
</div>
<!--Fin Contenido-->

<footer style="background-color: black;">
  <h1 style="color: transparent;">.</h1>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>


