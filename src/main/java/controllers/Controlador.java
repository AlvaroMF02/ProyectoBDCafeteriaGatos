package controllers;

import controllers.exceptions.IllegalOrphanException;
import controllers.exceptions.NonexistentEntityException;
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

    // # # # # # # # # # # METODOS ENCARGADOS # # # # # # # # # # //
    // OBTENER A TODOS LOS ENCARGADOS
    public List<Encargado> obtenerEncargados() {
        contEncargado = new EncargadoJpaController();
        return contEncargado.findEncargadoEntities();
    }

    // CREAR ENCARGADO
    public void crearEncargado(Encargado encargado) {
        contEncargado = new EncargadoJpaController();
        contEncargado.create(encargado);
    }

    // MODIFICAR ENCARGADO
    public void editarEncargado(Encargado encargado) throws NonexistentEntityException, Exception {
        contEncargado = new EncargadoJpaController();
        contEncargado.edit(encargado);
    }

    // # # #  # # # # # # # # METODOS GATOS # # # # # # # # # # # //
    // OBTENER A TODOS LOS GATOS
    public List<Gato> obtenerGatos() {
        contGato = new GatoJpaController();
        return contGato.findGatoEntities();
    }

    // CREAR GATOS
    public void crearGato(Gato gato) {
        contGato = new GatoJpaController();
        contGato.create(gato);
    }
    
    // MODIFICAR GATOS
    public void editarGato(Gato gato) throws NonexistentEntityException, Exception {
        contGato = new GatoJpaController();
        contGato.edit(gato);
    }

    // # # # # # # # # # # METODOS CAFETERIAS # # # # # # # # # # //
    // OBTENER TODAS LAS CAFETERIAS
    public List<Cafeteria> obtenerCafeterias() {
        contCafeteria = new CafeteriaJpaController();
        return contCafeteria.findCafeteriaEntities();
    }

    // CREAR CAFETERIAS
    public void crearCafeteria(Cafeteria cafeteria) throws IllegalOrphanException {
        contCafeteria = new CafeteriaJpaController();
        contCafeteria.create(cafeteria);
    }
    
    // MODIFICAR CAFETERIA
    public void editarCafeteria(Cafeteria cafeteria) throws NonexistentEntityException, Exception {
        contCafeteria = new CafeteriaJpaController();
        contCafeteria.edit(cafeteria);
    }

}
