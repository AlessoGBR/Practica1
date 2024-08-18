/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1.conexionDB;

import com.mycompany.practica1.Backend.autoTarjetas;
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
    public Connection connection;
    public boolean solicitudExistente;
    public boolean solicitudEnviada;

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

}
