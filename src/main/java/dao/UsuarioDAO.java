package dao;

import model.Usuario;
import model.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public Usuario validarUsuario(String login, String password) {
        Usuario usuario = null;
        String query = "SELECT * FROM usuarios WHERE login = ? AND password = ?";

        try (Connection conexion = Conexion.ConectarBD("cinemaprime");
             PreparedStatement stmt = conexion.prepareStatement(query)) {

            stmt.setString(1, login);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setLogin(rs.getString("login"));
                usuario.setPassword(rs.getString("password"));
                usuario.setNombreCompleto(rs.getString("nombre_completo"));
                usuario.setDui(rs.getString("dui"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setCorreoElectronico(rs.getString("correo_electronico"));
                usuario.setTelefono(rs.getString("telefono"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }
}
