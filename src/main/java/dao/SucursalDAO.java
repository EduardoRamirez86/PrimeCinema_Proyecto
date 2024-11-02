package dao;

import model.Conexion;
import model.Sucursal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SucursalDAO {
    private final String DB_NAME = "cinemaprime";

    // Método para obtener todas las sucursales
    public List<Sucursal> obtenerTodas() {
        List<Sucursal> listaSucursales = new ArrayList<>();
        Connection conexion = null;

        try {
            conexion = Conexion.ConectarBD(DB_NAME);
            if (conexion == null) {
                System.out.println("No se pudo establecer la conexión con la base de datos.");
                return listaSucursales;
            }

            String consulta = "SELECT * FROM sucursales";
            try (PreparedStatement statement = conexion.prepareStatement(consulta);
                 ResultSet resultado = statement.executeQuery()) {

                while (resultado.next()) {
                    Sucursal sucursal = new Sucursal();
                    sucursal.setIdSucursal(resultado.getInt("idSucursal"));
                    sucursal.setNombreSucursal(resultado.getString("nombreSucursal"));
                    sucursal.setGerente(resultado.getString("gerente"));
                    sucursal.setDireccion(resultado.getString("direccion"));
                    sucursal.setTelefono(resultado.getString("telefono"));
                    listaSucursales.add(sucursal);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.Desconectar(conexion);
        }
        return listaSucursales;
    }

    // Método para agregar una nueva sucursal
    public void agregarSucursal(Sucursal sucursal) {
        Connection conexion = null;

        try {
            conexion = Conexion.ConectarBD(DB_NAME);
            String consulta = "INSERT INTO sucursales (nombreSucursal, gerente, direccion, telefono) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
                statement.setString(1, sucursal.getNombreSucursal());
                statement.setString(2, sucursal.getGerente());
                statement.setString(3, sucursal.getDireccion());
                statement.setString(4, sucursal.getTelefono());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.Desconectar(conexion);
        }
    }
}


