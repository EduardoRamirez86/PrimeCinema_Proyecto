package dao;

import model.Conexion;
import model.Pelicula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PeliculaDAO {

    public void agregarPelicula(Pelicula pelicula) {
        String sql = "INSERT INTO peliculas (nombre, genero, clasificacion, formato, valorTerceraEdad, valorAdulto) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.ConectarBD("cinemaprime");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, pelicula.getNombre());
            pstmt.setString(2, pelicula.getGenero());
            pstmt.setString(3, pelicula.getClasificacion());
            pstmt.setString(4, pelicula.getFormato());
            pstmt.setDouble(5, pelicula.getValorTerceraEdad());
            pstmt.setDouble(6, pelicula.getValorAdulto());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Pelicula> listarPeliculas() {
        List<Pelicula> peliculas = new ArrayList<>();
        String sql = "SELECT * FROM peliculas";
        try (Connection conn = Conexion.ConectarBD("cinemaprime");
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Pelicula pelicula = new Pelicula(
                        rs.getString("nombre"),
                        rs.getString("genero"),
                        rs.getString("clasificacion"),
                        rs.getString("formato"),
                        rs.getDouble("valorTerceraEdad"),
                        rs.getDouble("valorAdulto")
                );
                pelicula.setIdPelicula(rs.getInt("idPelicula")); // Set idPelicula
                peliculas.add(pelicula);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return peliculas;
    }
}
