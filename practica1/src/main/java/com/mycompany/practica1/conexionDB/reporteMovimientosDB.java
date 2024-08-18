/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1.conexionDB;

import com.mycompany.practica1.Frontend.listadoTarjetas;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author alesso
 */
public class reporteMovimientosDB {

    public Connection connection;
    private String sqlTarjeta = "SELECT * FROM tarjeta";

    public reporteMovimientosDB() {
        conexionDB conexion = new conexionDB();
        this.connection = conexion.connection;
    }

    public String[][] buscarTarjetas(String tipo, double monto, String fechaInicio, String fechaFin, int estado, String nombre, listadoTarjetas mensaje) {

        String[][] datosTabla = new String[0][0];
        sqlTarjeta = "SELECT * FROM tarjeta";
        cambioConsulta(tipo, monto, fechaInicio, fechaFin, estado, nombre);
        try (Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); ResultSet resultSet = statement.executeQuery(sqlTarjeta)) {

            // Contar el número de filas
            int rowCount = 0;
            if (resultSet.last()) {
                rowCount = resultSet.getRow(); // Obtenemos el numero de filas
                resultSet.beforeFirst();
            }

            if (rowCount == 0) {
                mensaje.noHayElementos();
                return new String[0][0]; // Retorna una matriz vacía si no hay resultados
            }
            // Crear una matriz con el numero de filas encontradas
            datosTabla = new String[rowCount][8];

            int index = 0;
            while (resultSet.next()) {
                datosTabla[index][0] = resultSet.getString("numero");
                datosTabla[index][1] = resultSet.getString("nombre");
                datosTabla[index][2] = Double.toString(resultSet.getDouble("limite"));
                datosTabla[index][3] = resultSet.getString("tipo");
                datosTabla[index][4] = resultSet.getBoolean("estado") ? "ACTIVA" : "INACTIVA";
                datosTabla[index][5] = resultSet.getString("direccion");
                datosTabla[index][6] = resultSet.getDate("fecha").toString();
                datosTabla[index][7] = Double.toString(resultSet.getDouble("saldo"));
                index++;
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar a la DB");
        }

        return datosTabla;
    }

    // metodos para cambiar la consulta
    private void cambioConsulta(String tipo, double monto, String fechaInicio, String fechaFin, int estado, String nombre) {

        // Variable para determinar si ya se ha agregado una cláusula WHERE
        boolean where = false;

        // Filtrar por tipo si es necesario
        if (tipo.length() != 0 && !tipo.equals("NINGUNO")) {
            sqlTarjeta += " WHERE tipo = '" + tipo + "'";
            where = true;
        }

        // Filtrar por monto si se especifica
        if (monto != 0) {
            if (!where) {
                sqlTarjeta += " WHERE limite >= '" + monto + "'";
                where = true;
            } else {
                sqlTarjeta += " AND limite >= '" + monto + "'";
            }
        }

        // Filtrar por rango de fechas si ambos límites están presentes
        if (fechaInicio.length() != 0 && fechaFin.length() != 0) {
            if (!where) {
                sqlTarjeta += " WHERE fecha BETWEEN '" + fechaInicio + "' AND '" + fechaFin + "'";
                where = true;
            } else {
                sqlTarjeta += " AND fecha BETWEEN '" + fechaInicio + "' AND '" + fechaFin + "'";
            }
        }

        // Filtrar por estado
        if (estado == 1) {
            if (!where) {
                sqlTarjeta += " WHERE estado = true";
                where = true;
            } else {
                sqlTarjeta += " AND estado = true";
            }
        } else if (estado == 2) {
            if (!where) {
                sqlTarjeta += " WHERE estado = false";
                where = true;
            } else {
                sqlTarjeta += " AND estado = false";
            }
        }

        // Filtrar por nombre si se especifica
        if (nombre.length() != 0) {
            if (!where) {
                sqlTarjeta += " WHERE nombre LIKE '" + nombre + "'";
            } else {
                sqlTarjeta += " AND nombre LIKE '" + nombre + "'";
            }
        }
    }

}
