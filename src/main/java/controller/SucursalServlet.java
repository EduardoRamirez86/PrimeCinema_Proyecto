package controller;

import dao.SucursalDAO;
import model.Sucursal;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/sucursal")
public class SucursalServlet extends HttpServlet {

    private SucursalDAO sucursalDAO;

    @Override
    public void init() throws ServletException {
        // Inicializa el DAO
        sucursalDAO = new SucursalDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        mostrarSucursales(request, response);
    }

    private void mostrarSucursales(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Recupera la lista de sucursales desde el DAO
            List<Sucursal> sucursales = sucursalDAO.listarSucursales();
            // Establece la lista como atributo en la solicitud
            request.setAttribute("sucursales", sucursales);
            // Redirige a la página JSP para mostrar las sucursales
            request.getRequestDispatcher("/sucursal.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace(); // Registra el error en la consola
            throw new ServletException("Error al mostrar las sucursales", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            // Aquí puedes agregar la lógica para agregar una nueva sucursal
            String nombreSucursal = request.getParameter("nombreSucursal");
            String gerente = request.getParameter("gerente");
            String direccion = request.getParameter("direccion");
            String telefono = request.getParameter("telefono");

            Sucursal nuevaSucursal = new Sucursal(0, nombreSucursal, gerente, direccion, telefono);
            try {
                sucursalDAO.agregarSucursal(nuevaSucursal);
                response.sendRedirect("sucursal"); // Redirecciona a la lista después de agregar
            } catch (SQLException e) {
                e.printStackTrace();
                throw new ServletException("Error al agregar la sucursal", e);
            }
        }
    }
}







