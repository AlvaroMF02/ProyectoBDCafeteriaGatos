package applycation;

import controllers.Controlador;
import entities.Cafeteria;
import entities.Encargado;
import entities.Gato;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.AccessDeniedException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Álvaro
 */
public class Principal extends javax.swing.JFrame {

    Controlador controlador = new Controlador();
    
    public Principal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Cafeterias = new javax.swing.JButton();
        Encargados = new javax.swing.JButton();
        Gatos = new javax.swing.JButton();
        CopiaSeguridad = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(41, 30, 28));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(160, 126, 120));
        jLabel2.setText("CAFETERÍAS MICHIS");

        jLabel3.setForeground(new java.awt.Color(160, 126, 120));
        jLabel3.setText("INSPECCIONAR TABLAS");

        Cafeterias.setBackground(new java.awt.Color(160, 126, 120));
        Cafeterias.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Cafeterias.setForeground(new java.awt.Color(41, 30, 28));
        Cafeterias.setText("CAFETERÍAS");
        Cafeterias.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Cafeterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CafeteriasActionPerformed(evt);
            }
        });

        Encargados.setBackground(new java.awt.Color(160, 126, 120));
        Encargados.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Encargados.setForeground(new java.awt.Color(41, 30, 28));
        Encargados.setText("ENCARGADOS");
        Encargados.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Encargados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EncargadosActionPerformed(evt);
            }
        });

        Gatos.setBackground(new java.awt.Color(160, 126, 120));
        Gatos.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Gatos.setForeground(new java.awt.Color(41, 30, 28));
        Gatos.setText("GATOS");
        Gatos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Gatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GatosActionPerformed(evt);
            }
        });

        CopiaSeguridad.setText("Copia de Seguridad");
        CopiaSeguridad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopiaSeguridadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Cafeterias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Gatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Encargados, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(CopiaSeguridad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addGap(31, 31, 31)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(Cafeterias, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Encargados, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Gatos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CopiaSeguridad)
                .addContainerGap(81, Short.MAX_VALUE))
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

    private void CafeteriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CafeteriasActionPerformed
        PrincCafeterias cafeterias = new PrincCafeterias();
        cafeterias.setVisible(true);
        cafeterias.setLocationRelativeTo(null);
        cafeterias.cargarTabla();

    }//GEN-LAST:event_CafeteriasActionPerformed

    private void EncargadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EncargadosActionPerformed
        PrincEncargados encargados = new PrincEncargados();
        encargados.setVisible(true);
        encargados.setLocationRelativeTo(null);
        encargados.cargarTabla();

    }//GEN-LAST:event_EncargadosActionPerformed

    private void GatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GatosActionPerformed
        PrincGatos gatos = new PrincGatos();
        gatos.setVisible(true);
        gatos.setLocationRelativeTo(null);
        gatos.cargarTabla();
    }//GEN-LAST:event_GatosActionPerformed

    private void CopiaSeguridadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopiaSeguridadActionPerformed
        // LLAMO AL METODO PARA HACER LA COPIA DE SEGURIDAD
        copiaDeSeguridad();
    }//GEN-LAST:event_CopiaSeguridadActionPerformed

    /*
    
    La aplicación debe incluir un sistema de copias de seguridad, de forma que 
    cuando el usuario solicite hacer una copia se debe crear una carpeta nombrada
    según la fecha y hora actuales, bajo la carpeta "copias". En dicha carpeta se 
    deben incluir los datos de las tablas en formato CSV, en archivos separados, 
    con el mismo nombre de la tabla correspondiente. 
    
    Para restaurar una copia, 
    el sistema debe listar las posibles copias existentes en el programa, eligiendo 
    el usuario la copia a volcar. El programa borrará todas las tuplas de todas las 
    tablas y procederá a guardar los datos que haya en los archivos de backup, dejando 
    el sistema en el mismo estado que reflejan los archivos.
    
    Puedes incluir tantas clases como necesites y por supuesto debes utilizar las entidades y controladores creados.
    El proyecto completo se defenderá, corregirá y probará en los equipos del aula por cada alumno/a durante la última semana de clase. 

     */
    private void copiaDeSeguridad() {

        String ruta = DateTimeFormatter.ofPattern("dd-MM-yyyy(hh-mm)")
                .format(LocalDateTime.now());

        Path directory = Paths.get("copias/" + ruta);

        try {
            Files.createDirectory(directory);
        } catch (FileAlreadyExistsException faee) {
            JOptionPane.showMessageDialog(null, "No se puede crear " + ruta + " porque ya existe");
        } catch (AccessDeniedException ade) {
            JOptionPane.showMessageDialog(null, "No tiene permisos para crear " + ruta);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Problema creando el directorio " + ruta);
        }
        
        // LISTAS PARA LA COPIA
        List<Cafeteria> listaCaf = controlador.obtenerCafeterias();
        List<Encargado> listaEnc = controlador.obtenerEncargados();
        List<Gato> listaGat = controlador.obtenerGatos();
        
        // METODOS PARA PASAR A CSV Y HACER LAS COPIAS DE SEGURIDAD
        crearCopiaCafeterias(listaCaf, ruta);
        crearCopiaEncargados(listaEnc, ruta);
        crearCopiaGatos(listaGat, ruta);
    }
    
    // CREACION DE LA COPIA CSV DE CAFETERIAS
    private void crearCopiaCafeterias(List<Cafeteria> listaCaf, String ruta){
        
        List<String> lista = new ArrayList<>();
        
        for (int i = 0; i < listaCaf.size(); i++) {
            lista.add(listaCaf.get(i).toStringCopiaSeguridad());
        }
        
        try {
            Files.write(Paths.get("copias/" + ruta +"/Cafeterias.csv"), lista, StandardCharsets.ISO_8859_1,
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException ex) {
            System.out.println("Error creando el fichero");
        }
    }
    // CREACION DE LA COPIA CSV DE ENCARGADOS
    private void crearCopiaEncargados(List<Encargado> listaEnc, String ruta){
        
        List<String> lista = new ArrayList<>();
        
        for (int i = 0; i < listaEnc.size(); i++) {
            lista.add(listaEnc.get(i).toStringCopiaSeguridad());
        }
        
        try {
            Files.write(Paths.get("copias/" + ruta +"/Encargados.csv"), lista, StandardCharsets.ISO_8859_1,
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException ex) {
            System.out.println("Error creando el fichero");
        }
    }
    // CREACION DE LA COPIA CSV DE GATOS
    private void crearCopiaGatos(List<Gato> listaGat, String ruta){
        
        List<String> lista = new ArrayList<>();
        
        for (int i = 0; i < listaGat.size(); i++) {
            lista.add(listaGat.get(i).toStringCopiaSeguridad());
        }
        
        try {
            Files.write(Paths.get("copias/" + ruta +"/Gatos.csv"), lista, StandardCharsets.ISO_8859_1,
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException ex) {
            System.out.println("Error creando el fichero");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cafeterias;
    private javax.swing.JButton CopiaSeguridad;
    private javax.swing.JButton Encargados;
    private javax.swing.JButton Gatos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
