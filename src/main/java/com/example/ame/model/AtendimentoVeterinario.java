package com.example.ame.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_atendimento_veterinario")
public class AtendimentoVeterinario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atendimento_veterinario")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_atendimento")
    private Atendimento atendimento;

    @Column(name = "anamnese")
    private String anamnesis;

    @Column(name = "tratamento")
    private String treatment;

    @Column(name = "id_tipo_procedimento")
    private Integer procedureKind;

    public AtendimentoVeterinario() {
    }

    public AtendimentoVeterinario(Integer id, Atendimento atendimento, String anamnesis, String treatment, Integer procedureKind) {
        this.id = id;
        this.atendimento = atendimento;
        this.anamnesis = anamnesis;
        this.treatment = treatment;
        this.procedureKind = procedureKind;
    }

    public Integer getId() {
        return id;
    }

    public Atendimento getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }

    public String getAnamnesis() {
        return anamnesis;
    }

    public void setAnamnesis(String anamnesis) {
        this.anamnesis = anamnesis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public Integer getProcedureKind() {
        return procedureKind;
    }

    public void setProcedureKind(Integer procedureKind) {
        this.procedureKind = procedureKind;
    }
}
