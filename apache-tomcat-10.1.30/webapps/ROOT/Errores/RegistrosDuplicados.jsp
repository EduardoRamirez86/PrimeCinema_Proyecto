<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error de Registro</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f1f1f1;
            text-align: center;
        }
        .container {
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            margin: 20px auto;
            padding: 20px;
            max-width: 400px;
        }
        h1 {
            color: #ff6347;
            letter-spacing: 5px;
        }
        p {
            color: #333;
            letter-spacing: 3px;

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
<div class="container">
    <h1>Error de Registro</h1>
    <p>El usuario o el DUI ya están duplicados. Por favor, intente de nuevo.</p>
    <div class="button-container">
        <a class="ok-button" href="../index.jsp">OK</a>
    </div>
</div>
</body>
</html>
