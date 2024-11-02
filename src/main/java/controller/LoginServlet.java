package controller;

import model.Conexion;
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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String usuario = request.getParameter("usuario");
        String contrasenia = request.getParameter("password");

        if (esEmpleado(usuario)) {
            if (autenticarEmpleado(usuario, contrasenia)) {
                String nombreEmpleado = obtenerNombreEmpleado(usuario);
                request.setAttribute("nombreEmpleado", nombreEmpleado);
                response.sendRedirect("menuEmpleado.jsp");
            } else {
                response.sendRedirect("Errores/registro_fallido.jsp");
            }
        } else {
            int idUsuario = obtenerIdUsuario(usuario);
            // Almacena el ID del usuario en la sesión
            HttpSession session = request.getSession();
            session.setAttribute("idUsuario", idUsuario);

            if (autenticarUsuario(usuario, contrasenia)) {
                response.sendRedirect("menuUsuario.jsp");
            } else {
                response.sendRedirect("Errores/registro_fallido.jsp");
            }
        }
    }

    private boolean esEmpleado(String usuario) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = Conexion.ConectarBD("cinemaprime"); // Conexión a la base de datos
            String consulta = "SELECT * FROM empleados WHERE usuario = ?";
            ps = conn.prepareStatement(consulta);
            ps.setString(1, usuario);
            rs = ps.executeQuery();

            return rs.next(); // Retorna true si existe en la tabla de empleados
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.Desconectar(conn); // Cierra la conexión
        }

        return false; // Si no existe en la tabla de empleados, considerarlo como usuario
    }

    private boolean autenticarEmpleado(String usuario, String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = Conexion.ConectarBD("cinemaprime"); // Conexión a la base de datos
            String consulta = "SELECT * FROM empleados WHERE usuario = ? AND password = ?";
            ps = conn.prepareStatement(consulta);
            ps.setString(1, usuario);
            ps.setString(2, password);
            rs = ps.executeQuery();

            return rs.next(); // Autenticación exitosa para empleado
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.Desconectar(conn); // Cierra la conexión
        }

        return false; // Autenticación fallida para empleado
    }

    private boolean autenticarUsuario(String usuario, String contrasenia) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = Conexion.ConectarBD("cinemaprime"); // Conexión a la base de datos
            String consulta = "SELECT * FROM usuarios WHERE login = ? AND password = ?";
            ps = conn.prepareStatement(consulta);
            ps.setString(1, usuario);
            ps.setString(2, contrasenia);
            rs = ps.executeQuery();

            return rs.next(); // Autenticación exitosa para usuario
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.Desconectar(conn); // Cierra la conexión
        }

        return false; // Autenticación fallida para usuario
    }

    private String obtenerNombreEmpleado(String usuario) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String nombreEmpleado = null;

        try {
            conn = Conexion.ConectarBD("cinemaprime"); // Conexión a la base de datos
            String consulta = "SELECT nombre FROM empleados WHERE usuario = ?";
            ps = conn.prepareStatement(consulta);
            ps.setString(1, usuario);
            rs = ps.executeQuery();

            if (rs.next()) {
                nombreEmpleado = rs.getString("nombre");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.Desconectar(conn); // Cierra la conexión
        }

        return nombreEmpleado; // Retorna el nombre del empleado o null si no se encontró
    }

    private int obtenerIdUsuario(String usuario) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = Conexion.ConectarBD("cinemaprime"); // Conexión a la base de datos
            String consulta = "SELECT id FROM usuarios WHERE login = ?";
            ps = conn.prepareStatement(consulta);
            ps.setString(1, usuario);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("id"); // Devuelve el ID del usuario
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.Desconectar(conn); // Cierra la conexión
        }

        return 0; // Retorna 0 si no se encuentra el ID del usuario
    }
}

