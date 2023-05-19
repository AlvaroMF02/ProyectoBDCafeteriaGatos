package controllers;

import controllers.exceptions.IllegalOrphanException;
import controllers.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Cafeteria;
import entities.Encargado;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author alvaro
 */
public class EncargadoJpaController implements Serializable {

    public EncargadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Encargado encargado) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cafeteria cafeteria = encargado.getCafeteria();
            if (cafeteria != null) {
                cafeteria = em.getReference(cafeteria.getClass(), cafeteria.getId());
                encargado.setCafeteria(cafeteria);
            }
            em.persist(encargado);
            if (cafeteria != null) {
                Encargado oldIdEncargadoOfCafeteria = cafeteria.getIdEncargado();
                if (oldIdEncargadoOfCafeteria != null) {
                    oldIdEncargadoOfCafeteria.setCafeteria(null);
                    oldIdEncargadoOfCafeteria = em.merge(oldIdEncargadoOfCafeteria);
                }
                cafeteria.setIdEncargado(encargado);
                cafeteria = em.merge(cafeteria);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Encargado encargado) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Encargado persistentEncargado = em.find(Encargado.class, encargado.getId());
            Cafeteria cafeteriaOld = persistentEncargado.getCafeteria();
            Cafeteria cafeteriaNew = encargado.getCafeteria();
            List<String> illegalOrphanMessages = null;
            if (cafeteriaOld != null && !cafeteriaOld.equals(cafeteriaNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain Cafeteria " + cafeteriaOld + " since its idEncargado field is not nullable.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (cafeteriaNew != null) {
                cafeteriaNew = em.getReference(cafeteriaNew.getClass(), cafeteriaNew.getId());
                encargado.setCafeteria(cafeteriaNew);
            }
            encargado = em.merge(encargado);
            if (cafeteriaNew != null && !cafeteriaNew.equals(cafeteriaOld)) {
                Encargado oldIdEncargadoOfCafeteria = cafeteriaNew.getIdEncargado();
                if (oldIdEncargadoOfCafeteria != null) {
                    oldIdEncargadoOfCafeteria.setCafeteria(null);
                    oldIdEncargadoOfCafeteria = em.merge(oldIdEncargadoOfCafeteria);
                }
                cafeteriaNew.setIdEncargado(encargado);
                cafeteriaNew = em.merge(cafeteriaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = encargado.getId();
                if (findEncargado(id) == null) {
                    throw new NonexistentEntityException("The encargado with id " + id + " no longer exists.");
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
            Encargado encargado;
            try {
                encargado = em.getReference(Encargado.class, id);
                encargado.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The encargado with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Cafeteria cafeteriaOrphanCheck = encargado.getCafeteria();
            if (cafeteriaOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Encargado (" + encargado + ") cannot be destroyed since the Cafeteria " + cafeteriaOrphanCheck + " in its cafeteria field has a non-nullable idEncargado field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(encargado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // METODOS DE BUSQUEDA POR COSTE DE PEDIDO POR LAS NAMED QUERY
    // Encargado.findByNombre
    public static Encargado buscEncarNombre(String nombre) {
        Encargado encargBusca = new Encargado();
        // METER EL COSO ESE

        return encargBusca;
    }

    // Encargado.findByEdad
    public static Encargado buscEncarEdad(int edad) {
        Encargado encargBusca = new Encargado();
        // METER EL COSO ESE

        return encargBusca;
    }

    public List<Encargado> findEncargadoEntities() {
        return findEncargadoEntities(true, -1, -1);
    }

    public List<Encargado> findEncargadoEntities(int maxResults, int firstResult) {
        return findEncargadoEntities(false, maxResults, firstResult);
    }

    private List<Encargado> findEncargadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Encargado.class));
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

    public Encargado findEncargado(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Encargado.class, id);
        } finally {
            em.close();
        }
    }

    public int getEncargadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Encargado> rt = cq.from(Encargado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
