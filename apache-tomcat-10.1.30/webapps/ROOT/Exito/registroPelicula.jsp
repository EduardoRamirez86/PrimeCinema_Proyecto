
<!DOCTYPE html>
<html>
<head>
    <title>Registro Exitoso</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url(https://i.gifer.com/4APT.gif);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
            color: rgb(253, 246, 232);
        }
        #container {
            background-color: rgba(17, 15, 15, 0.602);
            border: 2px solid #000;
            padding: 20px;
            text-align: center;
        }
        h1{
            -webkit-text-stroke: 2px #000;
            color: white;
        }
        ul {
            list-style-type: none;
            padding: 0;
        }
        li {
            margin-bottom: 20px;
        }
        .button-container {
            margin-top: 20px;
        }
        .ok-button {
            background-color: #4caf50;
            border: none;
            color: white;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div id="container">
    <h1>Registro Exitoso</h1>

    <c:if test="${not empty pelicula}">

        <ul>
            <li><strong>Nombre de la Pelicula:</strong> ${pelicula.nombre}</li>
            <li><strong>Genero:</strong> ${pelicula.genero}</li>
            <li><strong>Clasificacion:</strong> ${pelicula.clasificacion}</li>
            <li><strong>Formato de Proyeccion:</strong> ${pelicula.formato}</li>
            <li><strong>Valor Tercera Edad:</strong> $${pelicula.valorTerceraEdad}</li>
            <li><strong>Valor Adulto:</strong> $${pelicula.valorAdulto}</li>
        </ul>
    </c:if>
    <div class="button-container">
        <a class="ok-button" href="../menuEmpleado.jsp">OK</a>
    </div>
</div>
</body>
</html>
