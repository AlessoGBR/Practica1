/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1.conexionDB;

import com.mycompany.practica1.Backend.autoTarjetas;
import com.mycompany.practica1.Backend.crearTarjeta;
import com.mycompany.practica1.Backend.movimiento;
import com.mycompany.practica1.Frontend.cancelar;
import com.mycompany.practica1.Frontend.movimientos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author alesso
 */
public class consultaTarjetaDB {

    public Connection connection;
    public boolean tarjetaExistente;
    public boolean solicitudEnviada;
    public boolean solicitudExistente;
    public boolean tarjetaActiva;

    public consultaTarjetaDB() {
        conexionDB conexion = new conexionDB();
        this.connection = conexion.connection;
    }

    public void consultarSolicitud(int numeroSoli, autoTarjetas auto) {
        // Verficamos si existe una solicitud
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

    public boolean verificarSolicitud(autoTarjetas tarjeta) {
        String consulta = "SELECT 1 FROM autorizacion WHERE solicitud = ? LIMIT 1";

        try (PreparedStatement statementConsulta = connection.prepareStatement(consulta)) {
            int numeroSolicitud = tarjeta.getNumeroSolicitud();

            // Establecer el número de solicitud en la consulta
            statementConsulta.setInt(1, numeroSolicitud);

            // Ejecutar la consulta
            ResultSet resultSet = statementConsulta.executeQuery();

            // Si se encuentra al menos un resultado, la solicitud existe
            if (resultSet.next()) {
                // Actualizar el estado de la tarjeta
                tarjeta.setAprovado(false);
                solicitudEnviada = false;
                return false; // La solicitud ya existe
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar la existencia de la solicitud");
        }

        return true; // Retornar true si no se encontró la solicitud
    }

    public void crearAutorizacion(autoTarjetas solicitud) {
        // Insertamos una nueva autorizacion
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

    public void crearAutorizacionDenegada(autoTarjetas solicitud) {
        //Denegamos una solicitud en la base de datos
        solicitud.setAprovado(false);
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

    public void crearTarjeta(crearTarjeta tarjeta) {
        //Insertamos una nueva tarjeta en la base 
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

    public void crearMovimiento(crearTarjeta tarjeta, movimiento movimientos) {
        //Insertamos un nuevo movimiento en la base 
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

    public void consultarTarjeta(String numeroTarjeta, crearTarjeta tarjeta) {
        //Consultamos si existe una tarjeta
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
                tarjetaExistente = tarjeta.getNombre() != null;
                tarjetaActiva = tarjeta.isEstado();
            }

        } catch (SQLException e) {
            
        }
    }

    public void actualizarSaldoTarjeta(crearTarjeta tarjeta, movimientos mensaje) {
        //Actualizamos una tarjeta en la base cuando se efectua un movimiento
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

    public void cancelarTarjeta(crearTarjeta tarjeta, cancelar mensaje) {
        //Actualizamos la tarjeta en la base y cambiamos su estado a inactivo
        try {
            String update = "UPDATE tarjeta SET estado = false, fecha = ? WHERE numero = ?";

            try (PreparedStatement statementUpdate = connection.prepareStatement(update)) {
                LocalDate fechaActual = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String fechaFormateada = fechaActual.format(formatter);

                statementUpdate.setString(1, fechaFormateada);
                statementUpdate.setString(2, tarjeta.getNumero());

                int rowsAffected = statementUpdate.executeUpdate();
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

    public boolean isTarjetaExistente() {
        return tarjetaExistente;
    }

    public void setTarjetaExistente(boolean tarjetaExistente) {
        this.tarjetaExistente = tarjetaExistente;
    }

}
