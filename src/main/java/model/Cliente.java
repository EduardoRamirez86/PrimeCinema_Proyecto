package model;

import java.sql.Connection;
import java.sql.*;

import java.util.ArrayList;

public class Cliente {

    public int ID_Cliente;
    public String primer_nombre;
    public String segundo_nombre;
    public String primer_apellido;
    public String segundo_apellido;
    public String DUI;
    public String direccion;
    public String telefono;
    public String correo;
    public String fecha_nacimiento;
    public String usuario;
    public
    String contra;

    public Cliente(int ID_Cliente, String primer_nombre, String segundo_nombre, String primer_apellido, String segundo_apellido, String DUI, String direccion, String telefono, String correo, String fecha_nacimiento, String usuario, String contra) {
        this.ID_Cliente = ID_Cliente;
        this.primer_nombre = primer_nombre;
        this.segundo_nombre = segundo_nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.DUI = DUI;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.usuario = usuario;
        this.contra = contra;
    }

    public int getID_Cliente() {
        return ID_Cliente;
    }

    public void setID_Cliente(int ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }

    public String getPrimer_nombre() {
        return primer_nombre;
    }

    public void setPrimer_nombre(String primer_nombre) {
        this.primer_nombre = primer_nombre;
    }

    public String getSegundo_nombre() {
        return segundo_nombre;
    }

    public void setSegundo_nombre(String segundo_nombre) {
        this.segundo_nombre = segundo_nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public String getDUI() {
        return DUI;
    }

    public void setDUI(String DUI) {
        this.DUI = DUI;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public static ArrayList<Cliente> ConsultaClientes(Connection con, ArrayList<Cliente> clientes) {
        String sql = "SELECT * FROM Cliente";
        Statement stmt;
        ResultSet rs;

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                clientes.add(new Cliente(rs.getInt("ID_cliente"),
                        rs.getString("primer_nombre"),
                        rs.getString("segundo_nombre"),
                        rs.getString("primer_apellido"),
                        rs.getString("segundo_apellido"),
                        rs.getString("DUI"),
                        rs.getString("direccion"),
                        rs.getString("telefono"),
                        rs.getString("correo"),
                        rs.getString("fecha_nacimiento"),
                        rs.getString("usuario"),
                        rs.getString("contra")));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error al leer los Clientes "+ e.getMessage());
        }

        return clientes;
    }
}
