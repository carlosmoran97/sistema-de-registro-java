/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import bd.ProveedorBd;
import bd.CompraBd;
import bd.Conexion;
import bd.LineasDeCompraBd;
import bd.ProductoBd;
import java.sql.Date;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Proveedor;
import modelo.Compra;
import modelo.LineaDeCompra;
import modelo.Producto;

/**
 *
 * @author carlos
 */
public class GestionarCompra extends javax.swing.JFrame {

    private ProveedorBd proveedorBd = new ProveedorBd();
    private CompraBd compraBd = new CompraBd();
    private LineasDeCompraBd ldcBd = new LineasDeCompraBd();
    private ProductoBd productoBd = new ProductoBd();
    private Compra compraActual = new Compra();
    private DefaultTableModel lineasDeCompra;
    private String data[][] = {};
    private String cabecera[] = {"Cantidad", "Concepto", "Precio unitario", "Total de línea"};
    private final int ENTER_CODE = 10;

    private Producto productoActual;

    /**
     * Creates new form GestionarVenta
     */
    public GestionarCompra() {
        initComponents();
        lineasDeCompra = new DefaultTableModel(data, cabecera);
        tablaLineasDeCompra.setModel(lineasDeCompra);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TabCompras = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNumeroDocumento = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNit = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnIniciar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        spinnerCantidad = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLineasDeCompra = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        txtPrecioUnitario = new javax.swing.JFormattedTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNombreDetalle = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcionDetalle = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        txtPrecioSugeridoDetalle = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtUnidadDeMedidaDetalle = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtCodigoDetalle = new javax.swing.JTextField();
        btnFinalizar = new javax.swing.JButton();
        txtTotal = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Datos del documento"));

        jLabel1.setText("Fecha");

        txtFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        txtFecha.setToolTipText("<html>\n\tFecha de la compra con formato <strong>yyyy-MM-dd</strong><br/>\n\tEjemplo: 2018-02-15 indica el 15 de febrero de 2018\n</html>");

        jLabel2.setText("No. de documento");

        jLabel3.setText("NIT");

        txtNit.setToolTipText("NIT del proveedor");
        txtNit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNitFocusLost(evt);
            }
        });
        txtNit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNitKeyPressed(evt);
            }
        });

        jLabel4.setText("Nombre");

        txtNombre.setEditable(false);

        btnIniciar.setText("Iniciar la compra");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumeroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombre)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtNit, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnIniciar)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtNumeroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtNit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnIniciar)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Lineas de compra"));

        jLabel5.setText("Código del artículo");

        txtCodigo.setEnabled(false);
        txtCodigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodigoFocusLost(evt);
            }
        });
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoKeyPressed(evt);
            }
        });

        jLabel6.setText("Cantidad");

        spinnerCantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spinnerCantidad.setToolTipText("");
        spinnerCantidad.setEnabled(false);

        tablaLineasDeCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cantidad", "Concepto", "Precio unitario", "Total de línea"
            }
        ));
        jScrollPane1.setViewportView(tablaLineasDeCompra);

        jLabel7.setText("Precio unitario");

        btnAgregar.setText("Agregar");
        btnAgregar.setEnabled(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        txtPrecioUnitario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtPrecioUnitario.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(spinnerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregar)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(spinnerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(btnAgregar)
                    .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Detalles del producto"));

        jLabel8.setText("Nombre");

        jLabel9.setText("Descripción");

        txtNombreDetalle.setEditable(false);

        txtDescripcionDetalle.setEditable(false);
        txtDescripcionDetalle.setColumns(20);
        txtDescripcionDetalle.setRows(5);
        jScrollPane2.setViewportView(txtDescripcionDetalle);

        jLabel10.setText("Precio sugerido");

        txtPrecioSugeridoDetalle.setEditable(false);

        jLabel11.setText("Unidad de medida");

        txtUnidadDeMedidaDetalle.setEditable(false);

        jLabel12.setText("Código");

        txtCodigoDetalle.setEditable(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombreDetalle))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txtPrecioSugeridoDetalle))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUnidadDeMedidaDetalle)
                            .addComponent(txtCodigoDetalle))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNombreDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtPrecioSugeridoDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtUnidadDeMedidaDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtCodigoDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        btnFinalizar.setText("Finalizar compra");
        btnFinalizar.setEnabled(false);
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        txtTotal.setEditable(false);
        txtTotal.setEnabled(false);

        jLabel13.setText("Total");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(btnFinalizar)
                .addGap(42, 42, 42)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFinalizar)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        TabCompras.addTab("Agregar compra", jPanel1);
        jPanel1.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 997, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 553, Short.MAX_VALUE)
        );

        TabCompras.addTab("Registro de compras", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TabCompras)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TabCompras)
                .addContainerGap())
        );

        TabCompras.getAccessibleContext().setAccessibleName("jTabbedPane");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNitKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNitKeyPressed
        // TODO add your handling code here:

        if (evt.getKeyCode() == ENTER_CODE) {
            try {
                Proveedor prov = proveedorBd.obtenerUnProveedor(txtNit.getText());
                if (prov != null) {
                    txtNombre.setText(prov.getNombre());
                    compraActual.setProveedor(prov);
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró ningún proveedor con el NIT especificado. Por favor revise que haya ingresado el correcto.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al intentar obtener el proveedor.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_txtNitKeyPressed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        // TODO add your handling code here:
        try {
            if (txtFecha.getText().isEmpty()
                    || txtNumeroDocumento.getText().isEmpty()
                    || txtNit.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese todos los campos", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }
            compraActual.setFecha(Date.valueOf(txtFecha.getText()));
            compraActual.setNumeroDeDocumento(txtNumeroDocumento.getText());
            compraActual.setFinalizada(false);
            try {
                compraBd.insertarCompra(compraActual.getFecha(), compraActual.getNumeroDeDocumento(), compraActual.getProveedor());
                compraActual.setId(compraBd.obtenerUltimaCompra().getId());
                habilitarControlesDatosDeDocumento(false);
                habilitarControlesLineasDeCompra(true);
                // LIMPIAR TABLE MODEL
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al iniciar la compra.", "Algo ha salido mal", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese todos los datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        try {
            if (compraActual.getId() != 0 && !compraActual.isFinalizada()) {
                compraBd.eliminarCompra(compraActual.getId());
                JOptionPane.showMessageDialog(this, "La compra no se finalizó. Se eliminó del regitro.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } finally {
            try {
                Conexion.getConnection().close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al cerrar la conexion.");
            }
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        // TODO add your handling code here:
        if (compraActual.lineasDeCompra.size() > 0) {
            //INSERTAR LA COMPRA Y LAS LÍNEAS DE COMPRA
            try {
                for (LineaDeCompra ldc : compraActual.lineasDeCompra) {
                    ldcBd.insertarLineaDeCompra(ldc.getProducto(), ldc.getCantidad(), ldc.getPrecioUnitario(), compraActual);
                }
                //LIMPIARLA Y DEJAR LISTO TODO PARA UNA NUEVA COMPRA

                habilitarControlesDatosDeDocumento(true);
                habilitarControlesLineasDeCompra(false);
                limpiarFormulario();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }

        } else {
            JOptionPane.showMessageDialog(this, "Debe ingresar al menos una línea de compra.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnFinalizarActionPerformed
    private void limpiarFormulario() {
        int rows = lineasDeCompra.getRowCount();
        txtCodigo.setText("");
        txtCodigoDetalle.setText("");
        txtDescripcionDetalle.setText("");
        txtFecha.setText("");
        txtNit.setText("");
        txtNombre.setText("");
        txtNombreDetalle.setText("");
        txtNumeroDocumento.setText("");
        txtPrecioSugeridoDetalle.setText("");
        txtPrecioUnitario.setText("");
        txtTotal.setText("");
        txtUnidadDeMedidaDetalle.setText("");
        spinnerCantidad.setValue(1);
        compraActual.setFinalizada(true);
        compraActual.setId(0);
        compraActual.lineasDeCompra.clear();
        // LIMPIAR TABLE MODEL
        for (int i = 0; i < rows; i++) {
            lineasDeCompra.removeRow(0);
        }
        lineasDeCompra.fireTableDataChanged();
        tablaLineasDeCompra.repaint();
    }
    private void txtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == ENTER_CODE) {
            try {
                productoActual = productoBd.obtenerProductoPorCodigo(txtCodigo.getText());
                if (productoActual != null) {
                    txtNombreDetalle.setText(productoActual.getNombre());
                    txtCodigoDetalle.setText(productoActual.getCodigo());
                    txtDescripcionDetalle.setText(productoActual.getDescripcion());
                    txtPrecioSugeridoDetalle.setText(String.valueOf(productoActual.getPrecioSugerido()));
                    txtUnidadDeMedidaDetalle.setText(productoActual.getUnidadDeMedida());

                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo encontrar un producto con el código especificado", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_txtCodigoKeyPressed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        // TODO add your handling code here:
        try {
            if (txtCodigo.getText().isEmpty() || txtPrecioUnitario.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese todos los datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }
            LineaDeCompra ldc = new LineaDeCompra(
                    0,
                    productoActual,
                    Integer.parseInt(spinnerCantidad.getValue().toString()),
                    Float.parseFloat(txtPrecioUnitario.getText()),
                    compraActual.getId()
            );
            if (compraActual.validarLineaDeCompra(ldc)) {
                // AGREGAR A LA TABLA
                String[] data = {
                    String.valueOf(ldc.getCantidad()),
                    ldc.getProducto().getNombre(),
                    String.valueOf(ldc.getPrecioUnitario()),
                    String.valueOf(ldc.subtotal())
                };
                lineasDeCompra.addRow(data);
                tablaLineasDeCompra.repaint();
                txtTotal.setText(String.format("$%0.2f", compraActual.total()));
            } else {
                JOptionPane.showMessageDialog(this, "Este producto ya ha sido agregado", "Advertencia!!", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese todos los datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtNitFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNitFocusLost
        // TODO add your handling code here:
        try {
            Proveedor prov = proveedorBd.obtenerUnProveedor(txtNit.getText());
            if (prov != null) {
                txtNombre.setText(prov.getNombre());
                compraActual.setProveedor(prov);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró ningún proveedor con el NIT especificado. Por favor revise que haya ingresado el correcto.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al intentar obtener el proveedor.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtNitFocusLost

    private void txtCodigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoFocusLost
        // TODO add your handling code here:
        try {
            productoActual = productoBd.obtenerProductoPorCodigo(txtCodigo.getText());
            if (productoActual != null) {
                txtNombreDetalle.setText(productoActual.getNombre());
                txtCodigoDetalle.setText(productoActual.getCodigo());
                txtDescripcionDetalle.setText(productoActual.getDescripcion());
                txtPrecioSugeridoDetalle.setText(String.valueOf(productoActual.getPrecioSugerido()));
                txtUnidadDeMedidaDetalle.setText(productoActual.getUnidadDeMedida());

            } else {
                JOptionPane.showMessageDialog(this, "No se pudo encontrar un producto con el código especificado", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_txtCodigoFocusLost
    private void habilitarControlesDatosDeDocumento(boolean estado) {
        txtFecha.setEnabled(estado);
        txtNumeroDocumento.setEnabled(estado);
        txtNit.setEnabled(estado);
        btnIniciar.setEnabled(estado);
    }

    private void habilitarControlesLineasDeCompra(boolean estado) {
        spinnerCantidad.setEnabled(estado);
        txtCodigo.setEnabled(estado);
        txtPrecioUnitario.setEnabled(estado);
        btnAgregar.setEnabled(estado);
        btnFinalizar.setEnabled(estado);
        txtTotal.setEnabled(estado);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GestionarCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarCompra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane TabCompras;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner spinnerCantidad;
    private javax.swing.JTable tablaLineasDeCompra;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigoDetalle;
    private javax.swing.JTextArea txtDescripcionDetalle;
    private javax.swing.JFormattedTextField txtFecha;
    private javax.swing.JTextField txtNit;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreDetalle;
    private javax.swing.JTextField txtNumeroDocumento;
    private javax.swing.JTextField txtPrecioSugeridoDetalle;
    private javax.swing.JFormattedTextField txtPrecioUnitario;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtUnidadDeMedidaDetalle;
    // End of variables declaration//GEN-END:variables
}
