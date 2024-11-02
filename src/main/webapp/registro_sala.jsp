
<%--
  Created by IntelliJ IDEA.
  User: eduardo
  Date: 2/11/2024
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.sql.Connection, java.sql.PreparedStatement, java.sql.ResultSet, java.sql.SQLException" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Pelicula" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Sucursal" %>
<%@ page import="model.Conexion" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/styleSala.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
            href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap"
            rel="stylesheet"
    />
    <link
            href="https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css"
            rel="stylesheet"
    />
    <title>Bienvenido a mi Formulario salita</title>
</head>
<%
    List<Pelicula> peliculas = new ArrayList<>();
    List<Sucursal> sucursales = new ArrayList<>();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        // Obtener la conexión a la base de datos
        conn = Conexion.ConectarBD("cinemaprime");  // Asegúrate de usar el nombre correcto de la base de datos

        // Obtener la lista de películas
        String consultaPeliculas = "SELECT idPelicula, nombre FROM peliculas";
        ps = conn.prepareStatement(consultaPeliculas);
        rs = ps.executeQuery();

        while (rs.next()) {
            Pelicula pelicula = new Pelicula();
            pelicula.setIdPelicula(rs.getInt("idPelicula"));
            pelicula.setNombre(rs.getString("nombre"));
            peliculas.add(pelicula);
        }

        // Obtener la lista de sucursales
        String consultaSucursales = "SELECT id, nombreSucursal FROM sucursales";
        ps = conn.prepareStatement(consultaSucursales);
        rs = ps.executeQuery();

        while (rs.next()) {
            Sucursal sucursal = new Sucursal();
            sucursal.setIdSucursal(rs.getInt("idSucursal"));
            sucursal.setNombreSucursal(rs.getString("nombreSucursal"));
            sucursales.add(sucursal);
        }

        // Establecer los datos en el alcance de solicitud
        request.setAttribute("peliculas", peliculas);
        request.setAttribute("sucursales", sucursales);

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Cerrar la conexión usando el método Desconectar de la clase Conexion
        Conexion.Desconectar(conn);
    }
%>

<body>



<div class="container-form sign-up">
    <form class="formulario" action="registro-sala" method="post" onsubmit="return validarFormulario3()">
        <h2 class="create-account">Registro Sala</h2>
        <div class="iconos">
            <div class="border-icon">
                <i class="bx bxl-instagram"></i>
            </div>
            <div class="border-icon">
                <i class="bx bxl-linkedin"></i>
            </div>
            <div class="border-icon">
                <i class="bx bxl-facebook-circle"></i>
            </div>
        </div>
        <br>

        <br>
        <!-- Dentro de tu formulario -->
        <div id="errorContainer" style="display: none; color: red;">
            <p id="errorMessage"></p>
        </div>

        <label for="numeroSala">Número de Sala:</label>
        <input type="number" id="numeroSala" name="numeroSala" required /><br />

        <label for="idSucursal">Sucursal:</label>
        <select id="idSucursal" name="idSucursal" required>
            <c:forEach items="${sucursales}" var="sucursal">
                <option value="${sucursal.idSucursal}">${sucursal.nombreSucursal}</option>
            </c:forEach>
        </select><br/>

        <label for="idPelicula">Película:</label>
        <select id="idPelicula" name="idPelicula" required>
            <c:forEach items="${peliculas}" var="pelicula">
                <option value="${pelicula.idPelicula}">${pelicula.nombre}</option>
            </c:forEach></select
        ><br />

        <label for="horarioProyeccion" class="horarioProyeccion">Horario de Proyección (HH:MM:SS):</label>
        <input
                type="text"
                id="horarioProyeccion"
                name="horarioProyeccion"
                required
        /><br />

        <label for="fechaProyeccion">Fecha de Proyección (YY-MM-DD):</label>
        <input type="text" id="fechaProyeccion" name="fechaProyeccion" required><br>


        <input type="submit" value="Registrar Sala" />



    </form>
</div>
<script src="js/validaciones.js"></script>
</body>
</html>
