/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1.conexionDB;

import com.mycompany.practica1.Frontend.estadoCuenta;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author alesso
 */
public class reporteTarjetas {

    public Connection connection;
    private String selectMovimientos;
    private String sqlMovimientos = "";
    private double interesNuevo = 0.0;

    public reporteTarjetas() {
        conexionDB conexion = new conexionDB();
        this.connection = conexion.connection;
    }

    public String[][] buscarMovimientos(String numero, String tipo, double saldo, double interes, estadoCuenta mensaje) {

        String[][] datosTabla = new String[0][0]; // Inicialmente una matriz vacía
        selectMovimientos = "SELECT m.tarjeta, m.fecha, m.descripcion, m.establecimiento, m.monto, m.tipo_movimiento, t.tipo, t.saldo "
                + "FROM movimientos m "
                + "JOIN tarjeta t ON m.tarjeta = t.numero"; // Suponiendo que tarjeta es un número y tipo de tarjeta se almacena en la tabla tarjeta
        cambioConsultaMovimientos(numero, tipo, saldo, interes);
        // Ejecutar la consulta y llenar la matriz de resultados
        try (Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); ResultSet resultSet = statement.executeQuery(selectMovimientos)) {

            int rowCount = 0;
            if (resultSet.last()) {
                rowCount = resultSet.getRow();
                resultSet.beforeFirst();
            }

            // Si no se encuentran resultados
            if (rowCount == 0) {
                mensaje.noHayElementos();
                return new String[0][0]; // Retorna una matriz vacía si no hay resultados
            }

            // Inicializar la matriz con el número de filas contadas y 8 columnas
            datosTabla = new String[rowCount][8];

            int index = 0;
            while (resultSet.next()) {
                datosTabla[index][0] = resultSet.getString("tarjeta");
                datosTabla[index][1] = resultSet.getDate("fecha").toString(); // Convertir Date a String
                datosTabla[index][2] = resultSet.getString("descripcion");
                datosTabla[index][3] = resultSet.getString("establecimiento");
                datosTabla[index][4] = Double.toString(resultSet.getDouble("monto")); // Convertir double a String

                String tipoMovimiento = resultSet.getString("tipo_movimiento");

                // Obtener el tipo de tarjeta y calcular el interés basado en el tipo
                String tipoTarjeta = resultSet.getString("tipo");
                double monto = resultSet.getDouble("monto");
                double saldoDB = resultSet.getDouble("saldo");
                interesNuevo = 0.0;

                if (tipoMovimiento.equals("CARGO")) {
                    switch (tipoTarjeta) {
                        case "NACIONAL":
                            interesNuevo = saldoDB * 0.012;
                            break;
                        case "REGIONAL":
                            interesNuevo = saldoDB * 0.023;
                            break;
                        case "INTERNACIONAL":
                            interesNuevo = saldoDB * 0.0375;
                            break;
                    }
                }

                datosTabla[index][5] = resultSet.getString("tipo_movimiento");
                datosTabla[index][6] = Double.toString(resultSet.getDouble("saldo"));
                datosTabla[index][7] = Double.toString(interesNuevo);                

                index++;
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar a la DB");
        }

        return datosTabla;
    }

    private void cambioConsultaMovimientos(String numero, String tipo, double saldo, double interes) {

        if (numero != null && !numero.isEmpty()) {
            sqlMovimientos += " AND m.tarjeta = '" + numero + "'";
        }

        if (tipo != null && !tipo.isEmpty() && !tipo.equals("NINGUNO")) {
            sqlMovimientos += " AND t.tipo = '" + tipo + "'";
        }

        if (saldo != 0 && saldo > 0) {
            sqlMovimientos += " AND t.saldo >= " + saldo;
        }

        if (interes != 0 && interes > 0) {
            // Solo buscar el interés cuando el tipo de movimiento es "CARGO"
            sqlMovimientos += " AND m.tipo_movimiento = 'CARGO' AND (";
            sqlMovimientos += "CASE t.tipo ";
            sqlMovimientos += "WHEN 'NACIONAL' THEN m.monto * 0.012 ";
            sqlMovimientos += "WHEN 'REGIONAL' THEN m.monto * 0.023 ";
            sqlMovimientos += "WHEN 'INTERNACIONAL' THEN m.monto * 0.0375 ";
            sqlMovimientos += "ELSE 0 ";
            sqlMovimientos += "END) >= " + interes;
        }

        // Agregar la cláusula WHERE si existen filtros
        if (!sqlMovimientos.isEmpty()) {
            selectMovimientos += sqlMovimientos;
        }
    }

}
