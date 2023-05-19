package applycation;

import controllers.Controlador;
import controllers.exceptions.IllegalOrphanException;
import controllers.exceptions.NonexistentEntityException;
import entities.Cafeteria;
import entities.Encargado;
import entities.Gato;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author alvaro
 */
public class Main {

    /* TO DO
    
    -- Prueba a borrar una entidad de cada tipo 
    
    CONTROLAR TODAS LAS POSIBLES EXCEPCIONES
    
    ELIMINAR TODOS LOS DATOS DE LAS TABLAS PARA VOLVER A HACER TODAS LAS PRUEBAS 
    DE NUEVO Y VER SI SE PUEDE BORRAR TODO BIEN
    
     */
    public static void main(String[] args) throws IllegalOrphanException, Exception {
        // CONTROLADOR CON TODOS LOS METODOS DE JPA NECESARIOS
        Controlador controlador = new Controlador();
        Date fecha = Date.from(Instant.now());

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
        Encargado crearEncargado = new Encargado(4, "Álvaro", "Martínez", 20);
        // controlador.crearEncargado(crearEncargado);
        encargados.forEach(System.out::println);

        // CREAR UNA ENTIDAD CAFETERIA
        System.out.println("\n#### AÑADIR UNA CAFETERÍA NUEVA ####");
        Cafeteria cafeteriaNueva = new Cafeteria(4, "Gaturro", fecha,
                BigDecimal.valueOf(987.50), crearEncargado, gatos);
        // controlador.crearCafeteria(cafeteriaNueva);
        cafeterias.forEach(System.out::println);

        // CREAR UNA ENTIDAD GATO
        System.out.println("\n#### AÑADIR UN GATO NUEVO ####");
        Gato crearGato = new Gato(0, "Kim", "Persa", 4, cafeteriaNueva);
        // controlador.crearGato(crearGato);
        gatos.forEach(System.out::println);

        // AL EDITAR HAY QUE TENER MUCHO CUIDADO EN LOS ID DE CAFETERIA Y GATO
        // MODIFICAR UNA ENTIDAD CAFETERIA
        System.out.println("\n\n\n#### MODIFICACIÓN DE UNA CAFETERIA (3, CAMBIO DE COSTES) ####");
        List<Gato> listaGatosVacia = new ArrayList<>();
        Cafeteria cafeteriaEditada = new Cafeteria(3, "Michiss", fecha,
                BigDecimal.valueOf(289.50), crearEncargado, listaGatosVacia);
        //controlador.editarCafeteria(cafeteriaEditada);
        cafeterias.forEach(System.out::println);

        // MODIFICAR UNA ENTIDAD GATO
        System.out.println("\n#### MODIFICACIÓN DE UN GATO (4, CAMBIO DE EDAD) ####");
        Gato gatoEditado = new Gato(4, "Kim", "Persa", 2, cafeteriaNueva);
        //controlador.editarGato(gatoEditado);
        gatos.forEach(System.out::println);

        // MODIFICAR UNA ENTIDAD ENCARGADO
        System.out.println("\n#### MODIFICACIÓN DE UN ENCARGADO (5, CAMBIO DE NOMBRE, APELLIDO Y EDAD) ####");
        Encargado encargadoEditado = new Encargado(5, "Juán", "Palomar", 24);
        // controlador.editarEncargado(encargadoEditado);
        encargados.forEach(System.out::println);

        // ELIMINAR ENCARGADO (NO TIENEN RELACIÓN)                              CAMBIAR DATOS PARA QUE ACEPTE NULOS
        System.out.println("\n\n\n#### BORRADO DE UN ENCARGADO (6) ####");
        try {
            controlador.eliminarEncargado(6);
            encargados.forEach(System.out::println);
        } catch (NonexistentEntityException nee) {
            System.out.println("Ese encargado no existe");
        }

        // ELIMINAR GATO (RELACIONADA CAFETERIA)
        System.out.println("\n#### BORRADO DE UN GATO (4) ####");
        try {
            controlador.eliminarGato(4);
            gatos.forEach(System.out::println);
        } catch (NonexistentEntityException nee) {
            System.out.println("Ese gato no existe");
        }

        // ELIMINAR CAFETERIA (RELACIONADA CON ENCARGADO Y DATO)
        System.out.println("\n#### BORRADO DE UNA CAFETERIA (1) ####");
        controlador.eliminarCafeteria(1);
        
        
    }
}
