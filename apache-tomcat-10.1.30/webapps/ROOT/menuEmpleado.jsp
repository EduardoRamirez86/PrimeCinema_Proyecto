<%--
  Created by IntelliJ IDEA.
  User: eduardo
  Date: 2/11/2024
  Time: 08:45
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Menu desplegable</title>
  <link rel="stylesheet" href="css/Menu1.css">
</head>
<body>
<nav class="menu">
  <section class="menu__container">
    <h1 class="menu__logo">Bienvenido PrimeCinema</h1>

    <ul class="menu__links">


      <li class="menu__item menu__item--show">
        <a href="#" class="menu__link">Registros <img src="assets/arrow.svg" class="menu__arrow"></a>

        <ul class="menu__nesting">
          <li class="menu__inside">
            <a href="registro_sala.jsp" class="menu__link menu__link--inside">Registro Sala</a>
          </li>
          <li class="menu__inside">
            <a href="registro_sucursal.jsp" class="menu__link menu__link--inside">Registro Sucursal</a>
          </li>
          <li class="menu__inside">
            <a href="registro_pelicula.jsp" class="menu__link menu__link--inside">Registro Pelicula</a>
          </li>
          <li class="menu__inside">
            <a href="sucursal" class="menu__link menu__link--inside">Registro Butaca</a>
          </li>
        </ul>
      </li>

      <li class="menu__item  menu__item--show">
        <a href="#" class="menu__link">Reportes  <img src="" class="menu__arrow"></a>

        <ul class="menu__nesting">
          <li class="menu__inside">
            <a href="reporteSucursal.jsp" class="menu__link menu__link--inside">Reporte Sucursal</a>
          </li>
          <li class="menu__inside">
            <a href="reporteSala.jsp" class="menu__link menu__link--inside">Reporte Sala</a>
          </li>

        </ul>
      </li>

      <li class="menu__item">
        <a href="#" class="menu__link">Salir</a>
      </li>

    </ul>

    <div class="menu__hamburguer">
      <img src="xd" class="menu__img">
    </div>
  </section>

  <div class="slider-container">
    <div class="slider position">
      <h2>¡Disfruta de tu experiencia en PrimeCinema!</h2>
      <h2>Explora el menú y realiza tus tareas con facilidad</h2>
    </div>
  </div>

</nav>

<script src="js/Menu.js"></script>
</body>
</html>
