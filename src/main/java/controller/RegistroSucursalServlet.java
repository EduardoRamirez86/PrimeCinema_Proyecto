package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Conexion;
import model.Sucursal;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/registrar-sucursal")
public class RegistroSucursalServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        // Recuperar los datos del formulario
        String nombreSucursal = request.getParameter("nombre_sucursal");
        String gerente = request.getParameter("gerente");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");

        Connection conexion = null;
        try {
            // Obtener una conexión a la base de datos usando la clase Conexion
            conexion = Conexion.ConectarBD("cinemaprime");

            // Preparar la sentencia SQL para la inserción
            String sql = "INSERT INTO sucursales (nombreSucursal, gerente, direccion, telefono) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, nombreSucursal);
            statement.setString(2, gerente);
            statement.setString(3, direccion);
            statement.setString(4, telefono);

            // Ejecutar la inserción
            statement.executeUpdate();
            statement.close();

            // Crear un objeto Sucursal con los datos registrados
            Sucursal sucursal = new Sucursal();
            sucursal.setNombreSucursal(nombreSucursal);
            sucursal.setGerente(gerente);
            sucursal.setDireccion(direccion);
            sucursal.setTelefono(telefono);

            // Colocar el objeto Sucursal en el alcance de solicitud
            request.setAttribute("sucursal", sucursal);

            // Redirigir a la página mostrarSucursal.jsp
            request.getRequestDispatcher("Exito/registroSucursal.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar la conexión usando el método Desconectar de la clase Conexion
            Conexion.Desconectar(conexion);
        }
    }
}

