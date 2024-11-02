package controller;

import model.Usuario;
import model.Conexion;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/registrarUsuario")
public class RegistroUsuarioServlet extends HttpServlet {

    private Connection connection;

    @Override
    public void init() {
        this.connection = Conexion.ConectarBD("cinemaprime");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("usuario");
        String password = request.getParameter("password");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String dui = request.getParameter("dui");
        String direccion = request.getParameter("direccion");
        String correoElectronico = request.getParameter("correoElectronico");
        String telefono = request.getParameter("telefono");

        Usuario usuario = new Usuario();
        usuario.setLogin(login);
        usuario.setPassword(password);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setDui(dui);
        usuario.setDireccion(direccion);
        usuario.setCorreoElectronico(correoElectronico);
        usuario.setTelefono(telefono);

        try {
            String sql = "INSERT INTO usuarios (login, password, nombre, apellido, dui, direccion, correoElectronico, telefono) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, usuario.getLogin());
            statement.setString(2, usuario.getPassword());
            statement.setString(3, usuario.getNombre());
            statement.setString(4, usuario.getApellido());
            statement.setString(5, usuario.getDui());
            statement.setString(6, usuario.getDireccion());
            statement.setString(7, usuario.getCorreoElectronico());
            statement.setString(8, usuario.getTelefono());
            statement.executeUpdate();
            response.getWriter().write("Registro de usuario exitoso");
        } catch (SQLException e) {
            response.getWriter().write("Error en el registro: " + e.getMessage());
        }
    }

    @Override
    public void destroy() {
        Conexion.Desconectar(connection);
    }
}






