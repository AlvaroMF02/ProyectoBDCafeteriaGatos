package applycation;

import controllers.Controlador;
import controllers.exceptions.IllegalOrphanException;
import controllers.exceptions.NonexistentEntityException;
import entities.Cafeteria;
import entities.Encargado;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Álvaro
 */
public class EliminarEncargado extends javax.swing.JFrame {

    // NO LO EDITO SOLO LO UTILIZO
    private Integer id;
    private Controlador controlador = new Controlador();

    public EliminarEncargado() {
        initComponents();
    }

    // CONSTRUCTOR CON EL ID DEL ENCARGADO
    public EliminarEncargado(Integer id) {
        initComponents();

        this.id = id;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        no = new javax.swing.JButton();
        si = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(41, 30, 28));

        jLabel2.setBackground(new java.awt.Color(160, 126, 120));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(160, 126, 120));
        jLabel2.setText("ELIMINAR ENCARGADO");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("¿Seguro qué deséa eliminar a este encargado?");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(" Actualmente está trabajando en una cafeteria");

        no.setBackground(new java.awt.Color(160, 126, 120));
        no.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        no.setForeground(new java.awt.Color(41, 30, 28));
        no.setText("No");
        no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noActionPerformed(evt);
            }
        });

        si.setBackground(new java.awt.Color(160, 126, 120));
        si.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        si.setForeground(new java.awt.Color(41, 30, 28));
        si.setText("Si");
        si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(si)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(no))
                                .addComponent(jLabel1)))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(si)
                    .addComponent(no))
                .addContainerGap(23, Short.MAX_VALUE))
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

    private void noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noActionPerformed
        this.dispose();
    }//GEN-LAST:event_noActionPerformed

    private void siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siActionPerformed
        List<Cafeteria> cafeterias = controlador.obtenerCafeterias();
        Encargado encarg = controlador.encargPorId(id);

        // BUSCAR EN QUE CAFETERIA ESTÁ EL ENCARGADO
        for (int i = 0; i < cafeterias.size(); i++) {

            if (encarg.equals(cafeterias.get(i).getIdEncargado())) {

                // PONERLO A NULL EN LA CAFETERIA
                cafeterias.get(i).setIdEncargado(null);
                // EDITAR LA CAFETERIA OCN LOS CAAMBIOS
                try {
                    controlador.editarCafeteria(cafeterias.get(i));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al editar la cafeteria");
                }

                try {
                    // BORRAR AL ENCARGADO
                    controlador.eliminarEncargado(id);
                } catch (IllegalOrphanException | NonexistentEntityException ex) {
                    JOptionPane.showMessageDialog(null, "No se ha puesto a null");
                }
            }

        }
        
        this.dispose();

    }//GEN-LAST:event_siActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton no;
    private javax.swing.JButton si;
    // End of variables declaration//GEN-END:variables
}
