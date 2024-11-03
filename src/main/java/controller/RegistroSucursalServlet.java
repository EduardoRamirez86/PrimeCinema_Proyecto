package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Sucursal;
import dao.SucursalDAO;

import java.io.IOException;
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

        // Crear un objeto Sucursal con los datos del formulario
        Sucursal sucursal = new Sucursal();
        sucursal.setNombreSucursal(nombreSucursal);
        sucursal.setGerente(gerente);
        sucursal.setDireccion(direccion);
        sucursal.setTelefono(telefono);

        SucursalDAO sucursalDAO = new SucursalDAO();

        try {
            // Insertar la sucursal en la base de datos usando SucursalDAO
            sucursalDAO.agregarSucursal(sucursal);

            // Colocar el objeto Sucursal en el alcance de solicitud para mostrarlo en la vista
            request.setAttribute("sucursal", sucursal);

            // Redirigir a la página de éxito
            request.getRequestDispatcher("Exito/registroSucursal.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            // Puedes redirigir a una página de error o mostrar un mensaje en caso de fallo
            response.sendRedirect("Error/error.jsp");
        }
    }
}


