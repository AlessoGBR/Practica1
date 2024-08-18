/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1.conexionDB;

import com.mycompany.practica1.Backend.autoTarjetas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author alesso
 */
public class crearAutoDB {

    public Connection connection;
    public boolean solicitudEnviada;

    public crearAutoDB() {
        conexionDB conexion = new conexionDB();
        this.connection = conexion.connection;
    }

    public void crearAutorizacion(autoTarjetas solicitud) {

        solicitud.setAprovado(true);
        solicitudEnviada = true;
        String insert = "INSERT INTO autorizacion (solicitud, tipo, fecha, aprovada) "
                + "VALUES (?, ?, ?, ?)";

        try (PreparedStatement statementInsert = connection.prepareStatement(insert)) {
            statementInsert.setInt(1, solicitud.getNumeroSolicitud());
            statementInsert.setString(2, solicitud.getTipo());
            statementInsert.setDate(3, java.sql.Date.valueOf(solicitud.getFecha()));
            statementInsert.setBoolean(4, solicitud.isAprovado());
            statementInsert.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al insertar en la base de datos: " + e.getMessage());
        }

    }

    public boolean isSolicitudEnviada() {
        return solicitudEnviada;
    }

    public void setSolicitudEnviada(boolean solicitudEnviada) {
        this.solicitudEnviada = solicitudEnviada;
    }

}
