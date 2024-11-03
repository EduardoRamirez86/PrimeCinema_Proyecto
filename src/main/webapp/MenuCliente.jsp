<%--
  Created by IntelliJ IDEA.
  User: eduardo
  Date: 3/11/2024
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="controller.*" %>
<%@ page import="model.Pelicula" %>
<%@ page import="model.Usuario" %>

<%
    ArrayList<Pelicula> peliculas = (ArrayList<Pelicula>) request.getAttribute("peliculas");
    Usuario cliente = (Usuario) session.getAttribute("Usuario");
    if (cliente != null || peliculas != null) {
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cooperativa Shariff</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body style="background-color: aliceblue;">
<nav class="navbar navbar-dark bg-dark fixed-top">
    <div class="container-fluid">
        <a class="navbar-brand" href="MenuCliente.html">Prime Cinema</a>
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
                        <h5><a class="nav-link active" aria-current="page" href="#">Inicio</a></h5>
                    </li>
                    <li class="nav-item">
                        <h6><a class="nav-link" href="CuentaCliente.html">Cuenta</a></h6>
                    </li>
                    <li class="nav-item">
                        <h6><a class="nav-link" href="MovimientosClientes.html">Movimientos</a></h6>
                    </li>
                    <li class="nav-item">
                        <h6><a class="nav-link" href="PrestamoCliente.html">Prestamo</a></h6>
                    </li>
                    <br>
                    <br>
                    <li>
                        <h6><a class="nav-link" href="#">Ayuda</a></h6>
                    </li>
                    <li>
                        <h6><a class="nav-link" href="#">Comentarios</a></h6>
                    </li>
                    <li>
                        <h6><a class="nav-link" href="#">Programar cita</a></h6>
                    </li>
                </ul>
                <div class="position-absolute bottom-0 start-0 p-3">
                    <div class="col-12">
                        <h3><%= cliente.getLogin()%></h3>
                    </div>
                    <a class="btn btn-danger" style="width: 100px;" href="index.jsp">Salir</a>
                </div>
            </div>
        </div>
    </div>
</nav>
<!--Fin Nav-->
<div class="container pt-5">
    <div class="row pt-5 justify-content-center ">
        <div class="col-12 border-bottom mb-3">
            <H1>Bienvenido <%=cliente.getNombre() +" "+ cliente.getApellido()%></H1>
        </div>

        <div class="col-12 mb-3">
            <div class="row justify-content-evenly">
                <% for (int i = 0; i < peliculas.size() ; i++) { %>
                <div class="col-4">
                    <div class="card" style="width: 18rem; margin: auto;">
                        <img src="img/cuenta.jpg" class="card-img-top" alt="..." style="height: 175px;">
                        <div class="card-body">
                            <h5 class="card-title"><%= peliculas.get(i).getNombre() %></h5>
                            <p class="card-text">Género: <%=peliculas.get(i).getGenero() %></p>
                            <p class="card-text">Formato: <%= peliculas.get(i).getFormato() %></p>
                            <a class="btn btn-secondary" style="width: 100px;" href="#">Ver</a>
                        </div>
                    </div>
                </div>
                <%
                    }
                %>
            </div>
        </div>
    </div>
</div>
<!--Fin Contenido-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
<%}%>
