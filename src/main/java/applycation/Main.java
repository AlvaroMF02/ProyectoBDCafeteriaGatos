package applycation;

import controllers.Controlador;
import entities.Cafeteria;
import entities.Encargado;
import entities.Gato;
import java.util.List;

/**
 *
 * @author alvaro
 */
public class Main {
    
    /*
     ----Prueba los métodos de consulta incluidos en los controladores
    Prueba a crear una entidad de cada tipo
    Prueba a modificar una entidad de cada tipo
    Prueba a borrar una entidad de cada tipo
    */
    
    public static void main(String[] args) {
        // CONTROLADOR CON TODOS LOS METODOS DE JPA NECESARIOS
        Controlador controlador = new Controlador();
        
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
        
    }
}
