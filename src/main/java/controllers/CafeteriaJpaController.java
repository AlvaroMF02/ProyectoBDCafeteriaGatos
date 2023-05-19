package controllers;

import controllers.exceptions.IllegalOrphanException;
import controllers.exceptions.NonexistentEntityException;
import entities.Cafeteria;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Encargado;
import entities.Gato;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author alvaro
 */
public class CafeteriaJpaController implements Serializable {

    public CafeteriaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cafeteria cafeteria) throws IllegalOrphanException {
        if (cafeteria.getGatoList() == null) {
            cafeteria.setGatoList(new ArrayList<Gato>());
        }
        List<String> illegalOrphanMessages = null;
        Encargado idEncargadoOrphanCheck = cafeteria.getIdEncargado();
        if (idEncargadoOrphanCheck != null) {
            Cafeteria oldCafeteriaOfIdEncargado = idEncargadoOrphanCheck.getCafeteria();
            if (oldCafeteriaOfIdEncargado != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The Encargado " + idEncargadoOrphanCheck + " already has an item of type Cafeteria whose idEncargado column cannot be null. Please make another selection for the idEncargado field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Encargado idEncargado = cafeteria.getIdEncargado();
            if (idEncargado != null) {
                idEncargado = em.getReference(idEncargado.getClass(), idEncargado.getId());
                cafeteria.setIdEncargado(idEncargado);
            }
            List<Gato> attachedGatoList = new ArrayList<Gato>();
            for (Gato gatoListGatoToAttach : cafeteria.getGatoList()) {
                gatoListGatoToAttach = em.getReference(gatoListGatoToAttach.getClass(), gatoListGatoToAttach.getId());
                attachedGatoList.add(gatoListGatoToAttach);
            }
            cafeteria.setGatoList(attachedGatoList);
            em.persist(cafeteria);
            if (idEncargado != null) {
                idEncargado.setCafeteria(cafeteria);
                idEncargado = em.merge(idEncargado);
            }
            for (Gato gatoListGato : cafeteria.getGatoList()) {
                Cafeteria oldIdCafeteriaOfGatoListGato = gatoListGato.getIdCafeteria();
                gatoListGato.setIdCafeteria(cafeteria);
                gatoListGato = em.merge(gatoListGato);
                if (oldIdCafeteriaOfGatoListGato != null) {
                    oldIdCafeteriaOfGatoListGato.getGatoList().remove(gatoListGato);
                    oldIdCafeteriaOfGatoListGato = em.merge(oldIdCafeteriaOfGatoListGato);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cafeteria cafeteria) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cafeteria persistentCafeteria = em.find(Cafeteria.class, cafeteria.getId());
            Encargado idEncargadoOld = persistentCafeteria.getIdEncargado();
            Encargado idEncargadoNew = cafeteria.getIdEncargado();
            List<Gato> gatoListOld = persistentCafeteria.getGatoList();
            List<Gato> gatoListNew = cafeteria.getGatoList();
            List<String> illegalOrphanMessages = null;
            if (idEncargadoNew != null && !idEncargadoNew.equals(idEncargadoOld)) {
                Cafeteria oldCafeteriaOfIdEncargado = idEncargadoNew.getCafeteria();
                if (oldCafeteriaOfIdEncargado != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The Encargado " + idEncargadoNew + " already has an item of type Cafeteria whose idEncargado column cannot be null. Please make another selection for the idEncargado field.");
                }
            }
            for (Gato gatoListOldGato : gatoListOld) {
                if (!gatoListNew.contains(gatoListOldGato)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Gato " + gatoListOldGato + " since its idCafeteria field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idEncargadoNew != null) {
                idEncargadoNew = em.getReference(idEncargadoNew.getClass(), idEncargadoNew.getId());
                cafeteria.setIdEncargado(idEncargadoNew);
            }
            List<Gato> attachedGatoListNew = new ArrayList<Gato>();
            for (Gato gatoListNewGatoToAttach : gatoListNew) {
                gatoListNewGatoToAttach = em.getReference(gatoListNewGatoToAttach.getClass(), gatoListNewGatoToAttach.getId());
                attachedGatoListNew.add(gatoListNewGatoToAttach);
            }
            gatoListNew = attachedGatoListNew;
            cafeteria.setGatoList(gatoListNew);
            cafeteria = em.merge(cafeteria);
            if (idEncargadoOld != null && !idEncargadoOld.equals(idEncargadoNew)) {
                idEncargadoOld.setCafeteria(null);
                idEncargadoOld = em.merge(idEncargadoOld);
            }
            if (idEncargadoNew != null && !idEncargadoNew.equals(idEncargadoOld)) {
                idEncargadoNew.setCafeteria(cafeteria);
                idEncargadoNew = em.merge(idEncargadoNew);
            }
            for (Gato gatoListNewGato : gatoListNew) {
                if (!gatoListOld.contains(gatoListNewGato)) {
                    Cafeteria oldIdCafeteriaOfGatoListNewGato = gatoListNewGato.getIdCafeteria();
                    gatoListNewGato.setIdCafeteria(cafeteria);
                    gatoListNewGato = em.merge(gatoListNewGato);
                    if (oldIdCafeteriaOfGatoListNewGato != null && !oldIdCafeteriaOfGatoListNewGato.equals(cafeteria)) {
                        oldIdCafeteriaOfGatoListNewGato.getGatoList().remove(gatoListNewGato);
                        oldIdCafeteriaOfGatoListNewGato = em.merge(oldIdCafeteriaOfGatoListNewGato);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cafeteria.getId();
                if (findCafeteria(id) == null) {
                    throw new NonexistentEntityException("The cafeteria with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cafeteria cafeteria;
            try {
                cafeteria = em.getReference(Cafeteria.class, id);
                cafeteria.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cafeteria with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Gato> gatoListOrphanCheck = cafeteria.getGatoList();
            for (Gato gatoListOrphanCheckGato : gatoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Cafeteria (" + cafeteria + ") cannot be destroyed since the Gato " + gatoListOrphanCheckGato + " in its gatoList field has a non-nullable idCafeteria field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Encargado idEncargado = cafeteria.getIdEncargado();
            if (idEncargado != null) {
                idEncargado.setCafeteria(null);
                idEncargado = em.merge(idEncargado);
            }
            em.remove(cafeteria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // METODOS DE BUSQUEDA POR NOMBRE POR LAS NAMED QUERY
    // Cafeteria.findByNombre
    public static Cafeteria buscCafetNombre(String nombre) {
        Cafeteria cafetBuscada = new Cafeteria();
        // METER EL COSO ESE

        return cafetBuscada;
    }

    // METODOS DE BUSQUEDA POR COSTE DE PEDIDO POR LAS NAMED QUERY
    // Cafeteria.findByCostePedidoMensu
    public static Cafeteria buscCafetCostePedidos(String nombre) {
        Cafeteria cafetBuscada = new Cafeteria();
        // METER EL COSO ESE

        return cafetBuscada;
    }

    public List<Cafeteria> findCafeteriaEntities() {
        return findCafeteriaEntities(true, -1, -1);
    }

    public List<Cafeteria> findCafeteriaEntities(int maxResults, int firstResult) {
        return findCafeteriaEntities(false, maxResults, firstResult);
    }

    private List<Cafeteria> findCafeteriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cafeteria.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Cafeteria findCafeteria(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cafeteria.class, id);
        } finally {
            em.close();
        }
    }

    public int getCafeteriaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cafeteria> rt = cq.from(Cafeteria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
