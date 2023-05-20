package applycation;

import controllers.Controlador;
import controllers.exceptions.IllegalOrphanException;
import controllers.exceptions.NonexistentEntityException;
import entities.Cafeteria;
import entities.Encargado;
import entities.Gato;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author alvaro
 */
public class MainConsola {

    /* TO DO
        
    PRIMERO SE DEBERIA ASIGNAR UNA LISTA DE GATOS VACIA A CADA CAFETERIA Y DSP IR RELLENANDOLA UNO A UNO
    
    CONTROLAR TODAS LAS POSIBLES EXCEPCIONES
    
    COMO CONTROLO LOS IDS EN LA CREACION, ES COMO SI EN LA BD SE FUERAN ACUMULANDO
    Y DSP AL LLAMAR A UN GATO 4 DICE QUE NO EXISTE PQ EN LA BD NO SE HA GUARDADO CON EL
    ID QUE PENSABA SI NO CON OTRO
    
     */
    public static void main(String[] args) throws IllegalOrphanException, Exception {
        // CONTROLADOR CON TODOS LOS METODOS DE JPA NECESARIOS
        Controlador controlador = new Controlador();
        Date fecha = Date.from(Instant.now());
        List<Gato> listaGatosVacia = new ArrayList<>();

        // CREAR 3 ENCARGADOS
        Encargado e1 = new Encargado(1, "Alberto", "Flores", 20);
        Encargado e2 = new Encargado(2, "Lara", "Coronado", 22);
        Encargado e3 = new Encargado(3, "Juán", "García", 19);

        // CREAR 3 CAFETERIAS   (sin gatos)
        Cafeteria c1 = new Cafeteria(1, "Tudela", fecha, BigDecimal.valueOf(289.50), e3, listaGatosVacia);
        Cafeteria c2 = new Cafeteria(2, "Bonbon", fecha, BigDecimal.valueOf(590.50), e2, listaGatosVacia);
        Cafeteria c3 = new Cafeteria(3, "Gaturro", fecha, BigDecimal.valueOf(987.50), e1, listaGatosVacia);

        // CREAR 3 GATOS        (2 gatos en la cafeteria 3 y uno en la 1)
        Gato g1 = new Gato(1, "Nino", "Persa", 2, c3);
        Gato g2 = new Gato(2, "Luka", "Siames", 5, c3);
        Gato g3 = new Gato(3, "Keca", "Shortair", 1, c1);

        // METODO DE CONSULTA DE ENCARGADO
        List<Encargado> encargados = controlador.obtenerEncargados();
        System.out.println("\n#### LISTA DE ENCARGADOS ####");
        encargados.forEach(System.out::println);

        // METODO DE CONSULTA DE GATO
        List<Gato> gatos = controlador.obtenerGatos();
        System.out.println("\n#### LISTA DE GATOS ####");
        gatos.forEach(System.out::println);

        // METODO DE CONSULTA DE CAFETERIA
        List<Cafeteria> cafeterias = controlador.obtenerCafeterias();
        System.out.println("\n#### LISTA DE CAFETERÍAS ####");
        cafeterias.forEach(System.out::println);

        // CREAR UNA ENTIDAD ENCARGADO
        System.out.println("\n\n\n#### AÑADIR UN ENCARGADO NUEVO ####");
        Encargado e11 = new Encargado(11, "Álvaro", "Martínez", 20);
        // controlador.crearEncargado(e11);
        encargados.forEach(System.out::println);

        // CREAR UNA ENTIDAD CAFETERIA
        System.out.println("\n#### AÑADIR UNA CAFETERÍA NUEVA ####");
        Cafeteria c5 = new Cafeteria(5, "Gaturro", fecha, BigDecimal.valueOf(987.50), e11, listaGatosVacia);
        // controlador.crearCafeteria(c5);
        cafeterias.forEach(System.out::println);

        // CREAR UNA ENTIDAD GATO
        System.out.println("\n#### AÑADIR UN GATO NUEVO ####");
        Gato g11 = new Gato(11, "Michito", "Naranja", 6, c5);
        // controlador.crearGato(g11);
        gatos.forEach(System.out::println);

        // MODIFICAR UNA ENTIDAD GATO
        System.out.println("\n\n\n#### MODIFICACIÓN DE UN GATO (4, CAMBIO DE EDAD) ####");
        Gato gatoEditado = new Gato(4, "Michito", "Naranja", 2, c1);
        // controlador.editarGato(gatoEditado);
        gatos.forEach(System.out::println);

        // AL EDITAR HAY QUE TENER MUCHO CUIDADO EN LOS ID DE CAFETERIA Y GATO
        // MODIFICAR UNA ENTIDAD CAFETERIA
        System.out.println("\n#### MODIFICACIÓN DE UNA CAFETERIA (4, CAMBIO DE NOMBRE Y COSTES) ####");
        Cafeteria cafeteriaEditada = new Cafeteria(4, "MichiFeteria", fecha,
                BigDecimal.valueOf(289.50), e11, listaGatosVacia);
        // controlador.editarCafeteria(cafeteriaEditada);
        cafeterias.forEach(System.out::println);

        // MODIFICAR UNA ENTIDAD ENCARGADO
        System.out.println("\n#### MODIFICACIÓN DE UN ENCARGADO (5) ####");
        Encargado encargadoEditado = new Encargado(5, "Cinthya", "Sanches", 17);
        // controlador.editarEncargado(encargadoEditado);
        encargados.forEach(System.out::println);

        // ELIMINAR ENCARGADO (NO TIENEN RELACIÓN)                              CAMBIAR DATOS PARA QUE ACEPTE NULOS
        System.out.println("\n\n\n#### BORRADO DE UN ENCARGADO (10) ####");
        try {
            controlador.eliminarEncargado(10);
            encargados.forEach(System.out::println);
        } catch (NonexistentEntityException nee) {
            System.out.println("Ese encargado no existe");
        }

        // ELIMINAR GATO (RELACIONADA CAFETERIA)
        System.out.println("\n#### BORRADO DE UN GATO (11) ####");
        try {
            controlador.eliminarGato(11);
            gatos.forEach(System.out::println);
        } catch (NonexistentEntityException nee) {
            System.out.println("Ese gato no existe");
        }

        // ELIMINAR CAFETERIA (RELACIONADA CON ENCARGADO Y DATO)
        System.out.println("\n#### BORRADO DE UNA CAFETERIA (5) ####");
        controlador.eliminarCafeteria(5);

    }
}
