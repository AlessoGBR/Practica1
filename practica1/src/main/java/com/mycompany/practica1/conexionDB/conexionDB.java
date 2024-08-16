/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1.conexionDB;

import com.mycompany.practica1.Backend.autoTarjetas;
import com.mycompany.practica1.Backend.crearSolicitud;
import com.mycompany.practica1.Backend.crearTarjeta;
import com.mycompany.practica1.Backend.movimiento;
import com.mycompany.practica1.Frontend.cancelar;
import com.mycompany.practica1.Frontend.movimientos;
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
    public boolean tarjetaExistente;
    public boolean solicitudEnviada;
    public boolean solicitudExistente;

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
                solicitudExistente = auto.getNombre() != null;
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar a la DB");
        }
    }

    public void crearAutorizacion(autoTarjetas solicitud) {
        String consulta = "SELECT COUNT(*) FROM autorizacion WHERE solicitud = ?";

        try (PreparedStatement statementConsulta = connection.prepareStatement(consulta)) {
            statementConsulta.setInt(1, solicitud.getNumeroSolicitud());
            ResultSet resultSet = statementConsulta.executeQuery();

            if (resultSet.next() && resultSet.getInt(1) > 0) {
                solicitud.setAprovado(false);
                solicitudEnviada = false;
                return;
            }

            // Si no existe, realiza la inserción
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

        } catch (SQLException e) {
            System.out.println("Error al verificar la existencia de la solicitud: " + e.getMessage());
        }
    }

    public void crearTarjeta(crearTarjeta tarjeta) {
        String insert = "INSERT INTO tarjeta (numero, nombre, limite, tipo, estado, direccion, fecha, saldo) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statementInsert = connection.prepareStatement(insert)) {
            statementInsert.setString(1, tarjeta.getNumero());
            statementInsert.setString(2, tarjeta.getNombre());
            statementInsert.setDouble(3, tarjeta.getLimite());
            statementInsert.setString(4, tarjeta.getTipo());
            statementInsert.setBoolean(5, tarjeta.isEstado());
            statementInsert.setString(6, tarjeta.getDireccion());
            statementInsert.setDate(7, java.sql.Date.valueOf(tarjeta.getFecha()));
            statementInsert.setDouble(8, tarjeta.getSaldo());
            statementInsert.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar en la base de datos");
        }

    }

    public void consultarTarjeta(String numeroTarjeta, crearTarjeta tarjeta) {
        try {
            String select = "SELECT * FROM tarjeta WHERE numero = " + numeroTarjeta;
            Statement statementInsert = connection.createStatement();
            ResultSet resultSet = statementInsert.executeQuery(select);

            while (resultSet.next()) {
                tarjeta.setNumero(resultSet.getString("numero"));
                tarjeta.setNombre(resultSet.getString("nombre"));
                tarjeta.setLimite(resultSet.getDouble("limite"));
                tarjeta.setTipo(resultSet.getString("tipo"));
                tarjeta.setEstado(resultSet.getBoolean("estado"));
                tarjeta.setDireccion(resultSet.getString("direccion"));
                tarjeta.setFecha(resultSet.getString("fecha"));
                tarjeta.setSaldo(resultSet.getDouble("saldo"));
                if (tarjeta.getNombre() == null) {
                    tarjetaExistente = false;
                } else {
                    tarjetaExistente = true;
                }

            }

        } catch (SQLException e) {
            System.out.println("Error al consultar a la DB");
        }
    }

    public void cancelarTarjeta(crearTarjeta tarjeta, cancelar mensaje) {
        try {
            String update = "UPDATE tarjeta SET estado = false WHERE numero = ?";

            try (PreparedStatement statementUpdate = connection.prepareStatement(update)) {
                statementUpdate.setString(1, tarjeta.getNumero());

                int rowsAffected = statementUpdate.executeUpdate(); // Ejecuta la actualización
                if (rowsAffected > 0) {
                    mensaje.mensaje();
                } else {
                    mensaje.mensajeError();
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar el estado en la base de datos");
        }

    }

    public void actualizarSaldoTarjeta(crearTarjeta tarjeta, movimientos mensaje) {
        try {
            String update = "UPDATE tarjeta SET saldo = ? WHERE numero = ?";

            try (PreparedStatement statementUpdate = connection.prepareStatement(update)) {
                statementUpdate.setDouble(1, tarjeta.getSaldo());
                statementUpdate.setString(2, tarjeta.getNumero());

                int rowsAffected = statementUpdate.executeUpdate(); // Ejecuta la actualización
                if (rowsAffected > 0) {
                    mensaje.mensaje();
                } else {
                    mensaje.mensajeError();
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar el estado en la base de datos");
        }
    }

    public void crearMovimiento(crearTarjeta tarjeta, movimiento movimientos) {
        String insert = "INSERT INTO movimientos (tarjeta, fecha, descripcion, establecimiento, monto, tipo_movimiento) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statementInsert = connection.prepareStatement(insert)) {
            statementInsert.setString(1, movimientos.getTarjeta());
            statementInsert.setString(2, movimientos.getFecha());
            statementInsert.setString(3, movimientos.getDescripcion());
            statementInsert.setString(4, movimientos.getEstablecimiento());
            statementInsert.setDouble(5, movimientos.getMonto());
            statementInsert.setString(6, movimientos.getMovimiento());
            statementInsert.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar en la base de datos");
        }
    }

    public boolean isSolicitudEnviada() {
        return solicitudEnviada;
    }

}
