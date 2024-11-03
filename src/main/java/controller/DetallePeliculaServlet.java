package controller;

import dao.PeliculaDAO;
import model.Conexion;
import model.Pelicula;
import model.Sala;
import model.Sucursal;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/DetallePeliculaServlet")
public class DetallePeliculaServlet extends HttpServlet {
    private Connection connection;
    private PeliculaDAO peliculaDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        connection = Conexion.ConectarBD("cinemaprime");
        peliculaDAO = new PeliculaDAO(); // Inicializa el DAO
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(); // Obtenemos la sesión actual

        Integer idUsuario = (Integer) session.getAttribute("idUsuario");
        if (idUsuario == null) {
            System.out.println("Usuario no autenticado, redirigiendo a menuUsuario.jsp");
            response.sendRedirect("menuUsuario.jsp");
            return; // Si no hay usuario logueado, redirige al menú
        }

        String nombrePelicula = request.getParameter("pelicula");
        System.out.println("Nombre de la película recibido (antes de modificar): " + nombrePelicula);

        // Reemplazar '+' por espacio y eliminar espacios en blanco
        if (nombrePelicula != null) {
            nombrePelicula = nombrePelicula.replace("+", " ").trim(); // Aquí realizamos el reemplazo
            System.out.println("Nombre de la película recibido (después de modificar): " + nombrePelicula); // Verificar el resultado
        }

        Pelicula pelicula = peliculaDAO.obtenerPeliculaPorNombre(nombrePelicula); // Obtén la película por nombre
        if (pelicula == null) {
            System.out.println("No se encontró la película con el nombre: " + nombrePelicula);
            request.setAttribute("errorMessage", "No se encontró la película solicitada.");
        } else {
            System.out.println("Película encontrada: " + pelicula.getNombre());
            session.setAttribute("idPelicula", pelicula.getIdPelicula());

            // Obtener sala y sucursal usando los métodos del DAO
            Sala sala = peliculaDAO.obtenerSalaPorPelicula(pelicula.getIdPelicula());
            Sucursal sucursal = peliculaDAO.obtenerSucursalPorPelicula(pelicula.getIdPelicula());

            if (sala != null) {
                System.out.println("Sala encontrada: " + sala.getNumeroSala());
            } else {
                System.out.println("No se encontró la sala para la película: " + pelicula.getNombre());
            }

            if (sucursal != null) {
                System.out.println("Sucursal encontrada: " + sucursal.getNombreSucursal());
            } else {
                System.out.println("No se encontró la sucursal para la película: " + pelicula.getNombre());
            }

            request.setAttribute("pelicula", pelicula);
            request.setAttribute("sala", sala);
            request.setAttribute("sucursal", sucursal);
            request.setAttribute("idUsuario", idUsuario);
            RequestDispatcher dispatcher = request.getRequestDispatcher("detallePelicula.jsp");
            dispatcher.forward(request, response);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("detallePelicula.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener el ID de la película desde los parámetros de la solicitud
        String idPeliculaParam = request.getParameter("idPelicula");
        Integer idPelicula = null;

        // Verificamos si el parámetro no es nulo y lo convertimos a Integer
        if (idPeliculaParam != null) {
            try {
                idPelicula = Integer.parseInt(idPeliculaParam);
            } catch (NumberFormatException e) {
                // Manejo de error si el parámetro no es un número válido
                request.setAttribute("error", "ID de película inválido.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
                dispatcher.forward(request, response);
                return;
            }
        }

        // Lógica para obtener datos de la película
        if (idPelicula != null) {
            Pelicula pelicula = peliculaDAO.obtenerPeliculaPorId(idPelicula);
            Sala sala = peliculaDAO.obtenerSalaPorPelicula(idPelicula);
            Sucursal sucursal = peliculaDAO.obtenerSucursalPorPelicula(idPelicula);

            // Comprobar si se encontró la película
            if (pelicula != null) {
                request.setAttribute("nombre", pelicula.getNombre());
                request.setAttribute("genero", pelicula.getGenero());
                request.setAttribute("clasificacion", pelicula.getClasificacion());
                request.setAttribute("formato", pelicula.getFormato());
                request.setAttribute("valorTerceraEdad", pelicula.getValorTerceraEdad());
                request.setAttribute("valorAdulto", pelicula.getValorAdulto());

                // Asignar datos de la sala y sucursal
                if (sala != null) {
                    request.setAttribute("numeroSala", sala.getNumeroSala());
                } else {
                    request.setAttribute("numeroSala", null);
                }

                if (sucursal != null) {
                    request.setAttribute("nombreSucursal", sucursal.getNombreSucursal());
                } else {
                    request.setAttribute("nombreSucursal", null);
                }

                // Redirigir a la JSP para mostrar los detalles de la película
                RequestDispatcher dispatcher = request.getRequestDispatcher("detallesPelicula.jsp");
                dispatcher.forward(request, response);
            } else {
                // Manejar el caso donde no se encuentra la película
                request.setAttribute("error", "La película seleccionada no se encontró en la base de datos.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            // Manejo del caso donde idPelicula es nulo
            request.setAttribute("error", "ID de película no proporcionado.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
        }
    }


    @Override
    public void destroy() {
        Conexion.Desconectar(connection); // Asegúrate de cerrar la conexión al final
    }
}








