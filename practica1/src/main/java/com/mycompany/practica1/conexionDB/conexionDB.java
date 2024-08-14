/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1.conexionDB;

import com.mycompany.practica1.Backend.autoTarjetas;
import com.mycompany.practica1.Backend.crearSolicitud;
import com.mycompany.practica1.Backend.crearTarjeta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author alesso
 */
public class conexionDB {

    private static final String URL_MYSQL = "jdbc:mysql://localhost:3306/practica1";
    private static final String USER = "root";
    private static final String PASSWORD = "26359";
    private Connection connection;

    public conexionDB() {
        conectar();
    }

    private void conectar() {
        try {
            connection = DriverManager.getConnection(URL_MYSQL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error al connectar a la DB");
        }
    }

    public void crearSolicitud(crearSolicitud solicitud) {
        String insert = "INSERT INTO solicitud (No_solicitud, nombre, salario, tipo, fecha, direccion) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statementInsert = connection.prepareStatement(insert)) {
            statementInsert.setInt(1, solicitud.getNumero());
            statementInsert.setString(2, solicitud.getNombre());
            statementInsert.setDouble(3, solicitud.getSalario());
            statementInsert.setString(4, solicitud.getTipo());
            statementInsert.setDate(5, java.sql.Date.valueOf(solicitud.getFecha()));
            statementInsert.setString(6, solicitud.getDireccion());
            statementInsert.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar en la base de datos");
        }
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
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar a la DB");
        }
    }

    public void crearAutorizacion(autoTarjetas solicitud) {
        String insert = "INSERT INTO autorizacion (solicitud, tipo, fecha, aprovada) "
                + "VALUES (?, ?, ?, ?)";

        try (PreparedStatement statementInsert = connection.prepareStatement(insert)) {
            statementInsert.setInt(1, solicitud.getNumeroSolicitud());
            statementInsert.setString(2, solicitud.getTipo());
            statementInsert.setDate(3, java.sql.Date.valueOf(solicitud.getFecha()));
            statementInsert.setBoolean(4, solicitud.isAprovado());
            statementInsert.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar en la base de datos");
        }
    }

    public void crearTarjeta(crearTarjeta tarjeta) {
        String insert = "INSERT INTO tarjeta (numero, nombre, limite, tipo, estado, direccion, fecha) "
                + "VALUES (?, ?, ?, ?, ?, ?,?)";

        try (PreparedStatement statementInsert = connection.prepareStatement(insert)) {
            statementInsert.setString(1, tarjeta.getNumero());
            statementInsert.setString(2, tarjeta.getNombre());
            statementInsert.setDouble(3, tarjeta.getLimite());
            statementInsert.setString(4, tarjeta.getTipo());
            statementInsert.setBoolean(5, tarjeta.isEstado());
            statementInsert.setString(6, tarjeta.getDireccion());
            statementInsert.setDate(7, java.sql.Date.valueOf(tarjeta.getFecha()));
            statementInsert.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar en la base de datos");
        }

    }
}
