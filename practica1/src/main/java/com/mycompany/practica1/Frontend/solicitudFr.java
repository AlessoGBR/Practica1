/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.practica1.Frontend;

import com.mycompany.practica1.Backend.crearSolicitud;
import com.mycompany.practica1.Backend.leerArchivos;
import com.mycompany.practica1.conexionDB.conexionDB;
import com.mycompany.practica1.conexionDB.crearSolicitudDB;
import java.io.File;
import java.text.SimpleDateFormat;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.Date;

/**
 *
 * @author alesso
 */
public class solicitudFr extends javax.swing.JFrame {

    private int solicitudId;
    private double salario;
    private conexionDB conexion;
    private crearSolicitud solicitud;

    public solicitudFr() {
        initComponents();
        fechaActual();
        txtFecha.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNombre = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtSalario = new javax.swing.JTextPane();
        cbTarjetas = new javax.swing.JComboBox<>();
        btnSolicitar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtSolicitud = new javax.swing.JTextPane();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtDireccion = new javax.swing.JTextPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtFecha = new javax.swing.JTextPane();
        btnRegresar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("SOLICITUD");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setResizable(false);

        jLabel2.setText("INGRESAR SOLICITUD");

        btnIngresar.setText("INGRESAR");
        btnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel3.setText("CREAR SOLICITUD DE TARJETA ");

        jLabel4.setText("NOMBRE:");

        jScrollPane1.setViewportView(txtNombre);

        jLabel5.setText("SALARIO:");

        jLabel6.setText("TIPO DE TARJETA:");

        jLabel7.setText("DIRECCION:");

        jScrollPane3.setViewportView(txtSalario);

        cbTarjetas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NACIONAL", "REGIONAL", "INTERNACIONAL" }));

        btnSolicitar.setText("SOLICITAR");
        btnSolicitar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSolicitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitarActionPerformed(evt);
            }
        });

        jLabel9.setText("No. SOLICITUD:");

        jScrollPane4.setViewportView(txtSolicitud);

        jLabel10.setText("FECHA:");

        jScrollPane6.setViewportView(txtDireccion);

        txtFecha.setToolTipText("");
        jScrollPane7.setViewportView(txtFecha);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel3)
                    .addComponent(btnSolicitar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(91, 91, 91))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addGap(24, 24, 24)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6)
                            .addComponent(cbTarjetas, 0, 253, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                                    .addComponent(jScrollPane3)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane7))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5))
                        .addGap(24, 24, 24)
                        .addComponent(jLabel7))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbTarjetas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(btnSolicitar)
                .addContainerGap())
        );

        btnRegresar.setText("REGRESAR");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel8.setText("SOLICITUD DE TARJETA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnRegresar)
                                    .addComponent(btnIngresar))))))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(34, 34, 34)
                .addComponent(btnIngresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
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
            crearSolicitud solicitudTarjeta = new crearSolicitud();
            leerArchivos leer = new leerArchivos();

            if (leer.leerSolicitud(selectedFile.getAbsolutePath(), solicitudTarjeta)) {
                ingresoSolicitud(solicitudTarjeta);
            } else {
                mensajes(5);
            }

        } else {
            JOptionPane.showMessageDialog(this, "SELECCION CANCELADA");
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnSolicitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitarActionPerformed
        if (txtSolicitud.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "NO SE INGRESO UNA SOLICITUD");
            return;
        } else if (txtNombre.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "NO SE INGRESO UN NOMBRE");
            return;
        } else if (txtSalario.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "NO SE INGRESO UN SALARIO");
            return;
        } else if (txtDireccion.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "NO SE INGRESO UNA DIRECCION");
            return;
        } else if (txtFecha.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "NO SE INGRESO UNA FECHA");
            return;
        }

        try {
            // Intentar convertir el texto a un número entero
            solicitudId = Integer.parseInt(txtSolicitud.getText());

        } catch (NumberFormatException ex) {
            // Si la conversión falla, muestra un mensaje de error
            JOptionPane.showMessageDialog(null, "POR FAVOR INGRESE UNA SOLICITUD VALIDA", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Intentar convertir el texto a un número entero
            salario = Double.parseDouble(txtSalario.getText());

            // Si la conversión es exitosa, puedes continuar con el procesamiento            
        } catch (NumberFormatException ex) {
            // Si la conversión falla, muestra un mensaje de error
            JOptionPane.showMessageDialog(null, "POR FAVOR INGRESE UN SALARIO VALIDO", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (txtNombre.getText().length() >= 100) {
            JOptionPane.showMessageDialog(null, "NOMBRE DEMASIADO LARGO", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (txtDireccion.getText().length() >= 150) {
            JOptionPane.showMessageDialog(null, "DIRECCION DEMASIADA LARGA", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        solicitud = new crearSolicitud(solicitudId, txtNombre.getText(), salario, txtDireccion.getText(), txtFecha.getText(),
                cbTarjetas.getSelectedItem().toString());
        crearSolicitudDB solicitudDB = new crearSolicitudDB();
        solicitudDB.crearSolicitud(solicitud, this);

    }//GEN-LAST:event_btnSolicitarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        menuPrincipal menu = new menuPrincipal();
        this.setVisible(false);
        menu.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void ingresoSolicitud(crearSolicitud solicitud) {
        txtSolicitud.setText(solicitud.getNumero() + "");
        txtNombre.setText(solicitud.getNombre());
        txtSalario.setText(solicitud.getSalario() + "");
        txtDireccion.setText(solicitud.getDireccion());
        txtFecha.setText(solicitud.getFecha());
        if (solicitud.getTipo().equals("NACIONAL")) {
            cbTarjetas.setSelectedIndex(0);
        } else if (solicitud.getTipo().equals("REGIONAL")) {
            cbTarjetas.setSelectedIndex(1);
        } else if (solicitud.getTipo().equals("INTERNACIONAL")) {
            cbTarjetas.setSelectedIndex(2);
        }
    }

    private void fechaActual() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fechaActual = dateFormat.format(new Date());

        txtFecha.setText(fechaActual);
    }

    public void mensajes(int tipo) {
        switch (tipo) {
            case 1:
                JOptionPane.showMessageDialog(null, "LA SOLICITUD YA EXISTE, INGRESA UNA NUEVA");
                reiniciarTxt();
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "NO SE PUDO INGRESAR LA SOLICITUD");
                reiniciarTxt();
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "ERROR A LA HORA A LA HORA DE VERIFICAR LA EXISTENCIA DE LA SOLICITUD");
                reiniciarTxt();
                break;
            case 4:
                JOptionPane.showMessageDialog(null, "SOLICITUD ENVIADA");
                reiniciarTxt();
                break;
            case 5:
                JOptionPane.showMessageDialog(null, "FORMATO DEL DOCUMENTO INCORRECTO", "ERROR", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }

    private void reiniciarTxt() {
        txtSolicitud.setText("");
        txtNombre.setText("");
        txtDireccion.setText("");
        txtSalario.setText("");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSolicitar;
    public javax.swing.JComboBox<String> cbTarjetas;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    public javax.swing.JTextPane txtDireccion;
    public javax.swing.JTextPane txtFecha;
    public javax.swing.JTextPane txtNombre;
    public javax.swing.JTextPane txtSalario;
    public javax.swing.JTextPane txtSolicitud;
    // End of variables declaration//GEN-END:variables
}
