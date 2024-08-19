/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1.Backend;

import com.mycompany.practica1.Frontend.consulta;
import com.mycompany.practica1.Frontend.estadoCuenta;
import com.mycompany.practica1.Frontend.listadoSolicitudes;
import com.mycompany.practica1.Frontend.listadoTarjetas;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author alesso
 */
public class generarHtml {

    private String path;
    private String filePath;

    public generarHtml(String path) {
        this.path = path;
    }

    public void generarConsulta(String noTarjeta, String tipoTarjeta, String limite, 
            String nombre, String direccion, String estado, String saldo, String nombreAr, consulta consulta) {
        // Estructura básica del archivo HTML
        if (!path.endsWith(File.separator)) {
            path += File.separator;
        }

        // Crear el nombre completo del archivo
        filePath = path + nombreAr;
        // Crear un objeto File para representar la ruta del archivo
        File newFile = new File(filePath);

        // Crear el archivo HTML en la ruta seleccionada
        try (FileWriter writer = new FileWriter(newFile)) {
            writer.write("<html>\n");
            writer.write("<head>\n");
            writer.write("<title>Información de Tarjeta</title>\n");
            writer.write("</head>\n");
            writer.write("<body>\n");
            writer.write("<h1>DETALLES DE LA TARJETA</h1>\n");
            writer.write("<table border='1'>\n");
            writer.write("<tr><th>No Tarjeta</th><th>Tipo Tarjeta</th><th>Límite</th><th>Nombre</th><th>Dirección</th><th>Estado</th><th>Saldo</th></tr>\n");
            writer.write("<tr><td>" + noTarjeta + "</td><td>" + tipoTarjeta + "</td><td>" + limite + "</td><td>" + nombre + "</td><td>" + direccion + "</td><td>" + estado + "</td><td>" + saldo + "</td></tr>\n");
            writer.write("</table>\n");
            writer.write("</body>\n");
            writer.write("</html>");
            consulta.archivoGenerado();
        } catch (IOException e) {
            consulta.archivoNoGuardado();
        }
    }

    public void generarReporteCuenta(String path, String[][] datos, String reporte, String nombre, estadoCuenta estado) {
        // Asegurarse de que la ruta termine con una barra separadora
        if (!path.endsWith(File.separator)) {
            path += File.separator;
        }

        // Crear el nombre completo del archivo
        filePath = path + nombre;
        System.out.println(filePath);

        // Crear un objeto File para representar la ruta del archivo
        File newFile = new File(filePath);

        // Crear el archivo HTML en la ruta seleccionada
        try (FileWriter writer = new FileWriter(newFile)) {
            writer.write("<html>\n");
            writer.write("<head>\n");
            writer.write("<title>REPORTES</title>\n");
            writer.write("</head>\n");
            writer.write("<body>\n");
            writer.write("<h1>DETALLES SOBRE " + reporte + "</h1>\n");
            writer.write("<table border='1'>\n");
            writer.write("<tr><th>No TARJETA</th><th>FECHA</th><th>DESCRIPCION</th><th>ESTABLECIMIENTO</th><th>MONTO</th><th>MOVIMIENTO</th><th>SALDO</th><th>INTERES</th></tr>\n");

            // Iterar sobre la matriz para llenar las filas de la tabla
            for (String[] fila : datos) {
                writer.write("<tr>");
                for (String columna : fila) {
                    writer.write("<td>" + columna + "</td>");
                }
                writer.write("</tr>\n");
            }

            writer.write("</table>\n");
            writer.write("</body>\n");
            writer.write("</html>");
            //Lanza un mensaje si se guardo el archivo
            estado.archivoGenerado();
        } catch (IOException e) {
            estado.archivoNoGuardado();
        }
    }

    public void generarReporteSolicitud(String path, String[][] datos, String reporte, String nombre, listadoSolicitudes estado) {
        // Asegurarse de que la ruta termine con una barra separadora
        if (!path.endsWith(File.separator)) {
            path += File.separator;
        }

        // Crear el nombre completo del archivo
        filePath = path + nombre;

        // Crear un objeto File para representar la ruta del archivo
        File newFile = new File(filePath);

        // Crear el archivo HTML en la ruta seleccionada
        try (FileWriter writer = new FileWriter(newFile)) {
            writer.write("<html>\n");
            writer.write("<head>\n");
            writer.write("<title>REPORTES</title>\n");
            writer.write("</head>\n");
            writer.write("<body>\n");
            writer.write("<h1>DETALLES SOBRE " + reporte + "</h1>\n");
            writer.write("<table border='1'>\n");
            writer.write("<tr><th>NUMERO</th><th>NOMBRE</th><th>SALARIO</th><th>TIPO</th><th>DIRECCION</th><th>FECHA</th><th>ESTADO</th></tr>\n");

            // Iterar sobre la matriz para llenar las filas de la tabla
            for (String[] fila : datos) {
                writer.write("<tr>");
                for (String columna : fila) {
                    writer.write("<td>" + columna + "</td>");
                }
                writer.write("</tr>\n");
            }

            writer.write("</table>\n");
            writer.write("</body>\n");
            writer.write("</html>");
            estado.archivoGenerado();
        } catch (IOException e) {
            estado.archivoNoGuardado();
        }
    }

    public void generarReporteTarjetas(String path, String[][] datos, String reporte,String nombre, listadoTarjetas estado) {
        // Asegurarse de que la ruta termine con una barra separadora
        if (!path.endsWith(File.separator)) {
            path += File.separator;
        }

        // Crear el nombre completo del archivo
        filePath = path + nombre;

        // Crear un objeto File para representar la ruta del archivo
        File newFile = new File(filePath);

        // Crear el archivo HTML en la ruta seleccionada
        try (FileWriter writer = new FileWriter(newFile)) {
            writer.write("<html>\n");
            writer.write("<head>\n");
            writer.write("<title>REPORTES</title>\n");
            writer.write("</head>\n");
            writer.write("<body>\n");
            writer.write("<h1>DETALLES SOBRE " + reporte + "</h1>\n");
            writer.write("<table border='1'>\n");
            writer.write("<tr><th>No TARJETA</th><th>NOMBRE</th><th>LIMITE</th><th>TIPO</th><th>ESTADO</th><th>DIRECCION</th><th>FECHA</th><th>SALDO</th></tr>\n");

            // Iterar sobre la matriz para llenar las filas de la tabla
            for (String[] fila : datos) {
                writer.write("<tr>");
                for (String columna : fila) {
                    writer.write("<td>" + columna + "</td>");
                }
                writer.write("</tr>\n");
            }

            writer.write("</table>\n");
            writer.write("</body>\n");
            writer.write("</html>");
            estado.archivoGenerado();
        } catch (IOException e) {
            estado.archivoNoGuardado();
        }
    }

}
