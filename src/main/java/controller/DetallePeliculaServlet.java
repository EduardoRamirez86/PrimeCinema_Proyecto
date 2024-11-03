package controller;

import model.Conexion;
import model.Pelicula;
import model.Sala;
import model.Sucursal;
import model.Usuario;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/DetallePeliculaServlet")
public class DetallePeliculaServlet extends HttpServlet {
    private Connection connection;

    @Override
    public void init() throws ServletException {
        super.init();
        connection = Conexion.ConectarBD("cinemaprime");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // Verifica que el idUsuario no sea null
        Integer idUsuario = (Integer) session.getAttribute("idUsuario");
        if (idUsuario == null) {
            response.sendRedirect("errorPage.jsp");
            return;
        }

        String nombrePelicula = request.getParameter("pelicula");

        Pelicula pelicula = null;
        Sala sala = null;
        Sucursal sucursal = null;

        try {
            String consulta = "SELECT p.idPelicula, p.nombre, p.genero, p.clasificacion, p.formato, p.valorTerceraEdad, p.valorAdulto, " +
                    "s.nombreSucursal AS sucursal, sa.numeroSala, sa.horarioProyeccion " +
                    "FROM peliculas p " +
                    "JOIN salas sa ON p.idPelicula = sa.idPelicula " +
                    "JOIN sucursales s ON sa.idSucursal = s.idSucursal " +
                    "WHERE p.nombre = ?";
            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.setString(1, nombrePelicula);

            try (ResultSet resultado = statement.executeQuery()) {
                if (resultado.next()) {
                    pelicula = new Pelicula();
                    pelicula.setIdPelicula(resultado.getInt("idPelicula"));
                    pelicula.setNombre(resultado.getString("nombre"));
                    pelicula.setGenero(resultado.getString("genero"));
                    pelicula.setClasificacion(resultado.getString("clasificacion"));
                    pelicula.setFormato(resultado.getString("formato"));
                    pelicula.setValorTerceraEdad(resultado.getDouble("valorTerceraEdad"));
                    pelicula.setValorAdulto(resultado.getDouble("valorAdulto"));

                    sala = new Sala();
                    sala.setNumeroSala(resultado.getInt("numeroSala"));
                    sala.setHorarioProyeccion(resultado.getTime("horarioProyeccion"));

                    sucursal = new Sucursal();
                    sucursal.setNombreSucursal(resultado.getString("sucursal"));

                    // Guarda los atributos en la sesión
                    session.setAttribute("idPelicula", pelicula.getIdPelicula());
                    session.setAttribute("idSala", sala.getNumeroSala());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error al acceder a la base de datos.");
        }

        // Asegúrate de que los objetos no sean nulos antes de establecerlos en la solicitud
        request.setAttribute("pelicula", pelicula);
        request.setAttribute("sala", sala);
        request.setAttribute("sucursal", sucursal);
        request.setAttribute("idUsuario", idUsuario);

        // Redirigir al JSP de detalles de la película
        RequestDispatcher dispatcher = request.getRequestDispatcher("detallePelicula.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void destroy() {
        Conexion.Desconectar(connection);
    }
}




