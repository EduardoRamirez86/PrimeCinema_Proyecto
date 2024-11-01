<%--
  Created by IntelliJ IDEA.
  User: eduardo
  Date: 24/9/2024
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Conexiones.InscripcionesDAO, Conexiones.AlumnoDAO, Conexiones.MateriaDAO" %>
<%@ page import="Conexiones.Alumno, Conexiones.Materia" %>
<%@ page import="java.util.List" %>
<%
    InscripcionesDAO inscripcionesDAO = new InscripcionesDAO();
    AlumnoDAO alumnoDAO = new AlumnoDAO();
    MateriaDAO materiaDAO = new MateriaDAO();

    List<Alumno> alumnos = alumnoDAO.listarAlumnos();
    List<Materia> materias = materiaDAO.listarMaterias();
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Gestionar Inscripciones</title>
</head>
<body>
<h1>Gestionar Inscripciones</h1>
<form action="inscripcionServlet" method="post">
    <h2>Inscribir Alumno a Materia</h2>
    Alumno:
    <select name="carnetAlumno">
        <%
            for (Alumno alumno : alumnos) {
        %>
        <option value="<%= alumno.getCarnet() %>"><%= alumno.getNombre() + " " + alumno.getApellidos() %></option>
        <%
            }
        %>
    </select>
    Materia:
    <select name="codigoMateria">
        <%
            for (Materia materia : materias) {
        %>
        <option value="<%= materia.getCodigoMateria() %>"><%= materia.getNombre() %></option>
        <%
            }
        %>
    </select>
    <input type="submit" name="action" value="inscribir">
</form>

<h2>Inscripciones</h2>
<table border="1">
    <tr>
        <th>Alumno</th>
        <th>Materia</th>
        <th>Acciones</th>
    </tr>
    <%
        // Aquí debes agregar la lógica para listar inscripciones si lo deseas
    %>
</table>
</body>
</html>

