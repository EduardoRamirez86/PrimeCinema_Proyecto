package dao;

import model.Conexion;
import model.Pelicula;
import model.Sala;
import model.Sucursal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeliculaDAO {

    public Pelicula obtenerPeliculaPorNombre(String nombre) {
        Pelicula pelicula = null;
        String sql = "SELECT * FROM peliculas WHERE nombre = ?";
        try (Connection conn = Conexion.ConectarBD("cinemaprime");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                pelicula = new Pelicula();
                pelicula.setIdPelicula(rs.getInt("idPelicula"));
                pelicula.setNombre(rs.getString("nombre"));
                pelicula.setGenero(rs.getString("genero"));
                pelicula.setClasificacion(rs.getString("clasificacion"));
                pelicula.setFormato(rs.getString("formato"));
                pelicula.setValorTerceraEdad(rs.getDouble("valorTerceraEdad"));
                pelicula.setValorAdulto(rs.getDouble("valorAdulto"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pelicula;
    }

    public Pelicula obtenerPeliculaPorId(int idPelicula) {
        Pelicula pelicula = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Conectar a la base de datos
            conn = DriverManager.getConnection("jdbc:tu_url_de_bd", "usuario", "contraseña");
            String sql = "SELECT * FROM peliculas WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idPelicula);
            rs = stmt.executeQuery();

            if (rs.next()) {
                // Crear un objeto Pelicula con los datos recuperados
                pelicula = new Pelicula();
                pelicula.setIdPelicula(rs.getInt("idPelicula"));
                pelicula.setNombre(rs.getString("nombre"));
                pelicula.setGenero(rs.getString("genero"));
                pelicula.setClasificacion(rs.getString("clasificacion"));
                pelicula.setFormato(rs.getString("formato"));
                pelicula.setValorTerceraEdad(rs.getDouble("valor_tercera_edad"));
                pelicula.setValorAdulto(rs.getDouble("valor_adulto"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return pelicula;
    }

    public Sala obtenerSalaPorPelicula(int idPelicula) {
        Sala sala = null;
        String sql = "SELECT * FROM salas WHERE idPelicula = ?";
        try (Connection conn = Conexion.ConectarBD("cinemaprime");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idPelicula);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                sala = new Sala();
                sala.setIdSala(rs.getInt("idSala"));
                sala.setNumeroSala(rs.getInt("numeroSala"));
                // Aquí puedes establecer otros atributos de Sala si es necesario
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sala;
    }


    public Sucursal obtenerSucursalPorPelicula(int idPelicula) {
        Sucursal sucursal = null;
        String sql = "SELECT s.* FROM sucursales s INNER JOIN salas sa ON s.idSucursal = sa.idSucursal WHERE sa.idPelicula = ?";
        try (Connection conn = Conexion.ConectarBD("cinemaprime");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idPelicula);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                sucursal = new Sucursal();
                sucursal.setIdSucursal(rs.getInt("idSucursal"));
                sucursal.setNombreSucursal(rs.getString("nombreSucursal"));
                // Aquí puedes establecer otros atributos de Sucursal si es necesario
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sucursal;
    }



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
