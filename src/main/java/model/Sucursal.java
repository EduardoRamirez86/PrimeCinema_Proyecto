package model;

public class Sucursal {
    private int idSucursal;
    private String nombreSucursal;
    private String gerente;
    private String direccion;
    private String telefono;

    public Sucursal() {

    }
    public Sucursal(int idSucursal, String nombreSucursal, String gerente, String direccion, String telefono) {
        this.idSucursal = idSucursal;
        this.nombreSucursal = nombreSucursal;
        this.gerente = gerente;
        this.direccion = direccion;
        this.telefono = telefono;
    }


    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int id) {
        this.idSucursal = id;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
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
}

