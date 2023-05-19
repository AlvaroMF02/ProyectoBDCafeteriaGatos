package applycation;

import controllers.Controlador;
import controllers.exceptions.IllegalOrphanException;
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
    
    /*
    ----Prueba a modificar una entidad de cada tipo
    Prueba a borrar una entidad de cada tipo
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
        System.out.println("\n#### LISTA DE ENCARGADOS AL AÑADIR UNO NUEVO ####");              
        Encargado crearEncargado = new Encargado(4, "Álvaro", "Martínez", 20);
        // controlador.crearEncargado(crearEncargado);
        encargados.forEach(System.out::println);
        
        // CREAR UNA ENTIDAD CAFETERIA
        System.out.println("\n#### LISTA DE CAFETERIA AL AÑADIR UNO NUEVO ####");
        Cafeteria cafeteriaNueva = new Cafeteria(4, "Gaturro", fecha, BigDecimal.valueOf(987.50), crearEncargado,gatos);
        // controlador.crearCafeteria(cafeteriaNueva);
        cafeterias.forEach(System.out::println);
        
        // CREAR UNA ENTIDAD GATO
        System.out.println("\n#### LISTA DE GATOS AL AÑADIR UNO NUEVO ####");
        Gato crearGato = new Gato(0, "Kim", "Persa", 4,cafeteriaNueva);
        // controlador.crearGato(crearGato);
        gatos.forEach(System.out::println);
        
        // MODIFICAR UNA ENTIDAD CAFETERIA
        System.out.println("\n#### MODIFICACIÓN DE UNA CAFETERIA (3, CAMBIO DE COSTES) ####");
        List<Gato> listaGatosVacia = new ArrayList<>();
        Cafeteria cafeteriaEditada = new Cafeteria(3, "Michiss", fecha, BigDecimal.valueOf(289.50), crearEncargado,listaGatosVacia);
        //controlador.editarCafeteria(cafeteriaEditada);
        cafeterias.forEach(System.out::println);
        
        // MODIFICAR UNA ENTIDAD GATO
        System.out.println("\n#### MODIFICACIÓN DE UN GATO (4, CAMBIO DE EDAD) ####");
        Gato gatoEditado = new Gato(4, "Kim", "Persa", 2,cafeteriaNueva);
        //controlador.editarGato(gatoEditado);
        gatos.forEach(System.out::println);
        
        // MODIFICAR UNA ENTIDAD ENCARGADO
        System.out.println("\n#### MODIFICACIÓN DE UN ENCARGADO (5, CAMBIO DE NOMBRE, APELLIDO Y EDAD) ####");
        Encargado encargadoEditado = new Encargado(5, "Juán", "Palomar", 24);
        // controlador.editarEncargado(encargadoEditado);
        encargados.forEach(System.out::println);
        
    }
}
