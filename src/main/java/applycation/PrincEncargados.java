package applycation;

import controllers.Controlador;
import entities.Encargado;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Álvaro
 */
public class PrincEncargados extends javax.swing.JFrame {

    private Controlador controlador = new Controlador();

    public PrincEncargados() {
        initComponents();
    }
    
    // COGE LOS DATOS DE LA BD Y LOS METE EN LA TABLA
    public void cargarTabla() {

        // PARA QUE NO SE PUEDA EDITAR LA TABLA
        DefaultTableModel modeloTabla = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }

        };

        // TITULOS DE LAS COLUMNAS
        String titulos[] = {"ID", "Nombre", "Apellidos", "Edad"};
        modeloTabla.setColumnIdentifiers(titulos);

        // LECTURA DE LOS DATOS A LA TABLA
        List<Encargado> encargados = controlador.obtenerEncargados();

        if (encargados != null) {
            for (Encargado enc : encargados) {
                Object[] obj = {enc.getId(), enc.getNombre(),
                    enc.getApellidos(), enc.getEdad()};

                // AÑADIR LA FILA
                modeloTabla.addRow(obj);
            }
        }

        tablaEncargados.setModel(modeloTabla);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEncargados = new javax.swing.JTable();
        Actualizar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        textoBusqEncargados = new javax.swing.JTextField();
        botonBuscador = new javax.swing.JButton();
        InsertarEncargado = new javax.swing.JButton();
        EditarEncargado = new javax.swing.JButton();
        EliminarEncargado = new javax.swing.JButton();
        Volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(41, 30, 28));

        jLabel2.setBackground(new java.awt.Color(160, 126, 120));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(160, 126, 120));
        jLabel2.setText("ENCARGADOS");

        jPanel2.setBackground(new java.awt.Color(160, 126, 120));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tablaEncargados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaEncargados);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Actualizar.setBackground(new java.awt.Color(160, 126, 120));
        Actualizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Actualizar.setForeground(new java.awt.Color(41, 30, 28));
        Actualizar.setText("Actualizar");
        Actualizar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(160, 126, 120));
        jLabel3.setText("Busqueda por código");
        jLabel3.setToolTipText("");

        textoBusqEncargados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoBusqEncargadosActionPerformed(evt);
            }
        });

        botonBuscador.setBackground(new java.awt.Color(160, 126, 120));
        botonBuscador.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonBuscador.setForeground(new java.awt.Color(41, 30, 28));
        botonBuscador.setText("Buscar");
        botonBuscador.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        botonBuscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscadorActionPerformed(evt);
            }
        });

        InsertarEncargado.setBackground(new java.awt.Color(160, 126, 120));
        InsertarEncargado.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        InsertarEncargado.setForeground(new java.awt.Color(41, 30, 28));
        InsertarEncargado.setText("Añadir");
        InsertarEncargado.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        InsertarEncargado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertarEncargadoActionPerformed(evt);
            }
        });

        EditarEncargado.setBackground(new java.awt.Color(160, 126, 120));
        EditarEncargado.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        EditarEncargado.setForeground(new java.awt.Color(41, 30, 28));
        EditarEncargado.setText("Editar");
        EditarEncargado.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        EditarEncargado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarEncargadoActionPerformed(evt);
            }
        });

        EliminarEncargado.setBackground(new java.awt.Color(160, 126, 120));
        EliminarEncargado.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        EliminarEncargado.setForeground(new java.awt.Color(41, 30, 28));
        EliminarEncargado.setText("Eliminar");
        EliminarEncargado.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        EliminarEncargado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarEncargadoActionPerformed(evt);
            }
        });

        Volver.setBackground(new java.awt.Color(160, 126, 120));
        Volver.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Volver.setForeground(new java.awt.Color(41, 30, 28));
        Volver.setText("Volver");
        Volver.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(InsertarEncargado, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(textoBusqEncargados, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botonBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel3))))
                    .addComponent(EliminarEncargado, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditarEncargado, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoBusqEncargados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonBuscador))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(InsertarEncargado, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(EditarEncargado, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(EliminarEncargado, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Actualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(68, 68, 68))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
        // "CIERRA" LA VENTANA
        cargarTabla();
    }//GEN-LAST:event_ActualizarActionPerformed

    private void textoBusqEncargadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoBusqEncargadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoBusqEncargadosActionPerformed

    private void botonBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscadorActionPerformed

        //        Facturas factBusq;
        //
        //        // TRY CATCH POR EL NULL POINTER
        //        try {
            //            factBusq = controlador.findFacturas(textoBusqCodi.getText());
            //            String codigo = factBusq.getCodigo();
            //            Date fechEmis = factBusq.getFechEmision();
            //            String descrip = factBusq.getDescripcion();
            //            BigDecimal impor = factBusq.getTotalImporte();
            //
            //            JOptionPane.showMessageDialog(null, "### Factura Buscada ###\n\n"
                //                + "Código: " + codigo + "\n"
                //                + "Fecha Emisión: " + fechEmis + "\n"
                //                + "Descripción: " + descrip + "\n"
                //                + "Total Importe: " + impor + "\n");
            //
            //        } catch (NullPointerException npe) {
            //            JOptionPane.showMessageDialog(null, "La factura no existe");
            //        }
        //
    }//GEN-LAST:event_botonBuscadorActionPerformed

    // ABRE LA INTERFAZ PARA HACER LA INSERCION DE UN ENCARGADO
    private void InsertarEncargadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertarEncargadoActionPerformed
                InsertarEncargado insercion = new InsertarEncargado();
                insercion.setVisible(true);
                insercion.setLocationRelativeTo(null);
    }//GEN-LAST:event_InsertarEncargadoActionPerformed

    private void EditarEncargadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarEncargadoActionPerformed
        //        String codigo = "";
        //
        //        // SE TIENE QUE MIRAR QUE SE HAYA SELECCIONADO UNA FILA Y QUE NO ESTE VACIA
        //        if (tablaFacturas.getRowCount() > 0) {
            //            // SI ESTA SELECCIONADO
            //            if (tablaFacturas.getSelectedRow() != -1) {
                //
                //                // FILA SELECCIONADA COLUMNA 0
                //                codigo = String.valueOf(tablaFacturas.getValueAt(tablaFacturas.getSelectedRow(), 0));
                //
                //                EditarFactura consultaFactura = new EditarFactura(codigo);
                //                consultaFactura.setVisible(true);
                //                consultaFactura.setLocationRelativeTo(null);
                //
                //            } else {
                //                JOptionPane.showMessageDialog(null, "No ha seleccionado nada");
                //            }
            //        } else {
            //            JOptionPane.showMessageDialog(null, "No ha seleccionado nada");
            //        }
    }//GEN-LAST:event_EditarEncargadoActionPerformed

    private void EliminarEncargadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarEncargadoActionPerformed
        //        String codigo = "";
        //        // SE TIENE QUE MIRAR QUE SE HAYA SELECCIONADO UNA FILA Y QUE NO ESTE VACIA
        //        if (tablaFacturas.getRowCount() > 0) {
            //            // SI ESTA SELECCIONADO
            //            if (tablaFacturas.getSelectedRow() != -1) {
                //                // FILA SELECCIONADA COLUMNA 0
                //                codigo = String.valueOf(tablaFacturas.getValueAt(tablaFacturas.getSelectedRow(), 0));
                //
                //                // METODO JPA PARA ELIMINAR
                //                try {
                    //                    controlador.destroy(codigo);
                    //                } catch (NonexistentEntityException ex) {
                    //                }
                //
                //                JOptionPane.showMessageDialog(null, "Factura borrada correctamente");
                //                cargarTabla();
                //
                //            } else {
                //                JOptionPane.showMessageDialog(null, "No ha seleccionado nada");
                //            }
            //        } else {
            //            JOptionPane.showMessageDialog(null, "No ha seleccionado nada");
            //        }
    }//GEN-LAST:event_EliminarEncargadoActionPerformed

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        // "CIERRA" LA VENTANA
        this.dispose();
    }//GEN-LAST:event_VolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton EditarEncargado;
    private javax.swing.JButton EliminarEncargado;
    private javax.swing.JButton InsertarEncargado;
    private javax.swing.JButton Volver;
    private javax.swing.JButton botonBuscador;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEncargados;
    private javax.swing.JTextField textoBusqEncargados;
    // End of variables declaration//GEN-END:variables
}
