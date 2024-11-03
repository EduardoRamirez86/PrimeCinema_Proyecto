package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestDetallePeliculaServlet {
    public static void main(String[] args) {
        try {
            // URL del servlet (ajusta 'CinemaPrime' al nombre real de tu aplicación)
            String urlString = "http://localhost:8080/DetallePeliculaServlet"; // Cambia esto según tu configuración
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Configuración de la conexión
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setDoOutput(true);

            // Parámetros a enviar (nombre de la película)
            String nombrePelicula = "Avatar 2"; // Cambia esto según la película que quieras probar
            String params = "pelicula=" + nombrePelicula;

            // Enviando la solicitud
            OutputStream os = connection.getOutputStream();
            os.write(params.getBytes());
            os.flush();
            os.close();

            // Leer la respuesta
            int responseCode = connection.getResponseCode();
            System.out.println("Código de respuesta: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Imprimir la respuesta del servlet
                System.out.println("Respuesta del servlet:");
                System.out.println(response.toString());
            } else {
                System.out.println("Error en la conexión: " + responseCode);
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


