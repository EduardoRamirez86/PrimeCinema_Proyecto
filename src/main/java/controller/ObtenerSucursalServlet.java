package controller;

import model.Conexion;
import model.Sucursal;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ObtenerSucursalServlet")
public class ObtenerSucursalServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Sucursal> listaSucursales = new ArrayList<>();

        // Conexión a la base de datos
        try (Connection conexion = Conexion.ConectarBD("cinemaprime")) {
            if (conexion == null) {
                System.out.println("No se pudo establecer la conexión con la base de datos.");
                request.setAttribute("error", "No se pudo conectar a la base de datos.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
                dispatcher.forward(request, response);
                return;
            }

            // Consulta SQL para obtener todas las sucursales
            String consulta = "SELECT * FROM sucursales";
            try (PreparedStatement statement = conexion.prepareStatement(consulta);
                 ResultSet resultado = statement.executeQuery()) {

                // Si hay resultados, crea los objetos Sucursal y los añade a la lista
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
            request.setAttribute("error", "Error al acceder a la base de datos: " + e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
            return;
        }

        // Configura la lista de Sucursales como un atributo de solicitud
        if (listaSucursales.isEmpty()) {
            request.setAttribute("mensaje", "No se encontraron sucursales en la base de datos.");
        } else {
            request.setAttribute("sucursales", listaSucursales);
        }

        // Redirige a la página JSP "listaSucursales"
        RequestDispatcher dispatcher = request.getRequestDispatcher("listaSucursales.jsp");
        dispatcher.forward(request, response);
    }
}



