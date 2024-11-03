package controller;

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
        // Obtener todas las películas con información de sala y sucursal
        List<String> resultados = obtenerCartelera();

        // Guardar los resultados en el objeto request
        request.setAttribute("resultadosCartelera", resultados);

        // Redirigir a la página de cartelera
        RequestDispatcher dispatcher = request.getRequestDispatcher("cartelera.jsp");
        dispatcher.forward(request, response);
    }

    // Método para obtener todas las películas con información de sala y sucursal
    private List<String> obtenerCartelera() {
        List<String> resultados = new ArrayList<>();

        // Usar la clase Conexion para conectar a la base de datos
        try (Connection conexion = Conexion.ConectarBD("cinemaprime")) {
            // Consulta SQL para obtener todas las películas con información de sala y sucursal
            String consulta = "SELECT p.nombre AS pelicula, s.nombreSucursal AS sucursal, sa.numeroSala AS sala, sa.horarioPoyeccion AS horario " +
                    "FROM peliculas p " +
                    "JOIN salas sa ON p.idPelicula = sa.idPelicula " +
                    "JOIN sucursales s ON sa.idSucursal = s.idSucursal";

            try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
                // Ejecutar la consulta
                try (ResultSet resultSet = statement.executeQuery()) {
                    // Recorrer los resultados y agregarlos a la lista
                    while (resultSet.next()) {
                        String nombrePelicula = resultSet.getString("pelicula");
                        String nombreSucursal = resultSet.getString("sucursal");
                        int numeroSala = resultSet.getInt("sala");
                        String horario = resultSet.getString("horario");

                        // Formar una cadena con la información y agregarla a la lista
                        String resultado = String.format("%s - Sucursal: %s - Sala: %d - Horario: %s",
                                nombrePelicula, nombreSucursal, numeroSala, horario);
                        resultados.add(resultado);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo básico de excepciones, ajusta según tus necesidades
        }

        return resultados;
    }
}

