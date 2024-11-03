package controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import model.Conexion;
import model.Pelicula;
import dao.PeliculaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import static model.Conexion.ConectarBD;

@WebServlet(name = "MenuCliente", value = "/MenuCliente")
public class MenuCliente extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Conectar a la base de datos usando el método ConectarBD de la clase Conexion
        Connection bd = ConectarBD("cinemaprime"); // Verifica que el nombre de la base de datos sea el correcto

        // Lista para almacenar las películas obtenidas de la base de datos
        List<Pelicula> peliculas = new ArrayList<>();

        // Consultar la lista de películas usando el método listarPeliculas de PeliculaDAO
        if (bd != null) {
            peliculas = PeliculaDAO.listarPeliculas();
        }

        // Cerrar la conexión
        Conexion.Desconectar(bd);

        // Establecer la lista de películas como atributo de la solicitud
        request.setAttribute("peliculas", peliculas);

        // Redirigir a la página JSP "MenuCliente.jsp" para mostrar la lista de películas
        RequestDispatcher dispatcher = request.getRequestDispatcher("MenuCliente.jsp");
        dispatcher.forward(request, response);
    }
}

