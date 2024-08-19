/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1.Backend;

import com.mycompany.practica1.Frontend.movimientos;

/**
 *
 * @author alesso
 */
public class verificarMovimientos {

    public crearTarjeta tarjeta;
    private double cargo;
    private double abono;
    public boolean movimiento;

    public verificarMovimientos(crearTarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public void movimientoValido(String tipoCargo, double monto, movimientos mensajes) {
        // Verifica que tipo de movimiento realiza y si se puede efectuar
        if (tipoCargo.equals("ABONO")) {
            if (tarjeta.getSaldo() == 0) {
                mensajes.mensajeAlDia();
            } else {
                abono = tarjeta.getSaldo() - monto;
                tarjeta.setSaldo(abono);
                mensajes.mensajeAbono(tarjeta.getSaldo());
            }
        } else if (tipoCargo.equals("CARGO")) {
            if (monto > tarjeta.getLimite()) {
                mensajes.mensajeCargoMax();
            } else {
                cargo = tarjeta.getSaldo() + monto;
                if (cargo > tarjeta.getLimite()) {
                    mensajes.mensajeLimite();
                } else {
                    tarjeta.setSaldo(cargo);
                    mensajes.mensajeCargo(tarjeta.getSaldo(), tarjeta.getLimite());
                }

            }
        }
    }

}
