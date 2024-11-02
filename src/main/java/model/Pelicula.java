package model;

public class Pelicula {
    private int idPelicula;
    private String nombre;
    private String genero;
    private String clasificacion;
    private String formato;
    private double valorTerceraEdad;
    private double valorAdulto;

    // Constructores, getters y setters

    public Pelicula() {
        // Constructor vacío
    }

    public Pelicula(String nombre, String genero, String clasificacion, String formato, double valorTerceraEdad, double valorAdulto) {
        this.nombre = nombre;
        this.genero = genero;
        this.clasificacion = clasificacion;
        this.formato = formato;
        this.valorTerceraEdad = valorTerceraEdad;
        this.valorAdulto = valorAdulto;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public double getValorTerceraEdad() {
        return valorTerceraEdad;
    }

    public void setValorTerceraEdad(double valorTerceraEdad) {
        this.valorTerceraEdad = valorTerceraEdad;
    }

    public double getValorAdulto() {
        return valorAdulto;
    }

    public void setValorAdulto(double valorAdulto) {
        this.valorAdulto = valorAdulto;
    }
}