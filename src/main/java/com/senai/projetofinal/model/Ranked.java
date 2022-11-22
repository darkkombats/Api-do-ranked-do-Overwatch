package com.senai.projetofinal.model;

import javax.persistence.*;

@Entity
@Table(name = "ranked")
public class Ranked {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nome;



    public Ranked (){

    }

    public Ranked (Integer id){
        this.id = id;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
