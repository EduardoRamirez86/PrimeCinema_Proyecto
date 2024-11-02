

<!DOCTYPE html>
<html>
<head>
    <title>Registro Exitoso</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url(https://i.gifer.com/OrYH.gif);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
            color: rgb(255, 246, 230);
        }
        #container {
            background-color: rgba(31, 29, 29, 0.602);
            border: 2px solid #000;
            padding: 20px;
            text-align: center;
        }
        h1 {

            color: rgb(255, 255, 255);
            -webkit-text-stroke: 2px #000;
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



    <h1>Detalle de Sucursal</h1>

    <c:if test="${not empty sucursal}">
        <p><strong>Nombre de Sucursal:</strong> ${sucursal.nombreSucursal}</p>
        <p><strong>Gerente:</strong> ${sucursal.gerente}</p>
        <p><strong>Direccion:</strong> ${sucursal.direccion}</p>
        <p><strong>Telefono:</strong> ${sucursal.telefono}</p>
    </c:if>


    <div class="button-container">
        <a class="ok-button" href="../menuEmpleado.jsp">OK</a>
    </div>
</div>
</body>
</html>
