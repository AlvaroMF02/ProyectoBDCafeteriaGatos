package applycation;

import controllers.Controlador;
import entities.Cafeteria;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Álvaro
 */
public class EditarCafeteria extends javax.swing.JFrame {

    private Controlador controlador = new Controlador();
    private Integer id;

    public EditarCafeteria() {
        initComponents();
    }

    // CONSTRUCTOR PASANDOLE EL CODIGO DE LA TABLA
    public EditarCafeteria(Integer codigo) {
        initComponents();

        // BUSQUEDA DE LA CAFETERIA
        Cafeteria caf = controlador.cafetPorId(codigo);

        // PASAR LOS ATRIBUTOS A TEXTO PARA LA EDICION
        editNombre.setText(caf.getNombre());
        editFecha.setText(caf.getFecApertLocalDate().toString());
        editCosteMens.setText(caf.getCostePedidoMensu().toString());
        try {
            editEncargado.setText(caf.getIdEncargado().getId().toString());
        } catch (NullPointerException e) {
        }

        this.id = codigo;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        editNombre = new javax.swing.JTextField();
        editFecha = new javax.swing.JTextField();
        editCosteMens = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Editar = new javax.swing.JButton();
        Volver = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        editEncargado = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(41, 30, 28));

        jLabel2.setBackground(new java.awt.Color(160, 126, 120));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(160, 126, 120));
        jLabel2.setText("EDITAR CAFETERÍA");

        editNombre.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        editNombre.setToolTipText("");

        editFecha.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        editFecha.setToolTipText("");

        editCosteMens.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        editCosteMens.setToolTipText("");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(160, 126, 120));
        jLabel6.setText("Pedidos Mensuales");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(160, 126, 120));
        jLabel5.setText("Fecha Apertura");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(160, 126, 120));
        jLabel4.setText("Nombre");

        Editar.setText("Editar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });

        Volver.setText("Volver");
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(160, 126, 120));
        jLabel7.setText("Encargado (Id)");

        editEncargado.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        editEncargado.setToolTipText("");

        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("año/mes/dia");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(editFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8))
                            .addComponent(editNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editEncargado, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editCosteMens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(Editar)
                                .addGap(70, 70, 70)
                                .addComponent(Volver)
                                .addGap(46, 46, 46)))))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel2)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(editNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(editFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(editCosteMens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(editEncargado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Editar)
                    .addComponent(Volver))
                .addContainerGap(68, Short.MAX_VALUE))
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

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        Cafeteria cafe = controlador.cafetPorId(id);

        // PARSEO Y ASIGNACIÓN
        cafe.setId(id);

        cafe.setNombre(editNombre.getText());
        cafe.setCostePedidoMensu(BigDecimal.valueOf(Double.parseDouble(editCosteMens.getText())));

        // PARSEAR LA FECHA PARA DATE
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try {
            cafe.setFecApert(formato.parse(editFecha.getText()));
        } catch (ParseException ex) {
            //JPANEL NO SE HA ESCRITO BIEN LA FECHA
            JOptionPane.showMessageDialog(null, "No se ha introducido bien la fecha");
        }

        // PONER ENCARGADO AL EDITAR
        try {
            cafe.setIdEncargado(controlador.encargPorId(Integer.valueOf(editEncargado.getText())));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar al encargado");
        }

        // NO EDITA A LOS QUE ESTÁN ASIGNADOS A UNA CAFETERIA
        try {
            // EDITAR LA FACTURA
            controlador.editarCafeteria(cafe);
        } catch (Exception ex) {
            //JPANEL NO SE HA PODIDO EDITAR
            JOptionPane.showMessageDialog(null, "Ese trabajador está en otra cafeteria");
        }

        // "CIERRA" LA VENTANA
        this.dispose();

    }//GEN-LAST:event_EditarActionPerformed


    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        // "CIERRA" LA VENTANA
        this.dispose();
    }//GEN-LAST:event_VolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Editar;
    private javax.swing.JButton Volver;
    private javax.swing.JTextField editCosteMens;
    private javax.swing.JTextField editEncargado;
    private javax.swing.JTextField editFecha;
    private javax.swing.JTextField editNombre;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
