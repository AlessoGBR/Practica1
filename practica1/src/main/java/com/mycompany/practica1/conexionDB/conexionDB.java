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
import com.mycompany.practica1.Frontend.estadoCuenta;
import com.mycompany.practica1.Frontend.listadoSolicitudes;
import com.mycompany.practica1.Frontend.listadoTarjetas;
import com.mycompany.practica1.Frontend.movimientos;
import com.mycompany.practica1.Frontend.solicitudFr;
import java.sql.Connection;
import java.sql.DriverManager;
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

    public boolean verificarSolicitud(autoTarjetas tarjeta) {
        String consulta = "SELECT COUNT(*) FROM autorizacion WHERE solicitud = ?";

        try (PreparedStatement statementConsulta = connection.prepareStatement(consulta)) {
            statementConsulta.setInt(1, tarjeta.getNumeroSolicitud());
            ResultSet resultSet = statementConsulta.executeQuery();

            if (resultSet.next() && resultSet.getInt(1) > 0) {
                tarjeta.setAprovado(false);
                solicitudEnviada = false;
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar la existencia de la solicitud: " + e.getMessage());
        }

        return true;
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
                tarjetaExistente = tarjeta.getNombre() != null;

            }

        } catch (SQLException e) {
            System.out.println("Error al consultar a la DB");
        }
    }

    public void cancelarTarjeta(crearTarjeta tarjeta, cancelar mensaje) {
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

    private String sqlTarjeta = "SELECT * FROM tarjeta";

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

    private String select;
    private String sqlSolicitud = "";

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

    private String selectMovimientos;
    private String sqlMovimientos = "";
    private double interesNuevo = 0.0;

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
                interesNuevo = 0.0;

                if (tipoMovimiento.equals("CARGO")) {
                    switch (tipoTarjeta) {
                        case "NACIONAL":
                            interesNuevo = monto * 0.012;
                            break;
                        case "REGIONAL":
                            interesNuevo = monto * 0.023;
                            break;
                        case "INTERNACIONAL":
                            interesNuevo = monto * 0.0375;
                            break;
                    }
                }

                datosTabla[index][5] = resultSet.getString("tipo_movimiento");
                datosTabla[index][6] = Double.toString(interesNuevo);
                datosTabla[index][7] = Double.toString(resultSet.getDouble("saldo"));

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
