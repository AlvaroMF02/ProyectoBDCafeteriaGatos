package applycation;

import controllers.CafeteriaJpaController;
import controllers.Controlador;
import controllers.EncargadoJpaController;
import controllers.exceptions.IllegalOrphanException;
import controllers.exceptions.NonexistentEntityException;
import entities.Cafeteria;
import entities.Encargado;
import entities.Gato;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.NoResultException;
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
        String copia;

        // SE TIENE QUE MIRAR QUE SE HAYA SELECCIONADO UNA FILA Y QUE NO ESTE VACIA
        if (tablaRest.getRowCount() > 0) {

            // SI ESTA SELECCIONADO
            if (tablaRest.getSelectedRow() != -1) {

                // COGER EL NOMBRE DE LA CARPETA
                copia = String.valueOf(tablaRest.getValueAt(tablaRest.getSelectedRow(), 0));

                // BORRADO DE LAS TABLAS
                try {
                    borrado();
                } catch (IllegalOrphanException ex) {
                    Logger.getLogger(RestaurarCopia.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(RestaurarCopia.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(RestaurarCopia.class.getName()).log(Level.SEVERE, null, ex);
                }

                // INSERTAR TODOS LOS DATOS DE LA COPIA DE SEGURIDAD
                try {
                    lecturaEInsercion(copia);
                } catch (ParseException | IllegalOrphanException ex) {
                    Logger.getLogger(RestaurarCopia.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                JOptionPane.showMessageDialog(null, "No ha seleccionado nada");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No ha seleccionado nada");
        }

        this.dispose();
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

    private void borrado() throws IllegalOrphanException, NonexistentEntityException, Exception {
        // BORRAR TODAS LAS TABLAS 
        // 1-GATOS
        List<Gato> gatos = controlador.obtenerGatos();
        for (int i = 0; i < gatos.size(); i++) {
            controlador.eliminarGato(gatos.get(i).getId());
        }

        // 2-CAFETERIAS
        List<Cafeteria> cafes = controlador.obtenerCafeterias();
        for (int i = 0; i < cafes.size(); i++) {
            cafes.get(i).setIdEncargado(null);
            controlador.editarCafeteria(cafes.get(i));
            controlador.eliminarCafeteria(cafes.get(i).getId());
        }

        // 3-ENCARGADOS
        List<Encargado> encargados = controlador.obtenerEncargados();
        for (int i = 0; i < encargados.size(); i++) {
            controlador.eliminarEncargado(encargados.get(i).getId());
        }

    }

    private void lecturaEInsercion(String ruta) throws ParseException, IllegalOrphanException {
        // LEER LOS FICHEROS Y HACER LAS INSERCIONES
        String linea = "";
        String[] tokens;

        // ENCARGADOS
        try ( Scanner datosFichero = new Scanner(new File("copias/" + ruta + "/Encargados.csv"), "ISO_8859_1")) {

            while (datosFichero.hasNextLine()) {

                Encargado encargado = new Encargado();

                linea = datosFichero.nextLine();

                tokens = linea.split(";");

                // LOS LEE CORRECTAMENTE
                // ASIGNAR LOS DATOS DEL ARRAY A UN ENCARGADO
                encargado.setId(Integer.valueOf(tokens[0]));
                encargado.setNombre(tokens[1]);
                encargado.setApellidos(tokens[2]);
                encargado.setEdad(Integer.parseInt(tokens[3]));

                // METER AL ENCARGADO EN LA BD
                controlador.crearEncargado(encargado);

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        // CAFETERIAS
        try ( Scanner datosFichero = new Scanner(new File("copias/" + ruta + "/Cafeterias.csv"), "ISO_8859_1")) {

            while (datosFichero.hasNextLine()) {

                Cafeteria cafe = new Cafeteria();

                linea = datosFichero.nextLine();

                tokens = linea.split(";");

                // ASIGNAR LOS DATOS DEL ARRAY A UN ENCARGADO
                cafe.setId(Integer.valueOf(tokens[0]));
                cafe.setNombre(tokens[1]);
                // METER LA FECHA
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                cafe.setFecApert(formato.parse(tokens[2]));

                cafe.setCostePedidoMensu(BigDecimal.valueOf(Double.parseDouble(tokens[3])));

                // LOS ENCARGADOS NO SE ASIGNARÁN POR SU ID SI NO POR SU NOMBRE 
                EncargadoJpaController cont = new EncargadoJpaController();
                try {
                    Encargado encargado = cont.buscEncargadoPorNombre(tokens[4]);
                    cafe.setIdEncargado(encargado);

                } catch (NoResultException e) {
                }

                // METER AL ENCARGADO EN LA BD
                controlador.crearCafeteria(cafe);

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // GATOS
        try ( Scanner datosFichero = new Scanner(new File("copias/" + ruta + "/Gatos.csv"), "ISO_8859_1")) {

            while (datosFichero.hasNextLine()) {

                Gato gato = new Gato();

                linea = datosFichero.nextLine();

                tokens = linea.split(";");

                // LOS LEE CORRECTAMENTE
                // ASIGNAR LOS DATOS DEL ARRAY A UN ENCARGADO
                gato.setId(Integer.valueOf(tokens[0]));
                gato.setNombre(tokens[1]);
                gato.setRaza(tokens[2]);
                gato.setEdad(Integer.parseInt(tokens[3]));

                // ASIGNAMOS LA CAFETERIA POR SU NOMBRE
                CafeteriaJpaController cont = new CafeteriaJpaController();
                try {
                    Cafeteria cafe = cont.buscCafetPorNombre(tokens[4]);
                    gato.setIdCafeteria(cafe);
                } catch (NullPointerException | NumberFormatException e) {
                }

                // METER AL ENCARGADO EN LA BD
                controlador.crearGato(gato);

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
