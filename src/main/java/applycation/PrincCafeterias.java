package applycation;

import controllers.Controlador;
import entities.Cafeteria;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Álvaro
 */
public class PrincCafeterias extends javax.swing.JFrame {

    Controlador controlador = new Controlador();

    public PrincCafeterias() {
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
        String titulos[] = {"ID", "Nombre", "Fecha Apertura", "Costes Mensuales", "Encargado"};
        modeloTabla.setColumnIdentifiers(titulos);

        // LECTURA DE LOS DATOS A LA TABLA
        List<Cafeteria> cafeterias = controlador.obtenerCafeterias();

        if (cafeterias != null) {
            for (Cafeteria caf : cafeterias) {
                Object[] obj = {caf.getId(), caf.getNombre(),
                    caf.getFecApertLocalDate(), caf.getCostePedidoMensu(), caf.getIdEncargado()};

                // AÑADIR LA FILA
                modeloTabla.addRow(obj);
            }
        }

        tablaCafeterias.setModel(modeloTabla);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCafeterias = new javax.swing.JTable();
        Actualizar = new javax.swing.JButton();
        EliminarCafeteria = new javax.swing.JButton();
        EditarCafeteria = new javax.swing.JButton();
        InsertarCafeteria = new javax.swing.JButton();
        BuscadorCafeteria = new javax.swing.JButton();
        buscCafeteria = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(41, 30, 28));

        jLabel2.setBackground(new java.awt.Color(160, 126, 120));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(160, 126, 120));
        jLabel2.setText("CAFETERÍAS");

        jPanel2.setBackground(new java.awt.Color(160, 126, 120));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tablaCafeterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaCafeterias);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(187, 187, 187))
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

        EliminarCafeteria.setBackground(new java.awt.Color(160, 126, 120));
        EliminarCafeteria.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        EliminarCafeteria.setForeground(new java.awt.Color(41, 30, 28));
        EliminarCafeteria.setText("Eliminar");
        EliminarCafeteria.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        EliminarCafeteria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarCafeteriaActionPerformed(evt);
            }
        });

        EditarCafeteria.setBackground(new java.awt.Color(160, 126, 120));
        EditarCafeteria.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        EditarCafeteria.setForeground(new java.awt.Color(41, 30, 28));
        EditarCafeteria.setText("Editar");
        EditarCafeteria.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        EditarCafeteria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarCafeteriaActionPerformed(evt);
            }
        });

        InsertarCafeteria.setBackground(new java.awt.Color(160, 126, 120));
        InsertarCafeteria.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        InsertarCafeteria.setForeground(new java.awt.Color(41, 30, 28));
        InsertarCafeteria.setText("Añadir");
        InsertarCafeteria.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        InsertarCafeteria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertarCafeteriaActionPerformed(evt);
            }
        });

        BuscadorCafeteria.setBackground(new java.awt.Color(160, 126, 120));
        BuscadorCafeteria.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BuscadorCafeteria.setForeground(new java.awt.Color(41, 30, 28));
        BuscadorCafeteria.setText("Buscar");
        BuscadorCafeteria.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        BuscadorCafeteria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscadorCafeteriaActionPerformed(evt);
            }
        });

        buscCafeteria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscCafeteriaActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(160, 126, 120));
        jLabel3.setText("Busqueda por código");
        jLabel3.setToolTipText("");

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
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(InsertarCafeteria, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EditarCafeteria, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EliminarCafeteria, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(buscCafeteria, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(BuscadorCafeteria, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(15, 15, 15)
                                    .addComponent(jLabel3)))
                            .addComponent(Volver, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jLabel2)))
                .addGap(0, 55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buscCafeteria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BuscadorCafeteria))
                        .addGap(18, 18, 18)
                        .addComponent(InsertarCafeteria, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(EditarCafeteria, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EliminarCafeteria, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Actualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(Volver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(37, Short.MAX_VALUE))
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
        // TODO add your handling code here:
        cargarTabla();
    }//GEN-LAST:event_ActualizarActionPerformed

    private void EliminarCafeteriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarCafeteriaActionPerformed
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

    }//GEN-LAST:event_EliminarCafeteriaActionPerformed

    private void EditarCafeteriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarCafeteriaActionPerformed
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

    }//GEN-LAST:event_EditarCafeteriaActionPerformed

    private void InsertarCafeteriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertarCafeteriaActionPerformed
//        // TODO add your handling code here:
//        InsertarFactura insercion = new InsertarFactura();
//        insercion.setVisible(true);
//        insercion.setLocationRelativeTo(null);
    }//GEN-LAST:event_InsertarCafeteriaActionPerformed

    private void BuscadorCafeteriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscadorCafeteriaActionPerformed

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
    }//GEN-LAST:event_BuscadorCafeteriaActionPerformed

    private void buscCafeteriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscCafeteriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscCafeteriaActionPerformed

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        // "CIERRA" LA VENTANA
        this.dispose();
    }//GEN-LAST:event_VolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton BuscadorCafeteria;
    private javax.swing.JButton EditarCafeteria;
    private javax.swing.JButton EliminarCafeteria;
    private javax.swing.JButton InsertarCafeteria;
    private javax.swing.JButton Volver;
    private javax.swing.JTextField buscCafeteria;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaCafeterias;
    // End of variables declaration//GEN-END:variables
}
