package controller;

import model.Conexion;
import model.Sucursal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestObtenerSucursalServlet {
    public static void main(String[] args) {
        List<Sucursal> sucursales = obtenerSucursales();

        // Imprimir las sucursales en la consola
        if (sucursales.isEmpty()) {
            System.out.println("No se encontraron sucursales en la base de datos.");
        } else {
            System.out.println("Lista de Sucursales:");
            for (Sucursal sucursal : sucursales) {
                System.out.println("ID: " + sucursal.getId() +
                        ", Nombre: " + sucursal.getNombreSucursal() +
                        ", Gerente: " + sucursal.getGerente() +
                        ", Dirección: " + sucursal.getDireccion() +
                        ", Teléfono: " + sucursal.getTelefono());
            }
        }
    }

    private static List<Sucursal> obtenerSucursales() {
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
}

