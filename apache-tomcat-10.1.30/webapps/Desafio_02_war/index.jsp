<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Gestión Universitaria</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h1 {
            color: #2c3e50;
        }
        nav ul {
            list-style-type: none;
            padding: 0;
        }
        nav ul li {
            margin: 10px 0;
        }
        nav ul li a {
            text-decoration: none;
            color: #3498db;
        }
        nav ul li a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<h1>Gestión Universitaria</h1>
<nav>
    <ul>
        <li><a href="alumnos.jsp">Gestionar Alumnos</a></li>
        <li><a href="materias.jsp">Gestionar Materias</a></li>
        <li><a href="inscripciones.jsp">Gestionar Inscripciones</a></li>
        <li><a href="registrarAlumno.jsp">Registrar Alumno</a></li>
    </ul>
</nav>
</body>
</html>


