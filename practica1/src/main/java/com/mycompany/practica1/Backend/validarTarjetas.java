/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1.Backend;

import com.mycompany.practica1.conexionDB.conexionDB;
import java.util.Random;

/**
 *
 * @author alesso
 */
public class validarTarjetas {

    private static final int LIMITE_NACIONAL = 5000;
    private static final int LIMITE_REGIONAL = 10000;
    private static final int LIMITE_INTERNACIONAL = 20000;
    private static final String NUMERO_NACIONAL = "42563102654";
    private static final String NUMERO_REGIONAL = "42563102656";
    private static final String NUMERO_INTERNACIONAL = "42563102658";

    private double limite;

    private autoTarjetas auto;
    private conexionDB conexion;
    private String numeroTarjeta;

    public validarTarjetas(autoTarjetas auto, conexionDB conexion) {
        this.auto = auto;
        this.conexion = conexion;
    }

    public void validacionTarjetas() {
        limite = auto.getSalario() * 0.6;
        switch (auto.getTipo()) {
            case "NACIONAL":
                if (limite <= LIMITE_NACIONAL) {
                    auto.setAprovado(false);
                } else {
                    auto.setAprovado(true);
                    autorizarTarjeta();
                }   break;
            case "REGIONAL":
                if (limite <= LIMITE_REGIONAL) {
                    auto.setAprovado(false);
                } else {
                    auto.setAprovado(true);
                    autorizarTarjeta();
                }   break;
            case "INTERNACIONAL":
                if (limite <= LIMITE_INTERNACIONAL) {
                    auto.setAprovado(false);
                } else {
                    auto.setAprovado(true);
                    
                }   break;
            default:
                break;
        }
        
        autorizarTarjeta();

    }

    private void autorizarTarjeta() {
        conexion.crearAutorizacion(auto);
        if (auto.isAprovado()) {
            auto.setAutorizado(1);
            crearTarjeta();
        } else {
            auto.setAutorizado(2);
        }

    }

    private void crearTarjeta() {

        crearTarjeta tarjeta = new crearTarjeta();
        Random random = new Random();
        tarjeta.setNombre(auto.getNombre());
        tarjeta.setTipo(auto.getTipo());
        tarjeta.setDireccion(auto.getDireccion());
        tarjeta.setEstado(true);
        tarjeta.setFecha(auto.getFecha());
        tarjeta.setSaldo(0);
        int num1 = random.nextInt(0, 9);
        int num2 = random.nextInt(0, 9);
        int num3 = random.nextInt(0, 9);
        int num4 = random.nextInt(0, 9);
        int num5 = random.nextInt(0, 9);

        if (auto.getTipo().equals("NACIONAL")) {
            numeroTarjeta = NUMERO_NACIONAL + num1 + num2 + num3 + num4 + num5;
            tarjeta.setLimite(5000);
            tarjeta.setNumero(numeroTarjeta);
        } else if (auto.getTipo().equals("REGIONAL")) {
            numeroTarjeta = NUMERO_REGIONAL + num1 + num2 + num3 + num4 + num5;
            tarjeta.setLimite(10000);
            tarjeta.setNumero(numeroTarjeta);
        } else if (auto.getTipo().equals("INTERNACIONAL")) {
            numeroTarjeta = NUMERO_INTERNACIONAL + num1 + num2 + num3 + num4 + num5;
            tarjeta.setLimite(20000);
            tarjeta.setNumero(numeroTarjeta);
        }

        conexion.crearTarjeta(tarjeta);

    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

}
