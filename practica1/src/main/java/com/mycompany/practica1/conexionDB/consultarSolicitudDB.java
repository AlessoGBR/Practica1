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

    public void consultarSolicitud(String numeroSoli, autoTarjetas auto) {
        try {
            String select = "SELECT * FROM solicitud WHERE No_solicitud = " + numeroSoli;
            Statement statementInsert = connection.createStatement();
            ResultSet resultSet = statementInsert.executeQuery(select);

            if (resultSet.next()) { // Verifica si existe alguna fila en el ResultSet
                // Si existe, asigna los valores a la instancia de autoTarjetas
                auto.setNumeroSolicitud(resultSet.getInt("No_solicitud"));
                auto.setNombre(resultSet.getString("nombre"));
                auto.setSalario(resultSet.getDouble("salario"));
                auto.setTipo(resultSet.getString("tipo"));
                auto.setFecha(resultSet.getString("fecha"));
                auto.setDireccion(resultSet.getString("direccion"));
                solicitudExistente = true; // Establece que la solicitud existe
            } else {
                solicitudExistente = false; // Si no hay filas, la solicitud no existe
                System.out.println("La solicitud con el número " + numeroSoli + " no existe.");
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar a la DB: " + e.getMessage());
        }
    }

    public boolean isSolicitudExistente() {
        return solicitudExistente;
    }

    public void setSolicitudExistente(boolean solicitudExistente) {
        this.solicitudExistente = solicitudExistente;
    }

}
