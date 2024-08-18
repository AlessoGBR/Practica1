/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.practica1.Frontend;

import com.mycompany.practica1.Backend.autoTarjetas;
import com.mycompany.practica1.Backend.leerArchivos;
import com.mycompany.practica1.Backend.validarTarjetas;
import com.mycompany.practica1.conexionDB.consultaTarjetaDB;
import com.mycompany.practica1.conexionDB.consultarSolicitudDB;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author alesso
 */
public class autorizacion extends javax.swing.JFrame {

    private autoTarjetas autorizacion;
    private consultaTarjetaDB consultaDB;
    private validarTarjetas validar;
    private String nombre;
    private int numero;

    public autorizacion() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtSolicitud = new javax.swing.JTextField();
        btnAutorizar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("AUTORIZACION");
        setResizable(false);

        jLabel1.setText("AUTORIZACION DE TARJETA");

        jLabel2.setText("INGRESAR AUTORIZACION");

        btnBuscar.setText("BUSCAR");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setText("AUTORIZAR TARJETA");

        jLabel4.setText("No. SOLICITUD:");

        btnAutorizar.setText("VERIFICAR");
        btnAutorizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAutorizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAutorizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel4))
                            .addComponent(jLabel3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(txtSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(btnAutorizar)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAutorizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnRegresar.setText("REGRESAR");
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(btnBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRegresar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addGap(32, 32, 32)
                .addComponent(btnRegresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        menuPrincipal menu = new menuPrincipal();
        this.setVisible(false);
        menu.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnAutorizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutorizarActionPerformed
        if (txtSolicitud.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "NO SE INGRESO NUMERO DE SOLICITUD", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            // Intentar convertir el texto a un número entero
            int solicitud = Integer.parseInt(txtSolicitud.getText());
            // Si la conversión es exitosa, puedes continuar con el procesamiento
            // realizamos las operaciones para ver si la solicitud es apta para la aprovacion de la tarjeta
            autorizacion = new autoTarjetas();
            consultaDB = new consultaTarjetaDB();
            consultarSolicitudDB consulta = new consultarSolicitudDB();
            if (consultaDB.verificarSolicitud(autorizacion)) {
                if (consulta.solicitudExistente) {
                    validar = new validarTarjetas(autorizacion, consultaDB);
                    validar.validacionTarjetas();
                    autorizado();

                } else {
                    noExisteSolicitud();
                }
            } else {
                JOptionPane.showMessageDialog(null, "NUMERO DE SOLICITUD YA REGISTRADO", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException ex) {
            // Si la conversión falla, muestra un mensaje de error
            JOptionPane.showMessageDialog(null, "POR FAVOR INGRESE UNA SOLICITUD VALIDA", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAutorizarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // Crear una instancia de JFileChooser
        JFileChooser fileChooser = new JFileChooser();

        // Establecer el modo de selección de archivos (solo archivos)
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        // Crear un filtro para archivos .txt
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto", "txt");
        fileChooser.setFileFilter(filter);

        // Mostrar el file chooser y capturar la respuesta del usuario
        int result = fileChooser.showOpenDialog(this);

        // Procesar la respuesta del usuario
        if (result == JFileChooser.APPROVE_OPTION) {
            // Obtener el archivo seleccionado
            File selectedFile = fileChooser.getSelectedFile();
            // Mostrar la ruta del archivo seleccionado
            leerArchivos leer = new leerArchivos();
            numero = leer.leerAutorizacion(selectedFile.getAbsolutePath());
            if (numero == 2) {
                formato();
            } else {
                ingresoAutorizacion(numero);
            }

        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    public void autorizado() {
        boolean autoriazado = autorizacion.isAprovado();
        txtSolicitud.setText("");
        if (autoriazado) {
            JOptionPane.showMessageDialog(null, "TARJETA AUTORIZADA");
            nombre = autorizacion.getNombre();
            tarjeta tarjeta = new tarjeta(validar.getNumeroTarjeta(), nombre);
            this.setVisible(false);
            tarjeta.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "TARJETA DENEGADA");
        }

    }

    private void noExisteSolicitud() {
        JOptionPane.showMessageDialog(null, "SOLICITUD NO REGISTRADA");
    }

    private void ingresoAutorizacion(int numero) {
        txtSolicitud.setText(numero + "");
    }

    private void formato() {
        JOptionPane.showMessageDialog(null, "FORMATO DEL DOCUMENTO INCORRECTO", "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAutorizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtSolicitud;
    // End of variables declaration//GEN-END:variables
}
