package br.uniamerica.dao;

import br.uniamerica.Lembrete;
import br.uniamerica.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PessoaDAO {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager em;

    public PessoaDAO() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("jparelacionamento");
        this.em = this.entityManagerFactory.createEntityManager();
    }

    public void save(Pessoa pessoa) {
        if (pessoa.getId() <= 0l) {
            em.getTransaction().begin();
            em.persist(pessoa);
            em.getTransaction().commit();
        } else {
            em.getTransaction().begin();
            em.merge(pessoa);
            em.getTransaction().commit();
        }
    }

    public List<Pessoa> findAll() {
        return em.createQuery("from Pessoa").getResultList();
    }

    public Pessoa findById(Long id) {
        return em.find(Pessoa.class, id);
    }

    public List<Lembrete> findAllLembretes(Pessoa pessoa) {
        Pessoa pessoaDAOById = this.findById(pessoa.getId());
        return em.createQuery("from Lembrete where pessoa = " + pessoaDAOById.getId()).getResultList();
    }

    public void remove(Long id) {
        em.getTransaction().begin();
        Pessoa pessoa = em.find(Pessoa.class, 1L);
        if (pessoa != null) {
            em.remove(pessoa);
        }
        em.getTransaction().commit();
    }
}
