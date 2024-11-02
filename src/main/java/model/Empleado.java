package model;

public class Empleado {
    private String usuario;
    private String password;
    private String nombre;
    private String apellido;
    private String dui;
    private String fechaNacimiento;
    private String direccion;
    private String correo;
    private String telefono;

    // Constructor vacío
    public Empleado() {}

    // Getters y Setters
    public String getUsuario() { return usuario; }

    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getPassword() {return password; }

    public void setPassword(String contrasenia) { this.password = contrasenia; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }

    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getDui() { return dui; }

    public void setDui(String dui) { this.dui = dui; }

    public String getFechaNacimiento() { return fechaNacimiento; }

    public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getDireccion() { return direccion; }

    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getCorreo() { return correo; }

    public void setCorreo(String correo) { this.correo = correo; }

    public String getTelefono() { return telefono; }

    public void setTelefono(String telefono) { this.telefono = telefono; }
}

