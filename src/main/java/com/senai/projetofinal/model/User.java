package com.senai.projetofinal.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String usuario;
    @Column
    private String personagem;
    @Column
    private Integer nivel;
    @Column
    private Double pontos;

    @ManyToOne
    @JoinColumn(name = "ranked_id")
    private Ranked ranked;

    public User (){

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPersonagem() {
        return personagem;
    }

    public void setPersonagem(String personagem) {
        this.personagem = personagem;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Double getPontos() {
        return pontos;
    }

    public void setPontos(Double pontos) {
        this.pontos = pontos;
    }

    public Ranked getRanked() {
        return ranked;
    }

    public void setRanked(Ranked ranked) {
        this.ranked = ranked;
    }
}
