package applycation;

import controllers.CafeteriaJpaController;
import controllers.Controlador;
import controllers.EncargadoJpaController;
import controllers.GatoJpaController;
import entities.Encargado;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Álvaro
 */
public class RestaurarCopia extends javax.swing.JFrame {

    private Controlador controlador = new Controlador();

    public RestaurarCopia() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaRest = new javax.swing.JTable();
        Restaurar = new javax.swing.JButton();
        voolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(41, 30, 28));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(160, 126, 120));
        jLabel2.setText("RESTAURACIÓN");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tablaRest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaRest);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Restaurar.setBackground(new java.awt.Color(160, 126, 120));
        Restaurar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Restaurar.setForeground(new java.awt.Color(41, 30, 28));
        Restaurar.setText("Restaurar");
        Restaurar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Restaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RestaurarActionPerformed(evt);
            }
        });

        voolver.setBackground(new java.awt.Color(160, 126, 120));
        voolver.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        voolver.setForeground(new java.awt.Color(41, 30, 28));
        voolver.setText("Volver");
        voolver.setActionCommand("");
        voolver.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        voolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Restaurar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(voolver, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Restaurar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(voolver)))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RestaurarActionPerformed
        String copia = "";

        // SE TIENE QUE MIRAR QUE SE HAYA SELECCIONADO UNA FILA Y QUE NO ESTE VACIA
        if (tablaRest.getRowCount() > 0) {
            
            // SI ESTA SELECCIONADO
            if (tablaRest.getSelectedRow() != -1) {

                // FILA x SELECCIONADA COLUMNA 0
                copia = String.valueOf(tablaRest.getValueAt(tablaRest.getSelectedRow(), 0));

            } else {
                JOptionPane.showMessageDialog(null, "No ha seleccionado nada");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No ha seleccionado nada");
        }
        
        // 
        restaurar(copia);

    }//GEN-LAST:event_RestaurarActionPerformed

    private void voolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_voolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Restaurar;
    private javax.swing.JButton Volver;
    private javax.swing.JButton Volver1;
    private javax.swing.JButton Volver2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaRest;
    private javax.swing.JButton voolver;
    // End of variables declaration//GEN-END:variables

    public void cargarTabla() {

        // LISTA PARA ALMACENAR LOS FICHEROS
        List<String> copias = new ArrayList<>();

        File f = new File("copias/");

        if (f.exists()) {
            // Obtiene los ficheros y directorios dentro de f y los 
            // devuelve en un array
            File[] ficheros = f.listFiles();

            for (File file2 : ficheros) {
                copias.add(file2.getName());
            }

        } else {
            System.out.println("El directorio a listar no existe");
        }
        

        // PARA QUE NO SE PUEDA EDITAR LA TABLA
        DefaultTableModel modeloTabla = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }

        };

        // TITULOS DE LAS COLUMNAS
        String titulos[] = {"Copias"};
        modeloTabla.setColumnIdentifiers(titulos);

        if (copias != null) {
            for (String s : copias) {
                Object[] obj = {s};

                // AÑADIR LA FILA
                modeloTabla.addRow(obj);
            }
        }

        tablaRest.setModel(modeloTabla);
    }
    
    private static void restaurar(String ruta){
        
        
                
        
        // BORRAR LAS TABLAS CREANDO QUERIS
        

        
        
    }
}
