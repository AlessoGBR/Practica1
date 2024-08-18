/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1.conexionDB;

import com.mycompany.practica1.Backend.crearSolicitud;
import com.mycompany.practica1.Frontend.solicitudFr;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alesso
 */
public class crearSolicitudDB {

    public Connection connection;

    public crearSolicitudDB() {
        conexionDB conexion = new conexionDB();
        this.connection = conexion.connection;
    }

    public void crearSolicitud(crearSolicitud solicitud, solicitudFr mensaje) {
        String select = "SELECT COUNT(*) FROM solicitud WHERE No_solicitud = ?";
        String insert = "INSERT INTO solicitud (No_solicitud, nombre, salario, tipo, fecha, direccion) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statementSelect = connection.prepareStatement(select)) {
            statementSelect.setInt(1, solicitud.getNumero());

            ResultSet resultSet = statementSelect.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);

            if (count > 0) {
                mensaje.mensajes(1);
            } else {
                try (PreparedStatement statementInsert = connection.prepareStatement(insert)) {
                    statementInsert.setInt(1, solicitud.getNumero());
                    statementInsert.setString(2, solicitud.getNombre());
                    statementInsert.setDouble(3, solicitud.getSalario());
                    statementInsert.setString(4, solicitud.getTipo());
                    statementInsert.setDate(5, java.sql.Date.valueOf(solicitud.getFecha()));
                    statementInsert.setString(6, solicitud.getDireccion());
                    statementInsert.executeUpdate();
                    mensaje.mensajes(4);
                } catch (SQLException e) {
                    mensaje.mensajes(2);
                }
            }
        } catch (SQLException e) {
            mensaje.mensajes(3);
        }
    }
}
