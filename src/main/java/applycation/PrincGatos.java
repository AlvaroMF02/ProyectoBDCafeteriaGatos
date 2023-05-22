package applycation;

import controllers.Controlador;
import controllers.exceptions.IllegalOrphanException;
import controllers.exceptions.NonexistentEntityException;
import entities.Gato;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Álvaro
 */
public class PrincGatos extends javax.swing.JFrame {

    private Controlador controlador = new Controlador();

    public PrincGatos() {
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
        String titulos[] = {"ID", "Nombre", "Raza", "Edad", "Cafetería"};
        modeloTabla.setColumnIdentifiers(titulos);

        // LECTURA DE LOS DATOS A LA TABLA
        List<Gato> gatos = controlador.obtenerGatos();

        if (gatos != null) {
            for (Gato gat : gatos) {
                Object[] obj = {gat.getId(), gat.getNombre(),
                    gat.getRaza(), gat.getEdad(), gat.getIdCafeteria()};

                // AÑADIR LA FILA
                modeloTabla.addRow(obj);
            }
        }

        tablaGatos.setModel(modeloTabla);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaGatos = new javax.swing.JTable();
        Actualizar = new javax.swing.JButton();
        Volver = new javax.swing.JButton();
        EliminarGato = new javax.swing.JButton();
        EditarGato = new javax.swing.JButton();
        InsertarGato = new javax.swing.JButton();
        botonBuscador = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        textBuscGato = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(41, 30, 28));

        jLabel2.setBackground(new java.awt.Color(160, 126, 120));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(160, 126, 120));
        jLabel2.setText("GATOS");

        jPanel2.setBackground(new java.awt.Color(160, 126, 120));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tablaGatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaGatos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        EliminarGato.setBackground(new java.awt.Color(160, 126, 120));
        EliminarGato.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        EliminarGato.setForeground(new java.awt.Color(41, 30, 28));
        EliminarGato.setText("Eliminar");
        EliminarGato.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        EliminarGato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarGatoActionPerformed(evt);
            }
        });

        EditarGato.setBackground(new java.awt.Color(160, 126, 120));
        EditarGato.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        EditarGato.setForeground(new java.awt.Color(41, 30, 28));
        EditarGato.setText("Editar");
        EditarGato.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        EditarGato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarGatoActionPerformed(evt);
            }
        });

        InsertarGato.setBackground(new java.awt.Color(160, 126, 120));
        InsertarGato.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        InsertarGato.setForeground(new java.awt.Color(41, 30, 28));
        InsertarGato.setText("Añadir");
        InsertarGato.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        InsertarGato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertarGatoActionPerformed(evt);
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

        jLabel3.setForeground(new java.awt.Color(160, 126, 120));
        jLabel3.setText("Busqueda por código");
        jLabel3.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(textBuscGato)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(InsertarGato, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(jLabel3))
                        .addComponent(EditarGato, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(EliminarGato, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonBuscador)
                            .addComponent(textBuscGato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(InsertarGato, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(EditarGato, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(EliminarGato, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Actualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(64, 64, 64))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed

        cargarTabla();
    }//GEN-LAST:event_ActualizarActionPerformed

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        // "CIERRA" LA VENTANA
        this.dispose();
    }//GEN-LAST:event_VolverActionPerformed

    private void EliminarGatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarGatoActionPerformed
        Integer id;
        
        // SE TIENE QUE MIRAR QUE SE HAYA SELECCIONADO UNA FILA Y QUE NO ESTE VACIA
        if (tablaGatos.getRowCount() > 0) {
            // SI ESTA SELECCIONADO
            if (tablaGatos.getSelectedRow() != -1) {
                // FILA SELECCIONADA COLUMNA 0
                id = Integer.valueOf(String.valueOf(tablaGatos.getValueAt(tablaGatos.getSelectedRow(), 0)));

                // METODO JPA PARA ELIMINAR
                try {
                    controlador.eliminarEncargado(id);
                } catch (NonexistentEntityException ex) {
                } catch (IllegalOrphanException ex) {
                    JOptionPane.showMessageDialog(null, "No se puede eliminar a este gato");
                }

                cargarTabla();

            } else {
                JOptionPane.showMessageDialog(null, "No ha seleccionado nada");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No ha seleccionado nada");
        }
    }//GEN-LAST:event_EliminarGatoActionPerformed

    private void EditarGatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarGatoActionPerformed
        Integer id;

        // SE TIENE QUE MIRAR QUE SE HAYA SELECCIONADO UNA FILA Y QUE NO ESTE VACIA
        if (tablaGatos.getRowCount() > 0) {
            // SI ESTA SELECCIONADO
            if (tablaGatos.getSelectedRow() != -1) {

                // FILA x SELECCIONADA COLUMNA 0
                id = Integer.valueOf(String.valueOf(tablaGatos.getValueAt(tablaGatos.getSelectedRow(), 0)));

                EditarGato consultaGat = new EditarGato(id);
                consultaGat.setVisible(true);
                consultaGat.setLocationRelativeTo(null);

            } else {
                JOptionPane.showMessageDialog(null, "No ha seleccionado nada");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No ha seleccionado nada");
        }
    }//GEN-LAST:event_EditarGatoActionPerformed

    private void InsertarGatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertarGatoActionPerformed
        InsertarGato insercion = new InsertarGato();
        insercion.setVisible(true);
        insercion.setLocationRelativeTo(null);
    }//GEN-LAST:event_InsertarGatoActionPerformed

    private void botonBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscadorActionPerformed

        Gato gatoBuscar;

        // TRY CATCH POR EL NULL POINTER
        try {
            //BUSCAR GATO Y MOSTRARLO POR PANTALLA
            gatoBuscar = controlador.gatoPorId(Integer.valueOf(textBuscGato.getText()));

            JOptionPane.showMessageDialog(null, "### Cafeteria Buscado ###\n\n"
                    + "Id: " + gatoBuscar.getId() + "\n"
                    + "Nombre: " + gatoBuscar.getNombre() + "\n"
                    + "Raza: " + gatoBuscar.getRaza() + "\n"
                    + "Edad: " + gatoBuscar.getEdad() + "\n"
                    + "Cafetería: " + gatoBuscar.getIdCafeteria() + "\n");

        } catch (NullPointerException | NumberFormatException npe) {
            JOptionPane.showMessageDialog(null, "El gato no existe");
        }

        // PONER EN BLANCO
        textBuscGato.setText("");

    }//GEN-LAST:event_botonBuscadorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton EditarGato;
    private javax.swing.JButton EliminarGato;
    private javax.swing.JButton InsertarGato;
    private javax.swing.JButton Volver;
    private javax.swing.JButton botonBuscador;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaGatos;
    private javax.swing.JTextField textBuscGato;
    // End of variables declaration//GEN-END:variables
}
