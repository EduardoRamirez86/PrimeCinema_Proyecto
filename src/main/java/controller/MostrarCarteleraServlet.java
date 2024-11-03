package controller;

import jakarta.servlet.http.HttpSession;
import model.Conexion;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/MostrarCarteleraServlet")
public class MostrarCarteleraServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener la sesión actual
        HttpSession session = request.getSession();

        // (Opcional) Verifica si hay un usuario autenticado
        Integer idUsuario = (Integer) session.getAttribute("idUsuario");
        if (idUsuario == null) {
            response.sendRedirect("login.jsp"); // Redirige si no hay usuario autenticado
            return;
        }

        // Obtener todas las películas con información de sala y sucursal
        List<String> resultados = obtenerCartelera();

        // Guardar los resultados en el objeto request
        request.setAttribute("resultadosCartelera", resultados);

        // Si no hay resultados, agregar un mensaje
        if (resultados.isEmpty()) {
            request.setAttribute("mensaje", "No hay películas disponibles en cartelera.");
        }

        // Redirigir a la página de cartelera
        RequestDispatcher dispatcher = request.getRequestDispatcher("cartelera.jsp");
        dispatcher.forward(request, response);
    }

    private List<String> obtenerCartelera() {
        List<String> resultados = new ArrayList<>();

        try (Connection conexion = Conexion.ConectarBD("cinemaprime")) {
            String consulta = "SELECT p.nombre AS pelicula, s.nombreSucursal AS sucursal, sa.numeroSala AS sala, sa.horarioProyeccion AS horario " +
                    "FROM peliculas p " +
                    "JOIN salas sa ON p.idPelicula = sa.idPelicula " +
                    "JOIN sucursales s ON sa.idSucursal = s.idSucursal";

            try (PreparedStatement statement = conexion.prepareStatement(consulta);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    String nombrePelicula = resultSet.getString("pelicula");
                    String nombreSucursal = resultSet.getString("sucursal");
                    int numeroSala = resultSet.getInt("sala");
                    String horario = resultSet.getString("horario");

                    String resultado = String.format("%s - Sucursal: %s - Sala: %d - Horario: %s",
                            nombrePelicula, nombreSucursal, numeroSala, horario);
                    resultados.add(resultado);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo básico de excepciones
        }

        return resultados;
    }
}

