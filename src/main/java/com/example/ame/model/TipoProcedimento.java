package com.example.ame.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_tipo_procedimento")
public class TipoProcedimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_procedimento")
    private Integer id;

    @Column(name = "nome")
    private String name;

    public TipoProcedimento() {
    }

    public TipoProcedimento(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
