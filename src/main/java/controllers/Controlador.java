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

    // ELIMINAR UN ENCARGADO
    public void eliminarEncargado(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        contEncargado = new EncargadoJpaController();
        contEncargado.destroy(id);
    }

    // BUSCAR UN ENCARGADO POR EL ID
    public Encargado encargPorId(Integer id) {
        contEncargado = new EncargadoJpaController();
        return contEncargado.findEncargado(id);
    }

    // BORRAR TODA LA TABLA DE ENCARGADO
    public void borrarTablaEncargados() throws IllegalOrphanException, NonexistentEntityException {
        contEncargado = new EncargadoJpaController();
        List<Encargado> lista = obtenerEncargados();

        for (int i = 0; i < lista.size(); i++) {
            contEncargado.destroy(lista.get(i).getId());
        }
        
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

    // ELIMINAR UN GATO
    public void eliminarGato(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        contGato = new GatoJpaController();
        contGato.destroy(id);
    }

    // BUSCAR UN GATO POR EL ID
    public Gato gatoPorId(Integer id) {
        contGato = new GatoJpaController();
        return contGato.findGato(id);
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

    // ELIMINAR UNA CAFETERIA
    public void eliminarCafeteria(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        contCafeteria = new CafeteriaJpaController();
        contCafeteria.destroy(id);
    }

    // BUSCAR UNA CAFETERIA POR EL ID
    public Cafeteria cafetPorId(Integer id) {
        contCafeteria = new CafeteriaJpaController();
        return contCafeteria.findCafeteria(id);
    }

}
