package it.epicode.g2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.Date;

public class EventoDAO {

        private static final String PERSISTENCE_UNIT = "JPA_Sample";

    EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
    EntityManager em = emf.createEntityManager();

    public void save() {

        var e = new Evento(1L, "titolo1", new Date(), "prova", TipoEvento.PUBBLICO, 100);

        EntityTransaction trans = em.getTransaction();

        trans.begin();
        em.persist(e);
        trans.commit();
        em.close();
        emf.close();
    }

    public Evento getById(Long id){
        return em.find(Evento.class, id);
    }

    public void delete(Long id){

        EntityTransaction trans = em.getTransaction();

        trans.begin();
        em.remove(getById(id));
        trans.commit();
        em.close();
        emf.close();
    }
}
