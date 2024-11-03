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

    public void agregarSucursal(Sucursal sucursal) throws SQLException {
        String sql = "INSERT INTO sucursales (nombreSucursal, gerente, direccion, telefono) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.ConectarBD("cinemaprime");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, sucursal.getNombreSucursal());
            pstmt.setString(2, sucursal.getGerente());
            pstmt.setString(3, sucursal.getDireccion());
            pstmt.setString(4, sucursal.getTelefono());
            pstmt.executeUpdate();
        }
    }

    public List<Sucursal> listarSucursales() throws SQLException {
        List<Sucursal> sucursales = new ArrayList<>();
        String sql = "SELECT * FROM sucursales";
        try (Connection conn = Conexion.ConectarBD("cinemaprime");
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Sucursal sucursal = new Sucursal(
                        rs.getInt("idSucursal"),
                        rs.getString("nombreSucursal"),
                        rs.getString("gerente"),
                        rs.getString("direccion"),
                        rs.getString("telefono")
                );
                sucursales.add(sucursal);
            }
        }
        return sucursales;
    }
}


