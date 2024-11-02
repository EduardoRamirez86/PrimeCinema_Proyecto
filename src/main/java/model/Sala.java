package model;

import java.sql.Date;
import java.sql.Time;

public class Sala {
    private int id;
    private int numeroSala;
    private int idSucursal;
    private int idPelicula;
    private Time horarioProyeccion;
    private Date fechaProyeccion;

    public Sala() {
        // Constructor vacío
    }

    public Sala(int numeroSala, int idSucursal, int idPelicula, Time horarioProyeccion, Date fechaProyeccion) {
        this.numeroSala = numeroSala;
        this.idSucursal = idSucursal;
        this.idPelicula = idPelicula;
        this.horarioProyeccion = horarioProyeccion;
        this.fechaProyeccion=fechaProyeccion;
    }


    // Getters y setters para todos los campos

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public Time getHorarioProyeccion() {
        return horarioProyeccion;
    }

    public void setHorarioProyeccion(Time horarioProyeccion) {
        this.horarioProyeccion = horarioProyeccion;
    }

    public Date getFechaProyeccion(){return fechaProyeccion;}

    public void setFechaProyeccion(Date fechaProyeccion){this.fechaProyeccion=fechaProyeccion;}
}

