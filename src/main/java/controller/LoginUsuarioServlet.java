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
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/loginUsuario")
public class LoginUsuarioServlet extends HttpServlet {

    private Connection connection;

    @Override
    public void init() {
        this.connection = Conexion.ConectarBD("cinemaprime");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("usuario");
        String password = request.getParameter("password");

        try {
            String sql = "SELECT * FROM usuarios WHERE login = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Login exitoso
                response.sendRedirect("paginaInicio.jsp"); // Redirigir a la página de inicio
            } else {
                // Login fallido
                response.sendRedirect("loginUsuario.jsp");
            }
        } catch (SQLException e) {
            response.getWriter().write("Error en el login: " + e.getMessage());
        }
    }

    @Override
    public void destroy() {
        Conexion.Desconectar(connection);
    }
}


