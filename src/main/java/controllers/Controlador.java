package controllers;

import entities.Cafeteria;
import entities.Encargado;
import entities.Gato;
import java.util.List;

/**
 *
 * @author Álvaro
 */
public class Controlador {
    
    private EncargadoJpaController contEncargado;
    private GatoJpaController contGato;
    private CafeteriaJpaController contCafeteria;
    
    // OBTENER A TODOS LOS ENCARGADOS
    public List<Encargado> obtenerEncargados(){
        contEncargado = new EncargadoJpaController();
        return contEncargado.findEncargadoEntities();
    }
    
    // OBTENER A TODOS LOS GATOS
    public List<Gato> obtenerGatos(){
        contGato = new GatoJpaController();
        return contGato.findGatoEntities();
    }
    
    // OBTENER TODAS LAS CAFETERIAS
    public List<Cafeteria> obtenerCafeterias(){
        contCafeteria = new CafeteriaJpaController();
        return contCafeteria.findCafeteriaEntities();
    }
    
}
