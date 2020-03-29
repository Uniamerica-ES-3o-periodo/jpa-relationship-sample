package br.uniamerica;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String nome;

    @OneToMany
    List<Lembrete> lembreteList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Lembrete> getLembreteList() {
        return lembreteList;
    }

    public void setLembreteList(List<Lembrete> lembreteList) {
        this.lembreteList = lembreteList;
    }
}
