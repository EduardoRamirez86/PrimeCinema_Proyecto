<%--
  Created by IntelliJ IDEA.
  User: eduardo
  Date: 2/11/2024
  Time: 08:28
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu desplegable</title>
    <link rel="stylesheet" href="css/Menu2.css">
</head>
<body>
<nav class="menu">
    <section class="menu__container">
        <h1 class="menu__logo">Bienvenido PrimeCinema</h1>

        <ul class="menu__links">
            <li class="menu__item menu__item--show">
                <a href="cartelera.jsp" class="menu__link menu__link--inside">Cartelera</a>
            </li>
            <li class="menu__item menu__item--show">
                <a href="estrenos.jsp" class="menu__link menu__link--inside">Estrenos</a>
            </li>
            <li class="menu__item menu__item--show">
                <a href="listaSucursales.jsp" class="menu__link menu__link--inside">Sucursales</a>
            </li>
            <li class="menu__item menu__item--show">
                <a href="quienesSomos.jsp" class="menu__link menu__link--inside">Quienes Somos</a>
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

