package controller;

import model.Conexion;
import model.Usuario;
import model.Empleado;
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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String usuario = request.getParameter("usuario");
        String contrasenia = request.getParameter("password");

        System.out.println("Autenticando usuario: " + usuario); // Agregar aquí

        if (esEmpleado(usuario)) {
            Empleado empleado = autenticarEmpleado(usuario, contrasenia);
            if (empleado != null) {
                HttpSession session = request.getSession();
                session.setAttribute("empleado", empleado); // Guardar empleado en la sesión
                response.sendRedirect("menuEmpleado.jsp");
            } else {
                response.sendRedirect("Errores/registro_fallido.jsp");
            }
        } else {
            Usuario usuarioObj = autenticarUsuario(usuario, contrasenia);
            if (usuarioObj != null) {
                HttpSession session = request.getSession();
                session.setAttribute("idUsuario", usuarioObj.getIdUsuario()); // Guardar idUsuario en la sesión
                session.setAttribute("usuario", usuarioObj); // Guardar el objeto Usuario en la sesión

                // Agregar aquí para verificar que el idUsuario se está almacenando correctamente
                System.out.println("Usuario autenticado: " + usuarioObj.getNombre());
                System.out.println("idUsuario almacenado en sesión: " + usuarioObj.getIdUsuario());

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
            conn = Conexion.ConectarBD("cinemaprime");
            String consulta = "SELECT * FROM empleados WHERE login = ?";
            ps = conn.prepareStatement(consulta);
            ps.setString(1, usuario);
            rs = ps.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.Desconectar(conn);
        }

        return false;
    }

    private Empleado autenticarEmpleado(String usuario, String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Empleado empleado = null;

        try {
            conn = Conexion.ConectarBD("cinemaprime");
            String consulta = "SELECT * FROM empleados WHERE login = ? AND password = ?";
            ps = conn.prepareStatement(consulta);
            ps.setString(1, usuario);
            ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()) {
                empleado = new Empleado();
                empleado.setIdEmpleado(rs.getInt("idEmpleado"));
                empleado.setLogin(rs.getString("login"));
                empleado.setPassword(rs.getString("password"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido(rs.getString("apellido"));
                empleado.setDui(rs.getString("dui"));
                empleado.setFechaNacimiento(rs.getString("fechaNacimiento"));
                empleado.setDireccion(rs.getString("direccion"));
                empleado.setCorreo(rs.getString("correo"));
                empleado.setTelefono(rs.getString("telefono"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.Desconectar(conn);
        }

        return empleado; // Devuelve el objeto Empleado o null si no se encuentra
    }

    private Usuario autenticarUsuario(String usuario, String contrasenia) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Usuario usuarioObj = null;

        try {
            conn = Conexion.ConectarBD("cinemaprime");
            String consulta = "SELECT * FROM usuarios WHERE login = ? AND password = ?";
            ps = conn.prepareStatement(consulta);
            ps.setString(1, usuario);
            ps.setString(2, contrasenia);
            rs = ps.executeQuery();

            if (rs.next()) {
                usuarioObj = new Usuario();
                usuarioObj.setIdUsuario(rs.getInt("idUsuario"));
                usuarioObj.setLogin(rs.getString("login"));
                usuarioObj.setPassword(rs.getString("password"));
                usuarioObj.setNombre(rs.getString("nombre"));
                usuarioObj.setApellido(rs.getString("apellido"));
                usuarioObj.setDui(rs.getString("dui"));
                usuarioObj.setDireccion(rs.getString("direccion"));
                usuarioObj.setCorreoElectronico(rs.getString("correoElectronico"));
                usuarioObj.setTelefono(rs.getString("telefono"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.Desconectar(conn);
        }

        return usuarioObj; // Devuelve el objeto Usuario o null si no se encuentra
    }
}


