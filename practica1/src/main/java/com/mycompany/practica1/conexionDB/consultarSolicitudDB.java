/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1.conexionDB;

import com.mycompany.practica1.Backend.autoTarjetas;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author alesso
 */
public class consultarSolicitudDB {

    public Connection connection;
    public boolean solicitudExistente;

    public consultarSolicitudDB() {
        conexionDB conexion = new conexionDB();
        this.connection = conexion.connection;
    }

    public void consultarSolicitud(int numeroSoli, autoTarjetas auto) {
        try {
            String select = "SELECT * FROM solicitud WHERE No_solicitud = " + numeroSoli;
            Statement statementInsert = connection.createStatement();
            ResultSet resultSet = statementInsert.executeQuery(select);

            while (resultSet.next()) {
                auto.setNumeroSolicitud(resultSet.getInt("No_solicitud"));
                auto.setNombre(resultSet.getString("nombre"));
                auto.setSalario(resultSet.getDouble("salario"));
                auto.setTipo(resultSet.getString("tipo"));
                auto.setFecha(resultSet.getString("fecha"));
                auto.setDireccion(resultSet.getString("direccion"));
                solicitudExistente = auto.getNombre() != null;
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar a la DB");
        }
    }

    public boolean isSolicitudExistente() {
        return solicitudExistente;
    }

    public void setSolicitudExistente(boolean solicitudExistente) {
        this.solicitudExistente = solicitudExistente;
    }

}
