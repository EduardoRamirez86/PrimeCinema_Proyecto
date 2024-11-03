package model;

import java.util.Date;

public class Compra {
    private int idCompra;
    private int idUsuario;
    private int idSala;
    private Date fechaCompra;

    // Constructor
    public Compra(int idCompra, int idUsuario, int idSala, Date fechaCompra) {
        this.idCompra = idCompra;
        this.idUsuario = idUsuario;
        this.idSala = idSala;
        this.fechaCompra = fechaCompra;
    }

    // Getters y setters
    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    // Otros métodos para interactuar con la entidad Compra, si es necesario
}
