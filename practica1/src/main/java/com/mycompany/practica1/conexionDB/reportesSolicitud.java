/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1.conexionDB;

import com.mycompany.practica1.Frontend.listadoSolicitudes;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author alesso
 */
public class reportesSolicitud {

    public Connection connection;
    private String select;
    private String sqlSolicitud = "";

    public reportesSolicitud() {
        conexionDB conexion = new conexionDB();
        this.connection = conexion.connection;
    }

    // busca para autorizaciones
    public String[][] buscarAutorizacionesConSolicitud(String fechaInicio, String fechaFin, String tipo, Double salario, String estado, listadoSolicitudes mensaje) {
        String[][] datosTabla = new String[0][0];
        select = "SELECT s.No_solicitud, s.nombre, s.salario, s.tipo, s.direccion, a.fecha, a.aprovada "
                + "FROM autorizacion a "
                + "JOIN solicitud s ON a.solicitud = s.No_solicitud";
        cambioConsultaSolicitud(fechaInicio, fechaFin, tipo, salario, estado);
        // Ejecutar la consulta y llenar la matriz de resultados
        try (Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); ResultSet resultSet = statement.executeQuery(select)) {

            int rowCount = 0;
            if (resultSet.last()) {
                rowCount = resultSet.getRow();
                resultSet.beforeFirst();
            }

            if (rowCount == 0) {
                mensaje.noHayElementos();
                return new String[0][0]; // Retorna una matriz vacía si no hay resultados
            }

            datosTabla = new String[rowCount][7]; // Cambié a 7 columnas, ya que el select sólo devuelve 7 columnas

            int index = 0;
            while (resultSet.next()) {
                datosTabla[index][0] = Integer.toString(resultSet.getInt("No_solicitud"));
                datosTabla[index][1] = resultSet.getString("nombre");
                datosTabla[index][2] = Double.toString(resultSet.getDouble("salario"));
                datosTabla[index][3] = resultSet.getString("tipo");
                datosTabla[index][4] = resultSet.getString("direccion");
                datosTabla[index][5] = resultSet.getDate("fecha").toString();
                datosTabla[index][6] = resultSet.getBoolean("aprovada") ? "APROBADA" : "DENEGADA";
                index++;
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar a la DB: " + e.getMessage());
        }

        return datosTabla;
    }

    public void cambioConsultaSolicitud(String fechaInicio, String fechaFin, String tipo, Double salario, String estado) {

        // Construir cláusula WHERE dinámicamente según los filtros proporcionados
        if (fechaInicio != null && !fechaInicio.isEmpty() && fechaFin != null && !fechaFin.isEmpty()) {
            sqlSolicitud = sqlSolicitud + " AND a.fecha BETWEEN '" + fechaInicio + "' AND '" + fechaFin + "'";
        }

        if (tipo != null && !tipo.isEmpty() && !tipo.equals("NINGUNO")) {
            sqlSolicitud = sqlSolicitud + " AND s.tipo = '" + tipo + "'";
        }

        if (salario != null && salario != 0) {
            sqlSolicitud = sqlSolicitud + " AND s.salario >= " + salario;
        }

        if (estado != null) {
            if (estado.equals("APROBADO") || estado.equals("APROBADA")) {
                select = select + " AND a.aprovada = true ";
            } else if (estado.equals("DENEGADO")) {
                select = select + " AND a.aprovada = false ";
            }

        }
        // Agregar la cláusula WHERE si existen filtros
        if (!sqlSolicitud.isEmpty()) {
            sqlSolicitud = " WHERE 1=1" + sqlSolicitud;
            select += sqlSolicitud;
        }
    }

}
