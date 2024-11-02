package controller;

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
import java.sql.SQLException;

@WebServlet("/registrarEmpleado")
public class RegistroEmpleadoServlet extends HttpServlet {

    private Connection connection;

    @Override
    public void init() {
        // Inicializa la conexión a la base de datos
        this.connection = Conexion.ConectarBD("cinemaprime");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtiene los parámetros del formulario
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String dui = request.getParameter("dui");
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        String direccion = request.getParameter("direccion");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");

        // Crea una nueva instancia de Empleado y establece sus propiedades
        Empleado empleado = new Empleado();
        empleado.setUsuario(usuario);
        empleado.setPassword(password);
        empleado.setNombre(nombre);
        empleado.setApellido(apellido);
        empleado.setDui(dui);
        empleado.setFechaNacimiento(fechaNacimiento);
        empleado.setDireccion(direccion);
        empleado.setCorreo(correo);
        empleado.setTelefono(telefono);

        try {
            // Prepara la consulta SQL para insertar un nuevo empleado
            String sql = "INSERT INTO empleados (usuario, contrasenia, nombre, apellido, dui, fecha_nacimiento, direccion, correo, telefono) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, empleado.getUsuario());
            statement.setString(2, empleado.getPassword());
            statement.setString(3, empleado.getNombre());
            statement.setString(4, empleado.getApellido());
            statement.setString(5, empleado.getDui());
            statement.setString(6, empleado.getFechaNacimiento());
            statement.setString(7, empleado.getDireccion());
            statement.setString(8, empleado.getCorreo());
            statement.setString(9, empleado.getTelefono());

            // Ejecuta la actualización y devuelve un mensaje de éxito
            statement.executeUpdate();
            response.getWriter().write("Registro de empleado exitoso");
        } catch (SQLException e) {
            // Maneja los errores en caso de que ocurran
            response.getWriter().write("Error en el registro: " + e.getMessage());
        }
    }

    @Override
    public void destroy() {
        // Desconecta la conexión a la base de datos
        Conexion.Desconectar(connection);
    }
}
