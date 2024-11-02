package controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Date;
import model.Conexion;  // Asegúrate de importar la clase Conexion

@WebServlet("/registro-sala")
public class RegistroSalaServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String numeroSala = request.getParameter("numeroSala");
        int idSucursal = Integer.parseInt(request.getParameter("idSucursal"));
        int idPelicula = Integer.parseInt(request.getParameter("idPelicula"));
        String horarioProyeccion = request.getParameter("horarioProyeccion");
        String fechaProyeccion = request.getParameter("fechaProyeccion");

        if (registrarSala(numeroSala, idSucursal, idPelicula, horarioProyeccion, fechaProyeccion)) {
            response.sendRedirect("MenuEmpleado.jsp");
        } else {
            response.sendRedirect("Errores/registro_fallido_Registros.jsp");
        }
    }

    private boolean registrarSala(String numeroSala, int idSucursal, int idPelicula, String horarioProyeccion, String fechaProyeccion) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            // Obtener una conexión a la base de datos usando la clase Conexion
            conn = Conexion.ConectarBD("cinemaprime");  // Asegúrate de usar el nombre correcto de la base de datos
            String consulta = "INSERT INTO salas (numero_sala, id_sucursal, id_pelicula, horario_proyeccion, fecha_proyeccion) VALUES (?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(consulta);
            ps.setString(1, numeroSala);
            ps.setInt(2, idSucursal);
            ps.setInt(3, idPelicula);

            // Convierte horarioProyeccion a tipo Time
            Time horario = Time.valueOf(horarioProyeccion);
            ps.setTime(4, horario);

            // Convierte fechaProyeccion a tipo Date
            Date fecha = Date.valueOf(fechaProyeccion);
            ps.setDate(5, fecha);

            int filasAfectadas = ps.executeUpdate();

            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // Cerrar la conexión usando el método Desconectar de la clase Conexion
            Conexion.Desconectar(conn);
        }
    }
}

