
<!DOCTYPE html>
<html>
<head>
    <title>Registro Exitoso</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        #container {
            background-color: #fff;
            border: 2px solid #000;
            padding: 20px;
            text-align: center;
        }
        h1 {
            color: green;
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

    <c:if test="${not empty mensaje}">
        <p>${mensaje}</p>
    </c:if>

    <c:if test="${not empty usuario}">
        <h2>Datos del Usuario:</h2>
        <ul>
            <li><strong>Login:</strong> ${usuario.login}</li>
            <li><strong>Nombre Completo:</strong> ${usuario.nombreCompleto}</li>
            <li><strong>DUI:</strong> ${usuario.dui}</li>
            <li><strong>Dirección:</strong> ${usuario.direccion}</li>
            <li><strong>Correo Electrónico:</strong> ${usuario.correoElectronico}</li>
            <li><strong>Teléfono:</strong> ${usuario.telefono}</li>
        </ul>
    </c:if>

    <div class="button-container">
        <a class="ok-button" href="..//loginUsuario.jsp">OK</a>
    </div>
</div>
</body>
</html>
