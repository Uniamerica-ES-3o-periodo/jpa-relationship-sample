//package br.uniamerica;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import java.util.List;
//
//public class Main {
//    private static EntityManagerFactory entityManagerFactory;
//
//    public static void main(String[] args) {
//        entityManagerFactory = Persistence.createEntityManagerFactory("jparelacionamento");
//
//        EntityManager em = entityManagerFactory.createEntityManager();
//
//        Pessoa fred = new Pessoa();
//        fred.setNome("Joao");
//
//        Lembrete lembreteFred = new Lembrete();
//        lembreteFred.setTitulo("Teste 2");
//        lembreteFred.setDescricao("As 23h");
//        lembreteFred.setPessoa(fred);
//
//        try {
//            em.getTransaction().begin();
//            System.out.println("======== INSERINDO.... =========");
//            em.persist(fred);
//            em.persist(lembreteFred);
//            em.getTransaction().commit();
//            System.out.println("======== INSERT OK =========");
//        } catch (Exception e) {
//            em.getTransaction().rollback();
//            System.out.println("INSERT: " + e.getMessage());
//        } finally {
//            em.close();
//        }
//    }
//}
