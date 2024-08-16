/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.practica1.Frontend;

import com.mycompany.practica1.Backend.crearTarjeta;
import com.mycompany.practica1.Backend.movimiento;
import com.mycompany.practica1.Backend.verificarMovimientos;
import com.mycompany.practica1.conexionDB.conexionDB;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author alesso
 */
public class movimientos extends javax.swing.JFrame {

    private double monto;
    private boolean movimiento;

    /**
     * Creates new form movimientos
     */
    public movimientos() {
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTarjeta = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        txtEstablecimiento = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtMonto = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        cbMovimiento = new javax.swing.JComboBox<>();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MOVIMIENTOS");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel1.setText("MOVIMIENTOS TARJETA");

        jLabel2.setText("INGRESAR DOCUMENTO");

        btnBuscar.setText("BUSCAR");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel3.setText("FORMULARIO MOVIMIENTOS");

        jLabel4.setText("NUMERO DE TARJETA:");

        jLabel5.setText("FECHA:");

        jLabel6.setText("TIPO DE MOVIMIENTO");

        jLabel7.setText("DESCRIPCION:");

        jLabel8.setText("ESTABLECIMIENTO");

        jLabel9.setText("MONTO");

        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        cbMovimiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CARGO", "ABONO" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnRegistrar)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9))
                            .addGap(79, 79, 79)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtMonto, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                                .addComponent(txtEstablecimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                                .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                                .addComponent(txtTarjeta, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                                .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                                .addComponent(cbMovimiento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtEstablecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(btnRegistrar)
                .addContainerGap())
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
                        .addGap(116, 116, 116)
                        .addComponent(btnBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(btnRegresar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel2)))
                .addGap(46, 46, 46)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addGap(32, 32, 32))
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
            JOptionPane.showMessageDialog(this, "Archivo seleccionado: " + selectedFile.getAbsolutePath());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (txtTarjeta.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "POR FAVOR INGRESE EL NUMERO DE TARJETA", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (txtFecha.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "POR FAVOR INGRESE UNA FECHA CORRECTA", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (txtDescripcion.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "POR FAVOR INGRESE UNA DESCRIPCION", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (txtEstablecimiento.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "POR FAVOR INGRESE EL CODIGO DEL ESTABLECIMIENTO", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (txtMonto.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "POR FAVOR INGRESE UN MONTO", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        try {
            // Intentar convertir el texto a un número entero
            monto = Double.parseDouble(txtMonto.getText());

        } catch (NumberFormatException ex) {
            // Si la conversión falla, muestra un mensaje de error
            JOptionPane.showMessageDialog(null, "POR FAVOR INGRESE UN MONTO VALIDO", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (cbMovimiento.getSelectedItem().toString().equals("CARGO")) {
            movimiento = true;
        } else if (cbMovimiento.getSelectedItem().toString().equals("ABONO")) {
            movimiento = false;
        }
        conexionDB conexion = new conexionDB();
        crearTarjeta tarjeta = new crearTarjeta();
        conexion.consultarTarjeta(txtTarjeta.getText(), tarjeta);
        movimiento movimientos = new movimiento();
        if (conexion.tarjetaExistente) {
            verificarMovimientos vrMovimiento = new verificarMovimientos(tarjeta);
            vrMovimiento.movimientoValido(cbMovimiento.getSelectedItem().toString(), monto, this);
            conexion.actualizarSaldoTarjeta(tarjeta, this);
            actualizarMovimiento(movimientos);
            conexion.crearMovimiento(tarjeta, movimientos);
        } else {
            JOptionPane.showMessageDialog(null, "TARJETA NO ENCONTRADA", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnRegistrarActionPerformed

    public void mensaje() {
        JOptionPane.showMessageDialog(null, "MOVIMIENTO REALIZADO");
    }

    public void mensajeError() {
        JOptionPane.showMessageDialog(null, "NO SE PUDO REALIZAR EL MOVIMIENTO", "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    public void actualizarMovimiento(movimiento movimiento) {
        movimiento.setTarjeta(txtTarjeta.getText());
        movimiento.setDescripcion(txtDescripcion.getText());
        movimiento.setEstablecimiento(txtEstablecimiento.getText());
        movimiento.setMovimiento(cbMovimiento.getSelectedItem().toString());
        movimiento.setMonto(monto);
        movimiento.setFecha(txtFecha.getText());
    }

    public void mensajeAlDia() {
        JOptionPane.showMessageDialog(null, "TIENES LOS PAGOS AL DIA");
    }

    public void mensajeAbono(double saldo) {
        JOptionPane.showMessageDialog(null, "ABONO DE LA TARJETA, SALDO PENDIENTE: " + saldo);
    }

    public void mensajeCargoMax() {
        JOptionPane.showMessageDialog(null, "NO PUEDES SUPERAR EL LIMITE DE LA TARJETA", "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    public void mensajeLimite() {
        JOptionPane.showMessageDialog(null, "EL SALDO NO ES SUFICIENTE PARA REALIZAR EL CARGO", "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    public void mensajeCargo(double saldo, double limite) {
        double total = limite - saldo;
        JOptionPane.showMessageDialog(null, "CARGO REALIZADO,SALDO PENDIENTE: " + total );
    }
    
    public void mensajeTarjeta(){
        JOptionPane.showMessageDialog(null, "TARJETA INACTIVA NO PUEDES REALIZAR MOVIMIENTOS", "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnRegistrar;
    javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbMovimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtEstablecimiento;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtTarjeta;
    // End of variables declaration//GEN-END:variables
}
