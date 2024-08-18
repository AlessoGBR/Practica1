/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.practica1.Frontend;

import com.mycompany.practica1.Backend.leerArchivos;
import com.mycompany.practica1.conexionDB.reporteMovimientosDB;
import java.awt.BorderLayout;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alesso
 */
public class listadoTarjetas extends javax.swing.JFrame {

    private final String[] columnas = {"NUMERO", "NOMBRE", "LIMITE", "TIPO", "ESTADO", "DIRECCION", "FECHA", "SALDO"};
    private JTable table;
    private String estado;
    private double monto;
    private reporteMovimientosDB reportes;

    public listadoTarjetas() {
        initComponents();
        crearTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtFechaInicial = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtFechaFinal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox<>();
        btnAplicar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnHtml = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("LISTADO DE TARJETAS");
        setResizable(false);

        btnRegresar.setText("REGRESAR");
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel1.setText("LISTADO DE TARJETAS");

        jLabel2.setText("BUSCAR DOCUMENTO");

        btnBuscar.setText("BUSCAR");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel3.setText("FILTROS DE BUSQUEDA");

        jLabel4.setText("TIPO DE TARJETA");

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NINGUNO", "NACIONAL", "REGIONAL", "INTERNACIONAL" }));

        jLabel5.setText("MONTO LIMITE");

        jLabel6.setText("FECHA INICIAL");

        jLabel7.setText("FECHA FINAL");

        jLabel8.setText("ESTADO");

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NINGUNO", "ACTIVO", "INACTIVO" }));

        btnAplicar.setText("APLICAR");
        btnAplicar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel9.setText("NOMBRE");

        btnHtml.setText("GENERAR HTML");
        btnHtml.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHtml.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHtmlActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addComponent(btnBuscar))
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel4)
                                            .addComponent(cbTipo, 0, 172, Short.MAX_VALUE)
                                            .addComponent(txtMonto)
                                            .addComponent(txtFechaInicial)
                                            .addComponent(txtFechaFinal)
                                            .addComponent(cbEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtNombre))
                                        .addComponent(jLabel2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(11, 11, 11)))
                                .addGap(18, 18, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAplicar)
                                .addGap(68, 68, 68)))
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 990, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(btnRegresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHtml)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel3)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtFechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(txtFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAplicar)
                        .addGap(0, 52, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnHtml))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        reportes reportes = new reportes();
        this.setVisible(false);
        reportes.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnAplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarActionPerformed
        reportes = new reporteMovimientosDB();
        try {
            String stringMonto = txtMonto.getText().trim();
            if (!stringMonto.isEmpty()) {
                // Intentar convertir el valor del salario a Double
                monto = Double.parseDouble(stringMonto);
            }
        } catch (NumberFormatException e) {
            // Si ocurre un error de formato, mostrar un mensaje de advertencia al usuario
            JOptionPane.showMessageDialog(null,
                    "INGRESE UN MONTO VALIDO",
                    "ERROR",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        String[][] datosTabla = reportes.buscarTarjetas(cbTipo.getSelectedItem().toString(), monto,
                txtFechaInicial.getText(), txtFechaFinal.getText(), cbEstado.getSelectedIndex(), txtNombre.getText(), this);
        DefaultTableModel model = new DefaultTableModel(datosTabla, columnas);

        // Crear la JTable con el modelo
        table.setModel(model);

        jPanel1.repaint();
        limpiar();
    }//GEN-LAST:event_btnAplicarActionPerformed

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
            leer.leerListadoTarjeta(selectedFile.getAbsolutePath(), this);
        } else {
            JOptionPane.showMessageDialog(this, "SELECCION CANCELADA");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnHtmlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHtmlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHtmlActionPerformed

    private void crearTabla() {
        DefaultTableModel model = new DefaultTableModel(null, columnas);

        // Crear la JTable con el modelo
        table = new JTable(model);

        // Añadir la tabla a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);

        // Añadir el JScrollPane al panel
        jPanel1.add(scrollPane, BorderLayout.CENTER);
    }

    public void llenarCampos(String tipo, String monto, String fechaInicio, String fechaFinal, String estado) {
        switch (tipo) {
            case "":
                cbTipo.setSelectedIndex(0);
                break;
            case "NACIONAL":
                cbTipo.setSelectedIndex(1);
                break;
            case "REGIONAL":
                cbTipo.setSelectedIndex(2);
                break;
            case "INTERNACIONAL":
                cbTipo.setSelectedIndex(3);
                break;
            default:
                break;
        }

        txtMonto.setText(monto);
        txtFechaInicial.setText(fechaInicio);
        txtFechaFinal.setText(fechaFinal);

        switch (estado) {
            case "AUTORIZADA":
                cbEstado.setSelectedIndex(1);
                break;
            case "ACTIVA":
                cbEstado.setSelectedIndex(1);
                break;
            case "CANCELADA":
                cbEstado.setSelectedIndex(2);
                break;
            default:
                break;
        }

    }

    public void noHayElementos() {
        JOptionPane.showMessageDialog(null, "NO SE ENCONTRARON RESULTADOS");
        limpiar();
    }
    
    private void limpiar(){
        txtFechaFinal.setText("");
        txtFechaInicial.setText("");
        txtNombre.setText("");
        txtMonto.setText("");
        cbEstado.setSelectedIndex(0);
        cbTipo.setSelectedIndex(0);
        
    }
            
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAplicar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnHtml;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbEstado;
    private javax.swing.JComboBox<String> cbTipo;
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
    private javax.swing.JTextField txtFechaFinal;
    private javax.swing.JTextField txtFechaInicial;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
