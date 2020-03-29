package br.uniamerica.dao;

import br.uniamerica.Lembrete;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class LembreteDAO {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager em;

    public LembreteDAO() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("jparelacionamento");
        this.em = this.entityManagerFactory.createEntityManager();
    }

    public void save(Lembrete lembrete) {
            em.getTransaction().begin();
            em.persist(lembrete);
            em.getTransaction().commit();
    }

    public void update(Lembrete lembrete) {
        Lembrete byId = findById(lembrete.getId());
        if (byId != null) {
            em.getTransaction().begin();
            em.merge(lembrete);
            em.getTransaction().commit();
        } else {
            System.out.println("Não foi possível achar o lembrete passado como parametro");
        }
    }

    public List<Lembrete> findAll() {
        return em.createQuery("from Lembrete").getResultList();
    }

    public Lembrete findById(Long id) {
        return em.find(Lembrete.class, id);
    }

    public void remove(Long id) {
        em.getTransaction().begin();
        Lembrete lembrete = em.find(Lembrete.class, 1L);
        if (lembrete != null) {
            em.remove(lembrete);
        }
        em.getTransaction().commit();
    }
}
