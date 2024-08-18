/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.practica1.Frontend;

import com.mycompany.practica1.Backend.leerArchivos;
import com.mycompany.practica1.conexionDB.conexionDB;
import com.mycompany.practica1.conexionDB.reportesSolicitud;
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
public class listadoSolicitudes extends javax.swing.JFrame {

    private final String[] columnas = {"NUMERO", "NOMBRE", "SALARIO", "TIPO", "DIRECCION", "FECHA", "ESTADO"};
    private JTable table;
    private boolean estado;
    private double salario;
    private reportesSolicitud reportesDB;

    /**
     * Creates new form listadoSolicitudes
     */
    public listadoSolicitudes() {
        initComponents();
        crearTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegresar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtFechaInicio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtFechaFinal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSalario = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox<>();
        btnAplicar = new javax.swing.JButton();
        cbTipo = new javax.swing.JComboBox<>();
        btnHtml = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("LISTADO DE SOLICITUDES");
        setResizable(false);

        btnRegresar.setText("REGRESAR");
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("LISTADO DE SOLICITUDES");

        jLabel2.setText("FILTROS DE BUSQUEDA");

        jLabel3.setText("BUSCAR DOCUMENTO");

        btnBuscar.setText("BUSCAR");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel4.setText("FECHA DE INICIO");

        jLabel5.setText("FECHA FINAL");

        jLabel6.setText("TIPO");

        jLabel7.setText("SALARIO");

        jLabel8.setText("ESTADO");

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NINGUNO", "APROBADO", "DENEGADO" }));

        btnAplicar.setText("APLICAR");
        btnAplicar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarActionPerformed(evt);
            }
        });

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NINGUNO", "NACIONAL", "REGIONAL", "INTERNACIONAL" }));

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
                        .addContainerGap()
                        .addComponent(btnRegresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHtml))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel4)
                                            .addComponent(txtFechaInicio)
                                            .addComponent(jLabel5)
                                            .addComponent(txtFechaFinal)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7)
                                            .addComponent(txtSalario)
                                            .addComponent(jLabel8)
                                            .addComponent(cbEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(btnBuscar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(btnAplicar)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 908, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(txtFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnAplicar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnHtml))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        reportes reportes = new reportes();
        this.setVisible(false);
        reportes.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

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
            leer.leerListadoSolicitudes(selectedFile.getAbsolutePath(), this);
        } else {
            JOptionPane.showMessageDialog(this, "SELECCION CANCELADA");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarActionPerformed
        reportesDB = new reportesSolicitud();
        try {
            String salarioTexto = txtSalario.getText().trim();
            if (!salarioTexto.isEmpty()) {
                // Intentar convertir el valor del salario a Double
                salario = Double.parseDouble(salarioTexto);
            }
        } catch (NumberFormatException e) {
            // Si ocurre un error de formato, mostrar un mensaje de advertencia al usuario
            JOptionPane.showMessageDialog(null,
                    "INGRSE UN SALARIO VALIDO",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        String[][] datosTabla = reportesDB.buscarAutorizacionesConSolicitud(
                txtFechaInicio.getText(),
                txtFechaFinal.getText(),
                cbTipo.getSelectedItem().toString(),
                salario,
                cbEstado.getSelectedItem().toString(),
                this
        );
        DefaultTableModel model = new DefaultTableModel(datosTabla, columnas);

        // Crear la JTable con el modelo
        table.setModel(model);

        jPanel1.repaint();
        limpiar();
    }//GEN-LAST:event_btnAplicarActionPerformed

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

    public void llenarCampos(String tipo, String salario, String fechaInicio, String fechaFin, String estado) {
        txtFechaInicio.setText(fechaInicio);
        txtFechaFinal.setText(fechaFin);
        if (tipo.equals("NACIONAL")) {
            cbTipo.setSelectedIndex(1);
        } else if (tipo.equals("REGIONAL")) {
            cbTipo.setSelectedIndex(2);
        } else if (tipo.equals("INTERNACIONAL")) {
            cbTipo.setSelectedIndex(3);
        }
        txtSalario.setText(salario);
        if (estado.equals("APROBADA") || estado.equals("ACEPTADA")) {
            cbEstado.setSelectedIndex(1);
        } else if (estado.equals("DENEGADA")) {
            cbEstado.setSelectedIndex(2);
        }

    }

    public void noHayElementos() {
        JOptionPane.showMessageDialog(null, "NO SE ENCONTRARON RESULTADOS");
        limpiar();
    }

    private void limpiar() {
        txtFechaFinal.setText("");
        txtFechaInicio.setText("");
        txtSalario.setText("");
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtFechaFinal;
    private javax.swing.JTextField txtFechaInicio;
    private javax.swing.JTextField txtSalario;
    // End of variables declaration//GEN-END:variables
}
