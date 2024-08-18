/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.practica1.Frontend;

import com.mycompany.practica1.Backend.crearTarjeta;
import com.mycompany.practica1.Backend.leerArchivos;
import com.mycompany.practica1.conexionDB.conexionDB;
import com.mycompany.practica1.conexionDB.consultaTarjetaDB;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author alesso
 */
public class cancelar extends javax.swing.JFrame {

    private conexionDB conexion;
    private crearTarjeta tarjeta;
    private consultaTarjetaDB consulta;

    private int cancelacion;

    public cancelar() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNumeroF = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtSaldo = new javax.swing.JTextField();
        btnCance = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("CANCELAR");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel1.setText("CANCELAR TARJETAS");

        jLabel2.setText("INGRESE EL NUMERO DE LA TARJETA");

        jLabel3.setText("A CANCELAR SIN ESPACIOS");

        btnBuscar.setText("BUSCAR");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnRegresar.setText("REGRESAR");
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel4.setText("DATOS DE LA TARJETA");

        jLabel5.setText("NOMBRE:");

        jLabel6.setText("NUMERO:");

        jLabel7.setText("ESTADO:");

        txtNumeroF.setEnabled(false);

        txtNombre.setEnabled(false);

        txtSaldo.setEnabled(false);

        btnCance.setText("CANCELAR");
        btnCance.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanceActionPerformed(evt);
            }
        });

        jLabel8.setText("SALDO:");

        txtEstado.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 60, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSaldo)
                                    .addComponent(txtNombre)
                                    .addComponent(txtNumeroF)
                                    .addComponent(txtEstado)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCance)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNumeroF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(btnCance)
                .addContainerGap())
        );

        btnIngresar.setText("INGRESAR");
        btnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 35, Short.MAX_VALUE)
                        .addComponent(btnIngresar)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)
                        .addGap(99, 99, 99))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(15, 15, 15)
                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscar)
                            .addComponent(btnIngresar))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegresar)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        // Aceptar solo archivos .txt
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto", "txt");
        fileChooser.setFileFilter(filter);

        // Mostrar el file chooser y capturar la respuesta del usuario
        int result = fileChooser.showOpenDialog(this);

        // Procesar la respuesta del usuario
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            leerArchivos leer = new leerArchivos();
            tarjeta = new crearTarjeta();
            if (leer.leerCancelacion(selectedFile.getAbsolutePath(), tarjeta)) {
                consulta = new consultaTarjetaDB();
                consulta.consultarTarjeta(tarjeta.getNumero(), tarjeta);
                txtNumero.setText(tarjeta.getNumero());
                txtNumeroF.setText(tarjeta.getNumero());
                txtNombre.setText(tarjeta.getNombre());
                txtSaldo.setText(tarjeta.getSaldo() + "");
                if (tarjeta.isEstado()) {
                    txtEstado.setText("ACTIVA");
                } else {
                    txtEstado.setText("INACTIVA");
                }
            } else {
                JOptionPane.showMessageDialog(null, "FORMATO DEL DOCUMENTO INCORRECTO", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(this, "SELECCION CANCELADA");
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        menuPrincipal menu = new menuPrincipal();
        this.setVisible(false);
        menu.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnCanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanceActionPerformed
        if (txtNumero.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "POR FAVOR INGRESE EL NUMERO DE TARJETA", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        int option = JOptionPane.showConfirmDialog(null, "SEGURO QUE QUIERES CANCELAR LA TARJETA?", "ELECCION", JOptionPane.YES_NO_OPTION);

        // Evaluar la opción seleccionada
        if (option == JOptionPane.YES_OPTION) {
            consulta = new consultaTarjetaDB();
            tarjeta = new crearTarjeta();
            consulta.consultarTarjeta(txtNumero.getText(), tarjeta);

            if (consulta.tarjetaExistente) {
                if (tarjeta.cancelarTarjeta()) {
                    consulta.cancelarTarjeta(tarjeta, this);
                } else {
                    JOptionPane.showMessageDialog(null, "TIENES SALDO PENDIENTE O LA TARJETA YA ESTA CANCELADA", "ERROR", JOptionPane.ERROR_MESSAGE);
                    borrar();
                }
            } else {
                mensajeError();
            }

        } else if (option == JOptionPane.NO_OPTION) {

        }
    }//GEN-LAST:event_btnCanceActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        if (txtNumero.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "INGRESE UN NUMERO DE TARJETA", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (txtNumero.getText().matches("\\d+")) {
            consulta = new consultaTarjetaDB();
            tarjeta = new crearTarjeta();
            consulta.consultarTarjeta(txtNumero.getText(), tarjeta);
            if (consulta.tarjetaExistente) {
                txtNumeroF.setText(tarjeta.getNumero());
                txtNombre.setText(tarjeta.getNombre());
                txtSaldo.setText(tarjeta.getSaldo() + "");
                if (tarjeta.isEstado()) {
                    txtEstado.setText("ACTIVA");
                } else {
                    txtEstado.setText("INACTIVA");
                }
            } else {
                mensajeError();
            }
        } else {
            JOptionPane.showMessageDialog(null, "INGRESE UN NUMERO DE TARJETA CORRECTO", "TARJETA", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btnIngresarActionPerformed

    public void mensajeError() {
        JOptionPane.showMessageDialog(null, "NO SE ENCONTRO LA TARJETA", "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    public void mensaje() {
        JOptionPane.showMessageDialog(null, "LA TARJETA HA SIDO CANCELADA", "TARJETA", JOptionPane.INFORMATION_MESSAGE);
        borrar();
    }

    private void borrar() {
        txtNumero.setText("");
        txtNumeroF.setText("");
        txtNombre.setText("");
        txtSaldo.setText("");
        txtEstado.setText("");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCance;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtNumeroF;
    private javax.swing.JTextField txtSaldo;
    // End of variables declaration//GEN-END:variables
}
