package controller;

import model.Conexion;
import model.Sucursal;

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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/sucursales")
public class SucursalServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Sucursal> listaSucursales = obtenerSucursales();
        request.setAttribute("listaSucursales", listaSucursales);
        request.getRequestDispatcher("listaSucursales.jsp").forward(request, response);
    }

    private List<Sucursal> obtenerSucursales() {
        List<Sucursal> listaSucursales = new ArrayList<>();
        try (Connection conexion = Conexion.ConectarBD("cinemaprime")) {
            if (conexion == null) {
                System.out.println("No se pudo establecer la conexión con la base de datos.");
                return listaSucursales;
            }

            String consulta = "SELECT * FROM sucursales";
            try (PreparedStatement statement = conexion.prepareStatement(consulta);
                 ResultSet resultado = statement.executeQuery()) {

                while (resultado.next()) {
                    Sucursal sucursal = new Sucursal();
                    sucursal.setId(resultado.getInt("id"));
                    sucursal.setNombreSucursal(resultado.getString("nombreSucursal"));
                    sucursal.setGerente(resultado.getString("gerente"));
                    sucursal.setDireccion(resultado.getString("direccion"));
                    sucursal.setTelefono(resultado.getString("telefono"));
                    listaSucursales.add(sucursal);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaSucursales;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener los datos de la nueva sucursal desde el formulario
        String nombreSucursal = request.getParameter("nombreSucursal");
        String gerente = request.getParameter("gerente");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");

        // Agregar la nueva sucursal a la base de datos
        agregarSucursal(nombreSucursal, gerente, direccion, telefono);

        // Redirigir a la lista de sucursales
        response.sendRedirect("sucursales");
    }

    private void agregarSucursal(String nombreSucursal, String gerente, String direccion, String telefono) {
        try (Connection conexion = Conexion.ConectarBD("cinemaprime")) {
            String consulta = "INSERT INTO sucursales (nombreSucursal, gerente, direccion, telefono) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
                statement.setString(1, nombreSucursal);
                statement.setString(2, gerente);
                statement.setString(3, direccion);
                statement.setString(4, telefono);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}






