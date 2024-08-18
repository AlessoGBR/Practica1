/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1.Backend;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author alesso
 */
public class generarHtml {

    private String path;

    public generarHtml(String path) {
        this.path = path;
    }

    public void generarConsulta(String noTarjeta, String tipoTarjeta, String limite, String nombre, String direccion, String estado, String saldo) {
        String filePath = "tarjeta_info.html"; // Ruta del archivo HTML

        // Estructura básica del archivo HTML
        StringBuilder htmlContent = new StringBuilder();
        htmlContent.append("<html>\n<head>\n<title>Información de la Tarjeta</title>\n</head>\n<body>\n");
        htmlContent.append("<h1>Detalles de la Tarjeta</h1>\n");
        htmlContent.append("<table border='1' cellpadding='10' cellspacing='0'>\n");
        htmlContent.append("<tr>\n<th>No Tarjeta</th><th>Tipo Tarjeta</th><th>Límite</th><th>Nombre</th><th>Dirección</th><th>Estado</th><th>Saldo</th>\n</tr>\n");
        htmlContent.append("<tr>\n");
        htmlContent.append("<td>").append(noTarjeta).append("</td>\n");
        htmlContent.append("<td>").append(tipoTarjeta).append("</td>\n");
        htmlContent.append("<td>").append(limite).append("</td>\n");
        htmlContent.append("<td>").append(nombre).append("</td>\n");
        htmlContent.append("<td>").append(direccion).append("</td>\n");
        htmlContent.append("<td>").append(estado).append("</td>\n");
        htmlContent.append("<td>").append(saldo).append("</td>\n");
        htmlContent.append("</tr>\n");
        htmlContent.append("</table>\n");
        htmlContent.append("</body>\n</html>");

        // Escribir el contenido en el archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(htmlContent.toString());
            System.out.println("Archivo HTML generado correctamente en " + filePath);
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo HTML: " + e.getMessage());
        }
    }

}
