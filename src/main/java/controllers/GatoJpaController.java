package controllers;

import controllers.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Cafeteria;
import entities.Gato;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author alvaro
 */
public class GatoJpaController implements Serializable {

    public GatoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Gato gato) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cafeteria idCafeteria = gato.getIdCafeteria();
            if (idCafeteria != null) {
                idCafeteria = em.getReference(idCafeteria.getClass(), idCafeteria.getId());
                gato.setIdCafeteria(idCafeteria);
            }
            em.persist(gato);
            if (idCafeteria != null) {
                idCafeteria.getGatoList().add(gato);
                idCafeteria = em.merge(idCafeteria);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Gato gato) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Gato persistentGato = em.find(Gato.class, gato.getId());
            Cafeteria idCafeteriaOld = persistentGato.getIdCafeteria();
            Cafeteria idCafeteriaNew = gato.getIdCafeteria();
            if (idCafeteriaNew != null) {
                idCafeteriaNew = em.getReference(idCafeteriaNew.getClass(), idCafeteriaNew.getId());
                gato.setIdCafeteria(idCafeteriaNew);
            }
            gato = em.merge(gato);
            if (idCafeteriaOld != null && !idCafeteriaOld.equals(idCafeteriaNew)) {
                idCafeteriaOld.getGatoList().remove(gato);
                idCafeteriaOld = em.merge(idCafeteriaOld);
            }
            if (idCafeteriaNew != null && !idCafeteriaNew.equals(idCafeteriaOld)) {
                idCafeteriaNew.getGatoList().add(gato);
                idCafeteriaNew = em.merge(idCafeteriaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = gato.getId();
                if (findGato(id) == null) {
                    throw new NonexistentEntityException("The gato with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Gato gato;
            try {
                gato = em.getReference(Gato.class, id);
                gato.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The gato with id " + id + " no longer exists.", enfe);
            }
            Cafeteria idCafeteria = gato.getIdCafeteria();
            if (idCafeteria != null) {
                idCafeteria.getGatoList().remove(gato);
                idCafeteria = em.merge(idCafeteria);
            }
            em.remove(gato);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Gato> findGatoEntities() {
        return findGatoEntities(true, -1, -1);
    }

    public List<Gato> findGatoEntities(int maxResults, int firstResult) {
        return findGatoEntities(false, maxResults, firstResult);
    }

    private List<Gato> findGatoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Gato.class));
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

    public Gato findGato(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Gato.class, id);
        } finally {
            em.close();
        }
    }

    public int getGatoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Gato> rt = cq.from(Gato.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
