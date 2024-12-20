package controller;

import jakarta.servlet.http.HttpSession;
import model.Empleado;
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

@WebServlet("/loginEmpleado")
public class LoginEmpleadoServlet extends HttpServlet {

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
            String sql = "SELECT * FROM empleados WHERE login = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Guardar el nombre de usuario en la sesión
                HttpSession session = request.getSession();
                session.setAttribute("empleados", login);

                // Redirigir al JSP de menú
                response.sendRedirect("menuEmpleado.jsp");
            } else {
                response.getWriter().write("Usuario o contraseña incorrectos");
            }
        } catch (SQLException e) {
            response.getWriter().write("Error en el inicio de sesión: " + e.getMessage());
        }
    }

    @Override
    public void destroy() {
        Conexion.Desconectar(connection);
    }
}
