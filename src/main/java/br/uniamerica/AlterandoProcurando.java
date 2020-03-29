package br.uniamerica;

import br.uniamerica.dao.LembreteDAO;
import br.uniamerica.dao.PessoaDAO;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class AlterandoProcurando {
    private static EntityManagerFactory entityManagerFactory;

    public static void main(String[] args) {

        LembreteDAO lembreteDAO = new LembreteDAO();
        PessoaDAO pessoaDAO = new PessoaDAO();

        Lembrete lembrete = new Lembrete();

        Pessoa pessoa = pessoaDAO.findById(1l);

        lembrete.setPessoa(pessoa);
        lembrete.setTitulo("Teste 1.8");
        lembrete.setDescricao("As 15h");
        lembreteDAO.save(lembrete);

        List<Lembrete> lembretes = lembreteDAO.findAll();
        if (lembretes.size() > 0) {
            for (Lembrete l:
                 lembretes) {
                System.out.println(l.getPessoa().getNome() + " " + l.getDescricao() + " - " + l.getTitulo());
            }
        }

        List<Lembrete> lembreteByPessoa = pessoaDAO.findAllLembretes(pessoa);
        if (lembreteByPessoa.size() > 0) {
            for (Lembrete l:
                    lembreteByPessoa) {
                System.out.println(l.getPessoa().getNome() + " " + l.getDescricao() + " - " + l.getTitulo());
            }
        }


    }
}
