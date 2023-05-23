package applycation;

import controllers.Controlador;
import controllers.EncargadoJpaController;
import controllers.exceptions.IllegalOrphanException;
import entities.Cafeteria;
import entities.Encargado;
import entities.Gato;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Álvaro
 */
public class InsertarCafeteria extends javax.swing.JFrame {

    private Controlador controlador = new Controlador();

    public InsertarCafeteria() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        inserNombre = new javax.swing.JTextField();
        inserFech = new javax.swing.JTextField();
        inserCostes = new javax.swing.JTextField();
        inserEncargado = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Volver = new javax.swing.JButton();
        Anyadir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(41, 30, 28));

        jLabel2.setBackground(new java.awt.Color(160, 126, 120));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(160, 126, 120));
        jLabel2.setText("CAFETERÍA NUEVA");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(160, 126, 120));
        jLabel4.setText("Nombre");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(160, 126, 120));
        jLabel5.setText("Fecha Apertura");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(160, 126, 120));
        jLabel6.setText("Costes Mensuales");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(160, 126, 120));
        jLabel7.setText("Encargado (Id)");

        inserNombre.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        inserNombre.setToolTipText("");

        inserFech.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        inserFech.setToolTipText("");

        inserCostes.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        inserCostes.setToolTipText("");

        inserEncargado.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        inserEncargado.setToolTipText("");

        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("año-mes-dia");

        Volver.setText("Volver");
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });

        Anyadir.setText("Añadir");
        Anyadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnyadirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(inserFech, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8))
                            .addComponent(inserNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inserEncargado, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(inserCostes, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Anyadir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(72, 72, 72)
                                .addComponent(Volver)))
                        .addGap(41, 41, 41)))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inserNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inserFech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inserCostes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inserEncargado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Anyadir)
                    .addComponent(Volver))
                .addContainerGap(33, Short.MAX_VALUE))
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

    private void AnyadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnyadirActionPerformed

        Cafeteria cafeteriaInser = new Cafeteria();
        List<Gato> listaVacia = new ArrayList<>();
        Integer idEncarfado = 0;

        // PARSEO Y ASIGNACIÓN
        cafeteriaInser.setId(0);// DA IGUAL PQ ES AUTOINCREMENT
        try {
            idEncarfado = Integer.valueOf(inserEncargado.getText());
            cafeteriaInser.setNombre(inserNombre.getText());
            cafeteriaInser.setCostePedidoMensu(BigDecimal.valueOf(Double.parseDouble(inserCostes.getText())));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Se ha introducido un valor nulo");
        }

        cafeteriaInser.setGatoList(listaVacia);

        // PARSEAR LA FECHA PARA DATE
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); // CAMBIO DE / A -
        try {
            cafeteriaInser.setFecApert(formato.parse(inserFech.getText()));
        } catch (ParseException ex) {
            //JPANEL NO SE HA ESCRITO BIEN LA FECHA
            JOptionPane.showMessageDialog(null, "No se ha introducido bien la fecha");
        }

        EncargadoJpaController controlEnca = new EncargadoJpaController();
        Encargado encargado = controlEnca.findEncargado(idEncarfado);
//        Encargado encargado = controlador.encargPorId(idEncarfado);
        cafeteriaInser.setIdEncargado(encargado);

        // ERROR, EL ENCARGADO NO PUEDE EXISTIR O EL ENCARGADO YA ESTA EN OTRA CAFETERIA
        try {
            controlador.crearCafeteria(cafeteriaInser);
        } catch (IllegalOrphanException ex) {
            JOptionPane.showMessageDialog(null, "El encargado ya está en una cafetería");
        }

        // "CIERRA" LA VENTANA
        this.dispose();

        // ACTUALIZA LA TABLA
        //PrincEncargado.cargarTabla();
    }//GEN-LAST:event_AnyadirActionPerformed

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        // "CIERRA" LA VENTANA
        this.dispose();
    }//GEN-LAST:event_VolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Anyadir;
    private javax.swing.JButton Volver;
    private javax.swing.JTextField inserCostes;
    private javax.swing.JTextField inserEncargado;
    private javax.swing.JTextField inserFech;
    private javax.swing.JTextField inserNombre;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
