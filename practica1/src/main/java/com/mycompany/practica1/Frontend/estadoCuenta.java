/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.practica1.Frontend;

import com.mycompany.practica1.Backend.generarHtml;
import com.mycompany.practica1.Backend.leerArchivos;
import com.mycompany.practica1.conexionDB.reporteTarjetas;
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
public class estadoCuenta extends javax.swing.JFrame {

    private String[] columnas = {"TARJETA", "FECHA", "DESCRIPCION", "ESTABLECIMIENTO", "MONTO", "MOVIMIENTO", "SALDO", "INTERES"};
    private JTable table;
    private double saldo = 0;
    private double interes = 0;
    private reporteTarjetas reporteDB;
    private String pathArchivo;
    private String[][] datosTabla;

    /**
     * Creates new form estadoCuenta
     */
    public estadoCuenta() {
        initComponents();
        crearTabla();
        btnHtml.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegresar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTarjeta = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtInteres = new javax.swing.JTextField();
        btnAplicar = new javax.swing.JButton();
        cbTipo = new javax.swing.JComboBox<>();
        btnHtml = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("ESTADOS DE CUENTA");
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

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel1.setText("ESTADO DE CUENTA");

        jLabel2.setText("BUSCAR DOCUMENTO");

        btnBuscar.setText("BUSCAR");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel3.setText("FILTROS DE BUSQUEDA");

        jLabel4.setText("NUMERO DE TARJETA");

        jLabel5.setText("TIPO DE TARJETA");

        jLabel6.setText("SALDO DE LA TARJETA");

        jLabel7.setText("INTERES DE LA TARJETA");

        btnAplicar.setText("APLICAR");
        btnAplicar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarActionPerformed(evt);
            }
        });

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NINGUNO", "NACIONAL", "REGIONAL", "INTERNACIONAL" }));
        cbTipo.setToolTipText("");

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
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(16, 16, 16)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtTarjeta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtSaldo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtInteres, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(btnRegresar))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(43, 43, 43)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel1)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(77, 77, 77)
                                            .addComponent(btnBuscar)))
                                    .addGap(4, 4, 4)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(btnAplicar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnHtml)
                        .addGap(43, 43, 43)))
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txtTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(12, 12, 12)
                .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtInteres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAplicar)
                .addGap(45, 45, 45)
                .addComponent(btnHtml)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
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
        reporteDB = new reporteTarjetas();
        try {
            String stringSaldo = txtSaldo.getText();
            String stringInteres = txtInteres.getText();
            if (!stringSaldo.isEmpty()) {
                // Intentar convertir el valor del saldo a Double
                saldo = Double.parseDouble(stringSaldo);
            }
            if (!stringInteres.isEmpty()) {
                // Intentar convertir el valor del interés a Double
                interes = Double.parseDouble(stringInteres);
            }
        } catch (NumberFormatException e) {
            // Si ocurre un error de formato, mostrar un mensaje de advertencia al usuario
            JOptionPane.showMessageDialog(null,
                    "INGRESE UN SALDO VALIDO O UN INTERES VALIDO",
                    "ERROR",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        datosTabla = reporteDB.buscarMovimientos(txtTarjeta.getText(), cbTipo.getSelectedItem().toString(),
                saldo, interes, this);
        DefaultTableModel model = new DefaultTableModel(datosTabla, columnas);

        // Crear la JTable con el modelo
        table.setModel(model);
        btnHtml.setVisible(true);
        jPanel1.repaint();
        saldo = 0;
        interes = 0;
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
            leer.leerListadoMovimientos(selectedFile.getAbsolutePath(), this);
            pathArchivo = selectedFile.getParent();
        } else {
            JOptionPane.showMessageDialog(this, "SELECCION CANCELADA");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnHtmlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHtmlActionPerformed
        if (pathArchivo != null) {
            generarHtml generar = new generarHtml(pathArchivo);
            generar.generarReporteCuenta(pathArchivo, datosTabla, "LISTADO CUENTAS", "REPORTE CUENTAS.html", this);
        } else {
            JFileChooser fileChooser = new JFileChooser();

            // Configurar el filtro para que solo muestre archivos HTML
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos HTML", "html", "htm");
            fileChooser.setFileFilter(filter);

            // Mostrar el cuadro de diálogo para seleccionar la ubicación y el nombre del archivo
            fileChooser.setDialogTitle("Seleccionar ubicación para guardar el archivo HTML");
            int result = fileChooser.showSaveDialog(null);

            // Verificar si el usuario seleccionó una ubicación
            if (result == JFileChooser.APPROVE_OPTION) {
                // Obtener el archivo seleccionado
                File selectedFile = fileChooser.getSelectedFile();

                // Obtener la ruta del directorio que contiene el archivo
                String directoryPath = selectedFile.getParent();

                // Crear el nombre del archivo HTML (asegurarse de que tenga la extensión .html)
                generarHtml generar = new generarHtml(pathArchivo);
                generar.generarReporteCuenta(directoryPath, datosTabla, "LISTADO CUENTAS", selectedFile.getName() + ".html", this);
            }
        }

    }//GEN-LAST:event_btnHtmlActionPerformed

    public void archivoGenerado() {
        JOptionPane.showMessageDialog(null, "SE GUARDO EL ARCHIVO");
    }

    public void archivoNoGuardado() {
        JOptionPane.showMessageDialog(null, "NO SE PUDO GENERAR EL ARCHIVO", "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    private void crearTabla() {
        // Definir los nombres de las columnas

        // Crear el modelo de tabla sin datos
        DefaultTableModel model = new DefaultTableModel(null, columnas);

        // Crear la JTable con el modelo
        table = new JTable(model);

        // Añadir la tabla a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);

        // Añadir el JScrollPane al panel
        jPanel1.add(scrollPane, BorderLayout.CENTER);
    }

    public void llenarCampos(String numero, String tipo, String saldo, String interes) {
        txtTarjeta.setText(numero);
        if (tipo.equals("NACIONAL")) {
            cbTipo.setSelectedIndex(1);
        } else if (tipo.equals("REGIONAL")) {
            cbTipo.setSelectedIndex(2);
        } else if (tipo.equals("INTERNACINAL")) {
            cbTipo.setSelectedIndex(3);
        }
        txtSaldo.setText(saldo);
        txtInteres.setText(interes);
    }

    public void noHayElementos() {
        JOptionPane.showMessageDialog(null, "NO SE ENCONTRARON RESULTADOS");
        pathArchivo = null;
        limpiar();
    }

    public void formatoIncorrecto() {
        JOptionPane.showMessageDialog(null, "FORMATO DEL DOCUMENTO INCORRECTO", "ERROR", JOptionPane.ERROR_MESSAGE);
        pathArchivo = null;
    }

    private void limpiar() {
        txtTarjeta.setText("");
        txtSaldo.setText("");
        txtInteres.setText("");
        cbTipo.setSelectedIndex(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAplicar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnHtml;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtInteres;
    private javax.swing.JTextField txtSaldo;
    private javax.swing.JTextField txtTarjeta;
    // End of variables declaration//GEN-END:variables
}
