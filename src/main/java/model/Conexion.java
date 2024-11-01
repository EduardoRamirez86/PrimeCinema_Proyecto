package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {

    private static final String USER = "userjava"; //
    private static final String PASSWORD = "12345";

    public static Connection ConectarBD(String bd) {
        Connection conexion = null;
        String host = "jdbc:mysql://localhost:3306/" + bd + "?useSSL=false&allowPublicKeyRetrieval=true";

        System.out.println("Conectando a la base de datos " + bd + "...");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(host, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos: " + bd);
        } catch (ClassNotFoundException e) {
            System.out.println("Controlador no encontrado: " + e.getMessage());
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
            throw new RuntimeException(e);
        }

        return conexion;
    }

    public static void Desconectar(Connection conexion) {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexión cerrada correctamente.");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("No hay conexión activa para cerrar.");
        }
    }

    public static void main(String[] args) {
        Connection bd = ConectarBD("cinemaprime");
        Desconectar(bd);
    }
}

