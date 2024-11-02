package controller;

import model.Conexion;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/detallePelicula")
public class DetallePeliculaServlet extends HttpServlet {

    private Connection connection;

    @Override
    public void init() {
        this.connection = Conexion.ConectarBD("cinemaprime");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int idUsuario = (int) session.getAttribute("idUsuario");

        String nombrePelicula = request.getParameter("pelicula");

        String nombre = null;
        String genero = null;
        String clasificacion = null;
        String formato = null;
        double valorTerceraEdad = 0.0;
        double valorAdulto = 0.0;

        try {
            String consultaPelicula = "SELECT id_pelicula, nombre, genero, clasificacion, formato, valor_tercera_edad, valor_adulto FROM peliculas WHERE nombre = ?";
            PreparedStatement statementPelicula = connection.prepareStatement(consultaPelicula);
            statementPelicula.setString(1, nombrePelicula);

            ResultSet resultadoPelicula = statementPelicula.executeQuery();

            if (resultadoPelicula.next()) {
                int idPelicula = resultadoPelicula.getInt("id_pelicula");
                nombre = resultadoPelicula.getString("nombre");
                genero = resultadoPelicula.getString("genero");
                clasificacion = resultadoPelicula.getString("clasificacion");
                formato = resultadoPelicula.getString("formato");
                valorTerceraEdad = resultadoPelicula.getDouble("valor_tercera_edad");
                valorAdulto = resultadoPelicula.getDouble("valor_adulto");

                request.setAttribute("idPelicula", idPelicula);

                String consultaSala = "SELECT id_sala, numero_sala, id_sucursal, horario_proyeccion, fecha_proyeccion FROM salas WHERE id_pelicula = ?";
                PreparedStatement statementSala = connection.prepareStatement(consultaSala);
                statementSala.setInt(1, idPelicula);

                ResultSet resultadoSala = statementSala.executeQuery();

                if (resultadoSala.next()) {
                    request.setAttribute("idSala", resultadoSala.getInt("id_sala"));
                    request.setAttribute("numeroSala", resultadoSala.getInt("numero_sala"));
                    request.setAttribute("idSucursal", resultadoSala.getInt("id_sucursal"));
                    request.setAttribute("horarioProyeccion", resultadoSala.getString("horario_proyeccion"));
                    request.setAttribute("fechaProyeccion", resultadoSala.getString("fecha_proyeccion"));
                }

                statementSala.close();
            }

            statementPelicula.close();

        } catch (SQLException e) {
            response.getWriter().write("Error al obtener detalles de la película: " + e.getMessage());
        }

        request.setAttribute("nombre", nombre);
        request.setAttribute("genero", genero);
        request.setAttribute("clasificacion", clasificacion);
        request.setAttribute("formato", formato);
        request.setAttribute("valorTerceraEdad", valorTerceraEdad);
        request.setAttribute("valorAdulto", valorAdulto);

        request.setAttribute("idUsuario", idUsuario);

        RequestDispatcher dispatcher = request.getRequestDispatcher("usuario/detallePelicula.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void destroy() {
        Conexion.Desconectar(connection);
    }
}

