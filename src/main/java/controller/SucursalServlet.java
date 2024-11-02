package controller;

import dao.SucursalDAO;
import model.Sucursal;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/sucursales")
public class SucursalServlet extends HttpServlet {
    private final SucursalDAO sucursalDAO = new SucursalDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Sucursal> listaSucursales = sucursalDAO.obtenerTodas();
        request.setAttribute("listaSucursales", listaSucursales);
        request.getRequestDispatcher("listaSucursales.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nombreSucursal = request.getParameter("nombreSucursal");
        String gerente = request.getParameter("gerente");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");


        Sucursal sucursal = new Sucursal();
        sucursal.setNombreSucursal(nombreSucursal);
        sucursal.setGerente(gerente);
        sucursal.setDireccion(direccion);
        sucursal.setTelefono(telefono);
        sucursalDAO.agregarSucursal(sucursal);

        // Redirigir a la lista de sucursales
        response.sendRedirect("sucursales");
    }
}







